package com.ufcg.psoft.tccMatch.service;

import com.ufcg.psoft.tccMatch.dto.MessageDTO;
import com.ufcg.psoft.tccMatch.dto.TemaTccDTO;
import com.ufcg.psoft.tccMatch.dto.TemaTccUsuarioDTO;
import com.ufcg.psoft.tccMatch.dto.usuario.ProfessorDTO;
import com.ufcg.psoft.tccMatch.dto.QuotaProfessorDTO;
import com.ufcg.psoft.tccMatch.model.AreaEstudo;
import com.ufcg.psoft.tccMatch.model.usuario.Professor;

import java.util.List;

public interface ProfessorService {
    ProfessorDTO criarProfessor (ProfessorDTO professorDTO);

    ProfessorDTO atualizarProfessor (Long id, ProfessorDTO professorDTO);

    MessageDTO removerProfessor (Long id);

    ProfessorDTO atualizarQuotaProfessor(Long id, QuotaProfessorDTO quotaProfessorDTO);

    List<TemaTccUsuarioDTO> listarTemasTccProfessores();

    List<TemaTccDTO> listarTemasTccProfessor(Long id);

    List<ProfessorDTO> listarProfessoresDisponiveisOrientacao (List<AreaEstudo> areasEstudo);
}
