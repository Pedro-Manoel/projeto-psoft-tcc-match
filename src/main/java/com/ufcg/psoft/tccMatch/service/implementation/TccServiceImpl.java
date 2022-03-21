package com.ufcg.psoft.tccMatch.service.implementation;

import com.ufcg.psoft.tccMatch.dto.MessageDTO;
import com.ufcg.psoft.tccMatch.dto.SolicitacaoOrientacaoTccDTO;
import com.ufcg.psoft.tccMatch.exception.EntidadeJaExisteException;
import com.ufcg.psoft.tccMatch.exception.EntidadeNaoExisteException;
import com.ufcg.psoft.tccMatch.exception.SolicitacaoOrientacaoTccEmAndamentoException;
import com.ufcg.psoft.tccMatch.exception.TemaTccInvalidoProfessorException;
import com.ufcg.psoft.tccMatch.model.SolicitacaoOrientacaoTcc;
import com.ufcg.psoft.tccMatch.model.TemaTcc;
import com.ufcg.psoft.tccMatch.model.usuario.Aluno;
import com.ufcg.psoft.tccMatch.model.usuario.Professor;
import com.ufcg.psoft.tccMatch.service.ProfessorService;
import com.ufcg.psoft.tccMatch.service.TccService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class TccServiceImpl implements TccService {

    private final ProfessorService professorService;

    public MessageDTO solicitarOrientacao(Aluno aluno, SolicitacaoOrientacaoTccDTO solicitacaoOrientacaoTccDTO) {
        Professor professor = professorService.getProfessor(solicitacaoOrientacaoTccDTO.getProfessorId());
        TemaTcc temaTcc = professor.getTemaTcc(solicitacaoOrientacaoTccDTO.getTemaTcc());

        if (temaTcc == null) {
            throw new TemaTccInvalidoProfessorException(solicitacaoOrientacaoTccDTO.getTemaTcc());
        }

        if (professor.existeSolicitacaoOrientacaoTcc(aluno, temaTcc)) {
            throw new SolicitacaoOrientacaoTccEmAndamentoException(solicitacaoOrientacaoTccDTO.getTemaTcc());
        }

        SolicitacaoOrientacaoTcc solicitacaoOrientacaoTcc = new SolicitacaoOrientacaoTcc();
        solicitacaoOrientacaoTcc.setAluno(aluno);
        solicitacaoOrientacaoTcc.setTemaTcc(temaTcc);
        professor.adicionarSolicitacaoOrientacaoTcc(solicitacaoOrientacaoTcc);

        professorService.salvarProfessor(professor);

        return new MessageDTO("Solicitação realizada com sucesso");
    }
}
