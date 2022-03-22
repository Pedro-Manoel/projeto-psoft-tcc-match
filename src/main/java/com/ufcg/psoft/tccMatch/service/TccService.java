package com.ufcg.psoft.tccMatch.service;

import com.ufcg.psoft.tccMatch.dto.MessageDTO;
import com.ufcg.psoft.tccMatch.dto.OrientacaoTccDTO;
import com.ufcg.psoft.tccMatch.dto.SolicitacaoOrientacaoTccDTO;
import com.ufcg.psoft.tccMatch.model.OrientacaoTcc;
import com.ufcg.psoft.tccMatch.model.usuario.Aluno;
import com.ufcg.psoft.tccMatch.model.usuario.Professor;

public interface TccService {
    MessageDTO solicitarOrientacao(Aluno aluno, SolicitacaoOrientacaoTccDTO solicitacaoOrientacaoTccDTO);

    OrientacaoTccDTO criarOrientacaoTcc (Professor professor, OrientacaoTccDTO orientacaoTccDTO);
}
