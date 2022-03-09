package com.ufcg.psoft.tccMatch.service.implementation;

import com.ufcg.psoft.tccMatch.dto.ProfessorDTO;
import com.ufcg.psoft.tccMatch.model.usuario.Professor;
import com.ufcg.psoft.tccMatch.service.ProfessorService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class ProfessorServiceImpl implements ProfessorService {
    @Override
    public Professor criarProfessor(ProfessorDTO ProfessorDTO) {
        return null;
    }

    @Override
    public Professor atualizarProfessor(Long id, ProfessorDTO ProfessorDTO) {
        return null;
    }

    @Override
    public void removerProfessor(Long id) {

    }
}
