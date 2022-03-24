package com.ufcg.psoft.tccMatch.service.tcc.implementation;

import com.ufcg.psoft.tccMatch.dto.tcc.OrientacaoTccDTO;
import com.ufcg.psoft.tccMatch.dto.tcc.relatorio.RelatorioOrientacaoTccAreaEstudoDTO;
import com.ufcg.psoft.tccMatch.dto.tcc.relatorio.RelatorioOrientacaoTccDTO;
import com.ufcg.psoft.tccMatch.error.exception.*;
import com.ufcg.psoft.tccMatch.mapper.tcc.OrientacaoTccMapper;
import com.ufcg.psoft.tccMatch.model.AreaEstudo;
import com.ufcg.psoft.tccMatch.model.tcc.OrientacaoTcc;
import com.ufcg.psoft.tccMatch.model.tcc.ProblemaOrientacaoTcc;
import com.ufcg.psoft.tccMatch.model.tcc.SolicitacaoOrientacaoTcc;
import com.ufcg.psoft.tccMatch.model.tcc.Tcc;
import com.ufcg.psoft.tccMatch.model.usuario.Professor;
import com.ufcg.psoft.tccMatch.repository.tcc.OrientacaoTccRepository;
import com.ufcg.psoft.tccMatch.service.tcc.OrientacaoTccService;
import com.ufcg.psoft.tccMatch.service.usuario.ProfessorService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class OrientacaoTccServiceImpl implements OrientacaoTccService {

    private final ProfessorService professorService;

    private final OrientacaoTccRepository orientacaoTccRepository;

    private final OrientacaoTccMapper orientacaoTccMapper;

    private void salvarOrientacaoTcc (OrientacaoTcc orientacaoTcc) { orientacaoTccRepository.save(orientacaoTcc); }

    public OrientacaoTcc getOrientacaoTcc (Long id) {
        return orientacaoTccRepository.findById(id)
                .orElseThrow(() -> new EntidadeNaoExisteException("Orientação de TCC", "id", id.toString()));
    }

    public OrientacaoTccDTO criarOrientacaoTcc (OrientacaoTccDTO orientacaoTccDTO) {
        Professor professor = professorService.getProfessor(orientacaoTccDTO.getIdProfessor());

        if (!professor.isDisponivelOrientacao()) {
            throw new ProfessorNaoDisponivelOrientacaoTccException(professor.getId());
        }

        SolicitacaoOrientacaoTcc solicitacaoOrientacaoTcc = professor.getSolicitacaoOrientacao(orientacaoTccDTO.getIdSolicitacao());

        if (!solicitacaoOrientacaoTcc.isAceita()) {
            throw new SolicitacaoOrientacaoTccNaoAceitaException(solicitacaoOrientacaoTcc.getId());
        }

        if (solicitacaoOrientacaoTcc.isVinculadaComTcc()) {
            throw new SolicitacaoOrientacaoTccJaVinculadaComTccException(solicitacaoOrientacaoTcc.getId());
        }

        solicitacaoOrientacaoTcc.setVinculadaComTcc(true);
        professor.diminuirQuotaEmUm();
        professorService.salvarProfessor(professor);

        Tcc tcc = new Tcc();
        tcc.setAluno(solicitacaoOrientacaoTcc.getAluno());
        tcc.setTema(solicitacaoOrientacaoTcc.getTemaTcc());
        tcc.setProfessor(professor);

        OrientacaoTcc orientacaoTcc = new OrientacaoTcc();
        orientacaoTcc.setTcc(tcc);
        orientacaoTcc.setSemestre(orientacaoTccDTO.getSemestre());
        salvarOrientacaoTcc(orientacaoTcc);

        return orientacaoTccMapper.toDTO(orientacaoTcc);
    }

    public OrientacaoTccDTO finalizarOrientacaoTcc (Long id) {
        OrientacaoTcc orientacaoTcc = getOrientacaoTcc(id);

        if (orientacaoTcc.isConcluida()) {
            throw new OrientacaoTccJaFinalizadaException(id);
        }

        orientacaoTcc.finalizar();
        salvarOrientacaoTcc(orientacaoTcc);

        return orientacaoTccMapper.toDTO(orientacaoTcc);
    }

    public List<OrientacaoTccDTO> listarOrientacoesTccEmCursoProfessor (Long id) {
        List<OrientacaoTcc> orientacoesTcc =
                orientacaoTccRepository.findByConcluidaIsFalseAndTccProfessor_Id(id);

        return orientacaoTccMapper.toDTOs(orientacoesTcc);
    }

    public List<OrientacaoTccDTO> listarOrientacoesTcc (Boolean concluida, String semestre) {
        List<OrientacaoTcc> orientacoesTcc =
                orientacaoTccRepository.findByConcluidaAndSemestre(concluida, semestre);

        return orientacaoTccMapper.toDTOs(orientacoesTcc);
    }

    public RelatorioOrientacaoTccDTO gerarRelatorio (String semestre) {
        List<OrientacaoTcc> orientacoesTcc = orientacaoTccRepository.findBySemestre(semestre);

        List<OrientacaoTcc> orientacoesTccFinalizadas = new ArrayList<>();
        List<OrientacaoTcc> orientacoesTccEmCurso = new ArrayList<>();
        Map<String, Integer> contAreasEstudoOrientacoesTccFinalizadas = new HashMap<>();
        Map<String, Integer> contAreasEstudoOrientacoesTccEmCurso = new HashMap<>();

        for (OrientacaoTcc orientacaoTcc : orientacoesTcc) {
            if (orientacaoTcc.isConcluida()) {
                computaOrientacaoTccRelatorio(orientacoesTccFinalizadas, contAreasEstudoOrientacoesTccFinalizadas, orientacaoTcc);
            } else {
                computaOrientacaoTccRelatorio(orientacoesTccEmCurso, contAreasEstudoOrientacoesTccEmCurso, orientacaoTcc);
            }
        }

        RelatorioOrientacaoTccAreaEstudoDTO relatorioOrientacaoTccFinalizadasAreaEstudo =
                gerarRelatorioOrientacaoTccAreaEstudo(orientacoesTccFinalizadas, contAreasEstudoOrientacoesTccFinalizadas);
        RelatorioOrientacaoTccAreaEstudoDTO relatorioOrientacaoTccEmCursoAreaEstudo =
                gerarRelatorioOrientacaoTccAreaEstudo(orientacoesTccEmCurso, contAreasEstudoOrientacoesTccEmCurso);

        RelatorioOrientacaoTccDTO relatorio = new RelatorioOrientacaoTccDTO();
        relatorio.setSemestre(semestre);
        relatorio.setTotalOrientacoesTcc(relatorioOrientacaoTccFinalizadasAreaEstudo.getTotalOrientacoesTcc() + relatorioOrientacaoTccEmCursoAreaEstudo.getTotalOrientacoesTcc());
        relatorio.setFinalizadas(relatorioOrientacaoTccFinalizadasAreaEstudo);
        relatorio.setEmCurso(relatorioOrientacaoTccEmCursoAreaEstudo);

        return relatorio;
    }

    private RelatorioOrientacaoTccAreaEstudoDTO gerarRelatorioOrientacaoTccAreaEstudo(List<OrientacaoTcc> orientacoesTcc, Map<String, Integer> contAreasEstudo) {
        RelatorioOrientacaoTccAreaEstudoDTO relatorio = new RelatorioOrientacaoTccAreaEstudoDTO();

        relatorio.setOrientacoesTcc(orientacaoTccMapper.toDTOs(orientacoesTcc));
        relatorio.setTotalOrientacoesTcc(orientacoesTcc.size());
        relatorio.setTotalOrientacoesTccAreaEstudo(contAreasEstudo);

        return relatorio;
    }

    private void computaOrientacaoTccRelatorio(List<OrientacaoTcc> orientacoesTcc, Map<String, Integer> contAreasEstudo, OrientacaoTcc orientacaoTcc) {
        orientacoesTcc.add(orientacaoTcc);

        for (AreaEstudo areaEstudo : orientacaoTcc.getTcc().getTema().getAreasEstudo()) {
            String nome = areaEstudo.getNome();
            if (contAreasEstudo.containsKey(nome)) {
                contAreasEstudo.put(nome, contAreasEstudo.get(nome) + 1);
            } else {
                contAreasEstudo.put(nome, 1);
            }
        }
    }
}
