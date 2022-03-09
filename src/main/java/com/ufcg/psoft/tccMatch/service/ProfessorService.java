package com.ufcg.psoft.tccMatch.service;

import com.ufcg.psoft.tccMatch.dto.ProfessorDTO;
import com.ufcg.psoft.tccMatch.model.usuario.Professor;

public interface ProfessorService {
    Professor criarProfessor (ProfessorDTO professorDTO);

    Professor atualizarProfessor (Long id, ProfessorDTO professorDTO);

    void removerProfessor (Long id);
}
