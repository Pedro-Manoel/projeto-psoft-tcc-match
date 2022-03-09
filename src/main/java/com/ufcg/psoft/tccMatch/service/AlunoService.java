package com.ufcg.psoft.tccMatch.service;

import com.ufcg.psoft.tccMatch.dto.AlunoDTO;
import com.ufcg.psoft.tccMatch.model.usuario.Aluno;

public interface AlunoService {
    Aluno criarAluno (AlunoDTO alunoDTO);

    Aluno atualizarAluno (Long id, AlunoDTO alunoDTO);

    void removerAluno (Long id);
}
