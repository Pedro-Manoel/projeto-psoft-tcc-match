package com.ufcg.psoft.tccMatch.service.tcc;

import com.ufcg.psoft.tccMatch.dto.tcc.solicitacao.RespostaSolicitacaoOrientacaoTccDTO;
import com.ufcg.psoft.tccMatch.dto.tcc.solicitacao.SolicitacaoOrientacaoTccDTO;

import java.util.List;

public interface SolicitacaoOrientacaoTccService {
    SolicitacaoOrientacaoTccDTO solicitarOrientacaoTcc(Long idAluno, SolicitacaoOrientacaoTccDTO solicitacaoOrientacaoTccDTO);

    List<SolicitacaoOrientacaoTccDTO> listarSolicitacoesOrientacoesTccProfessor(Long id);

    SolicitacaoOrientacaoTccDTO responderSolicitacaoOrientacaoTccProfessor(
            Long idProfessor,
            Long idSolicitacao,
            RespostaSolicitacaoOrientacaoTccDTO respostaSolicitacaoOrientacaoTccDTO
    );
}
