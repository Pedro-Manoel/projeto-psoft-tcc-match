package com.ufcg.psoft.tccMatch.service.usuario;

import com.ufcg.psoft.tccMatch.dto.message.MessageDTO;
import com.ufcg.psoft.tccMatch.dto.usuario.AlunoDTO;
import com.ufcg.psoft.tccMatch.model.usuario.Aluno;

import java.util.List;

public interface AlunoService {
    AlunoDTO criarAluno (AlunoDTO alunoDTO);

    AlunoDTO atualizarAluno (Long id, AlunoDTO alunoDTO);

    MessageDTO removerAluno (Long id);

    Aluno getAluno (Long id);

    List<Aluno> getAlunos ();

    void salvarAluno (Aluno aluno);
}
