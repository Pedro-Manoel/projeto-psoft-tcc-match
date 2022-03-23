package com.ufcg.psoft.tccMatch.service.tcc.implementation;

import com.ufcg.psoft.tccMatch.dto.tcc.RespostaSolicitacaoOrientacaoTccDTO;
import com.ufcg.psoft.tccMatch.dto.tcc.SolicitacaoOrientacaoTccDTO;
import com.ufcg.psoft.tccMatch.error.exception.SolicitacaoOrientacaoTccInvalidaException;
import com.ufcg.psoft.tccMatch.error.exception.SolicitacaoOrientacaoTccJaRespondidaException;
import com.ufcg.psoft.tccMatch.error.exception.TemaTccInvalidoUsuarioException;
import com.ufcg.psoft.tccMatch.mapper.tcc.RespostaSolicitacaoOrientacaoTccMapper;
import com.ufcg.psoft.tccMatch.mapper.tcc.SolicitacaoOrientacaoTccMapper;
import com.ufcg.psoft.tccMatch.model.tcc.RespostaSolicitacaoOrientacaoTcc;
import com.ufcg.psoft.tccMatch.model.tcc.SolicitacaoOrientacaoTcc;
import com.ufcg.psoft.tccMatch.model.tcc.TemaTcc;
import com.ufcg.psoft.tccMatch.model.usuario.Aluno;
import com.ufcg.psoft.tccMatch.model.usuario.Professor;
import com.ufcg.psoft.tccMatch.notification.event.SolicitacaoOrientacaoTccCriadaEvent;
import com.ufcg.psoft.tccMatch.repository.tcc.SolicitacaoOrientacaoTccRepository;
import com.ufcg.psoft.tccMatch.service.usuario.AlunoService;
import com.ufcg.psoft.tccMatch.service.usuario.ProfessorService;
import com.ufcg.psoft.tccMatch.service.tcc.SolicitacaoOrientacaoTccService;
import com.ufcg.psoft.tccMatch.service.usuario.UsuarioService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class SolicitacaoOrientacaoTccServiceImpl implements SolicitacaoOrientacaoTccService {

    private final SolicitacaoOrientacaoTccRepository solicitacaoOrientacaoTccRepository;

    private final ProfessorService professorService;
    private final AlunoService alunoService;
    private final UsuarioService usuarioService;

    private final ApplicationEventPublisher applicationEventPublisher;

    private final SolicitacaoOrientacaoTccMapper solicitacaoOrientacaoTccMapper;
    private final RespostaSolicitacaoOrientacaoTccMapper respostaSolicitacaoOrientacaoTccMapper;

    private void salvarSolicitacaoOrientacaoTcc(SolicitacaoOrientacaoTcc solicitacaoOrientacaoTcc) {
        solicitacaoOrientacaoTccRepository.save(solicitacaoOrientacaoTcc);
    }

    public SolicitacaoOrientacaoTccDTO solicitarOrientacaoTcc(Long idAluno, SolicitacaoOrientacaoTccDTO solicitacaoOrientacaoTccDTO) {
        Aluno aluno = alunoService.getAluno(idAluno);
        Professor professor = professorService.getProfessor(solicitacaoOrientacaoTccDTO.getIdProfessor());
        TemaTcc temaTcc = professor.getTemaTcc(solicitacaoOrientacaoTccDTO.getTituloTemaTcc());

        SolicitacaoOrientacaoTcc solicitacaoOrientacaoTcc = new SolicitacaoOrientacaoTcc();
        solicitacaoOrientacaoTcc.setAluno(aluno);
        solicitacaoOrientacaoTcc.setTemaTcc(temaTcc);

        if (professor.solicitacaoJaEstaEmAndamento(solicitacaoOrientacaoTcc)) {
            throw new SolicitacaoOrientacaoTccInvalidaException(temaTcc.getTitulo());
        }

        salvarSolicitacaoOrientacaoTcc(solicitacaoOrientacaoTcc);

        professor.adicionarSolicitacaoOrientacaoTcc(solicitacaoOrientacaoTcc);
        usuarioService.salvarUsuario(professor);

        applicationEventPublisher.publishEvent(new SolicitacaoOrientacaoTccCriadaEvent(this, professor, solicitacaoOrientacaoTcc));

        return solicitacaoOrientacaoTccMapper.toDTO(solicitacaoOrientacaoTcc);
    }

    public List<SolicitacaoOrientacaoTccDTO> listarSolicitacoesOrientacoesTccProfessor (Long id) {
        Professor professor = professorService.getProfessor(id);

        List<SolicitacaoOrientacaoTcc> solicitacoesOrientacaoTcc = professor.getSolicitacoesOrientacaoTcc();

        return solicitacaoOrientacaoTccMapper.toDTOs(solicitacoesOrientacaoTcc);
    }

    public SolicitacaoOrientacaoTccDTO responderSolicitacaoOrientacaoTccProfessor(
            Long idProfessor,
            Long idSolicitacao,
            RespostaSolicitacaoOrientacaoTccDTO respostaSolicitacaoOrientacaoTccDTO
    ) {

        Professor professor = professorService.getProfessor(idProfessor);
        SolicitacaoOrientacaoTcc solicitacaoOrientacaoTcc = professor.getSolicitacaoOrientacao(idSolicitacao);

        if (solicitacaoOrientacaoTcc.isRespondida()) {
            throw new SolicitacaoOrientacaoTccJaRespondidaException(idSolicitacao);
        }

        RespostaSolicitacaoOrientacaoTcc respostaSolicitacaoOrientacaoTcc =
                respostaSolicitacaoOrientacaoTccMapper.toEntity(respostaSolicitacaoOrientacaoTccDTO);

        solicitacaoOrientacaoTcc.setResposta(respostaSolicitacaoOrientacaoTcc);

        usuarioService.salvarUsuario(professor);

        return solicitacaoOrientacaoTccMapper.toDTO(solicitacaoOrientacaoTcc);
    }
}
