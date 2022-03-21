package com.ufcg.psoft.tccMatch.service.tcc;

import com.ufcg.psoft.tccMatch.dto.tcc.RespostaSolicitacaoOrientacaoTccDTO;
import com.ufcg.psoft.tccMatch.dto.tcc.SolicitacaoOrientacaoTccDTO;

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
