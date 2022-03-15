package com.ufcg.psoft.tccMatch.service;

import com.ufcg.psoft.tccMatch.dto.MessageDTO;
import com.ufcg.psoft.tccMatch.dto.usuario.AlunoDTO;
import com.ufcg.psoft.tccMatch.model.usuario.Aluno;

public interface AlunoService {
    AlunoDTO criarAluno (AlunoDTO alunoDTO);

    AlunoDTO atualizarAluno (Long id, AlunoDTO alunoDTO);

    MessageDTO removerAluno (Long id);

    Aluno getAluno (Long id);

    void salvarAluno (Aluno aluno);
}
