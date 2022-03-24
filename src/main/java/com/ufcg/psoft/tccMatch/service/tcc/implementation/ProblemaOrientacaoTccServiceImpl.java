package com.ufcg.psoft.tccMatch.service.tcc.implementation;

import com.ufcg.psoft.tccMatch.dto.tcc.ProblemaOrientacaoTccDTO;
import com.ufcg.psoft.tccMatch.dto.tcc.relatorio.RelatorioProblemaOrientacaoTccDTO;
import com.ufcg.psoft.tccMatch.dto.tcc.relatorio.RelatorioProblemaOrientacaoTccUsuarioDTO;
import com.ufcg.psoft.tccMatch.error.exception.OrientacaoTccUsuarioNaoVinculadoException;
import com.ufcg.psoft.tccMatch.mapper.tcc.ProblemaOrientacaoTccMapper;
import com.ufcg.psoft.tccMatch.model.tcc.OrientacaoTcc;
import com.ufcg.psoft.tccMatch.model.tcc.ProblemaOrientacaoTcc;
import com.ufcg.psoft.tccMatch.model.usuario.UsuarioTcc;
import com.ufcg.psoft.tccMatch.repository.tcc.ProblemaOrientacaoTccRepository;
import com.ufcg.psoft.tccMatch.service.tcc.OrientacaoTccService;
import com.ufcg.psoft.tccMatch.service.tcc.ProblemaOrientacaoTccService;
import com.ufcg.psoft.tccMatch.service.usuario.UsuarioService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class ProblemaOrientacaoTccServiceImpl implements ProblemaOrientacaoTccService {

    private final UsuarioService usuarioService;
    private final OrientacaoTccService orientacaoTccService;

    private final ProblemaOrientacaoTccRepository problemaOrientacaoTccRepository;

    private final ProblemaOrientacaoTccMapper problemaOrientacaoTccMapper;

    private void salvarProblemaOrientacaoTcc(ProblemaOrientacaoTcc problemaOrientacaoTcc) {
        problemaOrientacaoTccRepository.save(problemaOrientacaoTcc);
    }

    public ProblemaOrientacaoTccDTO reportarProblemaOrientacaoTcc (Long idUsuario, ProblemaOrientacaoTccDTO problemaOrientacaoTccDTO) {
        UsuarioTcc usuarioTcc = usuarioService.getUsuarioTcc(idUsuario);
        OrientacaoTcc orientacaoTcc = orientacaoTccService.getOrientacaoTcc(problemaOrientacaoTccDTO.getIdOrientacaoTcc());

        if (!orientacaoTcc.isUsuarioVinculado(usuarioTcc)) {
            throw new OrientacaoTccUsuarioNaoVinculadoException(usuarioTcc.getId(), orientacaoTcc.getId());
        }

        ProblemaOrientacaoTcc problemaOrientacaoTcc = new ProblemaOrientacaoTcc();
        problemaOrientacaoTcc.setProblema(problemaOrientacaoTccDTO.getProblema());
        problemaOrientacaoTcc.setUsuario(usuarioTcc);
        problemaOrientacaoTcc.setOrientacaoTcc(orientacaoTcc);
        salvarProblemaOrientacaoTcc(problemaOrientacaoTcc);

        return problemaOrientacaoTccMapper.toDTO(problemaOrientacaoTcc);
    }

    private RelatorioProblemaOrientacaoTccUsuarioDTO gerarRelatorioUsuario (List<ProblemaOrientacaoTcc> problemasOrientacaoTcc) {
        RelatorioProblemaOrientacaoTccUsuarioDTO relatorio = new RelatorioProblemaOrientacaoTccUsuarioDTO();

        relatorio.setTotalProblemas(problemasOrientacaoTcc.size());
        relatorio.setProblemas(problemaOrientacaoTccMapper.toDTOs(problemasOrientacaoTcc));

        return relatorio;
    }

    public RelatorioProblemaOrientacaoTccDTO gerarRelatorio (String semestre) {
        List<ProblemaOrientacaoTcc> problemasOrientacaoTcc =
                problemaOrientacaoTccRepository.findByOrientacaoTccSemestre(semestre);

        List<ProblemaOrientacaoTcc> problemasOrientacaoTccAluno = new ArrayList<>();
        List<ProblemaOrientacaoTcc> problemasOrientacaoTccProfessor = new ArrayList<>();

        for (ProblemaOrientacaoTcc problemaOrientacaoTcc : problemasOrientacaoTcc) {
            if (problemaOrientacaoTcc.isUsuarioAluno()) {
                problemasOrientacaoTccAluno.add(problemaOrientacaoTcc);
            } else {
                problemasOrientacaoTccProfessor.add(problemaOrientacaoTcc);
            }
        }

        RelatorioProblemaOrientacaoTccUsuarioDTO relatorioAluno = gerarRelatorioUsuario(problemasOrientacaoTccAluno);
        RelatorioProblemaOrientacaoTccUsuarioDTO relatorioProfessor = gerarRelatorioUsuario(problemasOrientacaoTccProfessor);

        RelatorioProblemaOrientacaoTccDTO relatorio = new RelatorioProblemaOrientacaoTccDTO();
        relatorio.setSemestre(semestre);
        relatorio.setTotalProblemas(relatorioAluno.getTotalProblemas() + relatorioProfessor.getTotalProblemas());
        relatorio.setAlunos(relatorioAluno);
        relatorio.setProfessores(relatorioProfessor);

        return relatorio;
    }
}
