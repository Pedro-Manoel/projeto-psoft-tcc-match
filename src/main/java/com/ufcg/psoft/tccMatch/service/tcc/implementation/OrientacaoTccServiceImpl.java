package com.ufcg.psoft.tccMatch.service.tcc.implementation;

import com.ufcg.psoft.tccMatch.dto.tcc.OrientacaoTccDTO;
import com.ufcg.psoft.tccMatch.error.exception.*;
import com.ufcg.psoft.tccMatch.mapper.tcc.OrientacaoTccMapper;
import com.ufcg.psoft.tccMatch.model.tcc.OrientacaoTcc;
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

import java.util.List;

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

    public OrientacaoTccDTO criarOrientacaoTcc (Long idProfessor, OrientacaoTccDTO orientacaoTccDTO) {
        Professor professor = professorService.getProfessor(idProfessor);

        if (!professor.isDisponivelOrientacao()) {
            throw new ProfessorNaoDisponivelOrientacaoTccException(idProfessor);
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
}
