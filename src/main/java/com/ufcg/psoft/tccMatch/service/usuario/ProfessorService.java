package com.ufcg.psoft.tccMatch.service.usuario;

import com.ufcg.psoft.tccMatch.dto.*;
import com.ufcg.psoft.tccMatch.dto.message.MessageDTO;
import com.ufcg.psoft.tccMatch.dto.usuario.ProfessorDTO;
import com.ufcg.psoft.tccMatch.dto.usuario.UsuarioDTO;
import com.ufcg.psoft.tccMatch.model.AreaEstudo;
import com.ufcg.psoft.tccMatch.model.usuario.Professor;

import java.util.List;

public interface ProfessorService {
    ProfessorDTO criarProfessor (ProfessorDTO professorDTO);

    void salvarProfessor (Professor professor);

    Professor getProfessor (Long id);

    List<Professor> getProfessores();

    ProfessorDTO atualizarProfessor (Long id, ProfessorDTO professorDTO);

    MessageDTO removerProfessor (Long id);

    ProfessorDTO atualizarQuotaProfessor(Long id, QuotaProfessorDTO quotaProfessorDTO);

    List<UsuarioDTO> listarProfessoresDisponiveisOrientacaoTcc (List<AreaEstudo> areasEstudo);
}
