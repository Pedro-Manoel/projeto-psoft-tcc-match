package com.ufcg.psoft.tccMatch.service;

import com.ufcg.psoft.tccMatch.dto.MessageDTO;
import com.ufcg.psoft.tccMatch.dto.SolicitacaoOrientacaoTccDTO;
import com.ufcg.psoft.tccMatch.model.usuario.Aluno;

public interface TccService {
    MessageDTO solicitarOrientacao(Aluno aluno, SolicitacaoOrientacaoTccDTO solicitacaoOrientacaoTccDTO);
}
