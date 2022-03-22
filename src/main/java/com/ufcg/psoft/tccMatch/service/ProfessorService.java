package com.ufcg.psoft.tccMatch.service;

import com.ufcg.psoft.tccMatch.dto.*;
import com.ufcg.psoft.tccMatch.dto.usuario.ProfessorDTO;
import com.ufcg.psoft.tccMatch.model.AreaEstudo;
import com.ufcg.psoft.tccMatch.model.usuario.Professor;

import java.util.List;

public interface ProfessorService {
    ProfessorDTO criarProfessor (ProfessorDTO professorDTO);

    void salvarProfessor (Professor professor);

    Professor getProfessor (Long id);

    ProfessorDTO atualizarProfessor (Long id, ProfessorDTO professorDTO);

    MessageDTO removerProfessor (Long id);

    ProfessorDTO atualizarQuotaProfessor(Long id, QuotaProfessorDTO quotaProfessorDTO);

    List<TemaTccUsuarioDTO> listarTemasTccProfessores();

    List<TemaTccDTO> listarTemasTccProfessor(Long id);

    List<ProfessorDTO> listarProfessoresDisponiveisOrientacao (List<AreaEstudo> areasEstudo);

    List<SolicitacaoOrientacaoTccDTO> listarSolicitacoesOrientacaoTcc (Long id);

    SolicitacaoOrientacaoTccDTO responderSolicitacaoOrientacaoTcc(Long id, Long idSolicitacao,  RespostaSolicitacaoOrientacaoTccDTO respostaSolicitacaoOrientacaoTccDTO);
}
