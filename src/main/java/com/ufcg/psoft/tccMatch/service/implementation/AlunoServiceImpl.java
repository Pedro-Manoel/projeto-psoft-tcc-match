package com.ufcg.psoft.tccMatch.service.implementation;

import com.ufcg.psoft.tccMatch.dto.AlunoDTO;
import com.ufcg.psoft.tccMatch.exception.AlunoJaExisteException;
import com.ufcg.psoft.tccMatch.exception.AlunoNaoExisteException;
import com.ufcg.psoft.tccMatch.model.usuario.Aluno;
import com.ufcg.psoft.tccMatch.repository.AlunoRepository;
import com.ufcg.psoft.tccMatch.service.AlunoService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class AlunoServiceImpl implements AlunoService {

    private AlunoRepository alunoRepository;

    private void preencherAtributosAluno (Aluno aluno, AlunoDTO alunoDTO) {
        aluno.setNome(alunoDTO.getNome());
        aluno.setEmail(alunoDTO.getEmail());
        aluno.setSenha(alunoDTO.getSenha());
        aluno.setPeriodoPrevistoConclusao(alunoDTO.getPeriodoPrevistoConclusao());
        aluno.setMatricula(alunoDTO.getMatricula());
    }

    private Aluno getAluno (Long id) {
        return alunoRepository.findById(id)
            .orElseThrow(() -> new AlunoNaoExisteException(id));
    }

    private void salvarAluno (Aluno aluno) {
        alunoRepository.save(aluno);
    }

    public Aluno criarAluno(AlunoDTO alunoDTO) {
        if (alunoRepository.existsByEmail(alunoDTO.getEmail())) {
            throw new AlunoJaExisteException(alunoDTO.getEmail());
        }

        Aluno aluno = new Aluno();
        preencherAtributosAluno(aluno, alunoDTO);
        salvarAluno(aluno);

        return aluno;
    }


    public Aluno atualizarAluno(Long id, AlunoDTO alunoDTO) {
        Aluno aluno = getAluno(id);

        if (!aluno.getEmail().equals(alunoDTO.getEmail())) {
            if (alunoRepository.existsByEmail(alunoDTO.getEmail())) {
                throw new AlunoJaExisteException(alunoDTO.getEmail());
            }
        }

        preencherAtributosAluno(aluno, alunoDTO);
        salvarAluno(aluno);

        return aluno;
    }


    public void removerAluno(Long id) {
        Aluno aluno = getAluno(id);

        alunoRepository.delete(aluno);
    }
}
