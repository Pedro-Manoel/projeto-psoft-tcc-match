package com.ufcg.psoft.tccMatch.service.implementation;

import com.ufcg.psoft.tccMatch.dto.ProfessorDTO;
import com.ufcg.psoft.tccMatch.exception.ProfessorJaExisteException;
import com.ufcg.psoft.tccMatch.exception.ProfessorNaoExisteException;
import com.ufcg.psoft.tccMatch.model.usuario.Professor;
import com.ufcg.psoft.tccMatch.repository.ProfessorRepository;
import com.ufcg.psoft.tccMatch.service.ProfessorService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class ProfessorServiceImpl implements ProfessorService {

    private ProfessorRepository professorRepository;

    private void preencherAtributosProfessor (Professor professor, ProfessorDTO professorDTO) {
        professor.setNome(professorDTO.getNome());
        professor.setEmail(professorDTO.getEmail());
        professor.setSenha(professorDTO.getSenha());
        professor.setQuota(professorDTO.getQuota());
        professor.setLaboratorios(professorDTO.getLaboratorios());
        
    }

    private Professor getProfessor (Long id) {
        return professorRepository.findById(id)
            .orElseThrow(() -> new ProfessorNaoExisteException(id));
    }

    private void salvarProfessor (Professor professor) {
        professorRepository.save(professor);
    }
    
    public Professor criarProfessor(ProfessorDTO professorDTO) {
        if (professorRepository.existsByEmail(professorDTO.getEmail())) {
            throw new ProfessorJaExisteException(professorDTO.getEmail());
        }

        Professor professor = new Professor();
        preencherAtributosProfessor(professor, professorDTO);
        salvarProfessor(professor);

        return professor;
    }
    
    public Professor atualizarProfessor(Long id, ProfessorDTO professorDTO) {
        Professor professor = getProfessor(id);

        if (!professor.getEmail().equals(professorDTO.getEmail())) {
            if (professorRepository.existsByEmail(professorDTO.getEmail())) {
                throw new ProfessorJaExisteException(professorDTO.getEmail());
            }
        }

        preencherAtributosProfessor(professor, professorDTO);
        salvarProfessor(professor);

        return professor;
    }

   
    public void removerProfessor(Long id) {
        Professor professor = getProfessor(id);

        professorRepository.delete(professor);
    }
}
