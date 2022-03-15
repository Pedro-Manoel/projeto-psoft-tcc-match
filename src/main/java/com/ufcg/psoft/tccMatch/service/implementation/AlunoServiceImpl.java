package com.ufcg.psoft.tccMatch.service.implementation;

import com.ufcg.psoft.tccMatch.dto.MessageDTO;
import com.ufcg.psoft.tccMatch.dto.usuario.AlunoDTO;
import com.ufcg.psoft.tccMatch.exception.EntidadeJaExisteException;
import com.ufcg.psoft.tccMatch.exception.EntidadeNaoExisteException;
import com.ufcg.psoft.tccMatch.mapper.AlunoMapper;
import com.ufcg.psoft.tccMatch.model.usuario.Aluno;
import com.ufcg.psoft.tccMatch.repository.AlunoRepository;
import com.ufcg.psoft.tccMatch.service.AlunoService;
import com.ufcg.psoft.tccMatch.service.UsuarioService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class AlunoServiceImpl implements AlunoService {

    private final AlunoRepository alunoRepository;

    private final AlunoMapper alunoMapper = AlunoMapper.INSTANCE;

    private final UsuarioService usuarioService;

    public Aluno getAluno (Long id) {
        return alunoRepository.findById(id)
                .orElseThrow(() -> new EntidadeNaoExisteException("Aluno", "id", id.toString()));
    }

    public void salvarAluno (Aluno aluno) {
        alunoRepository.save(aluno);
    }

    public AlunoDTO criarAluno(AlunoDTO alunoDTO) {
        if (usuarioService.usuarioJaExiste(alunoDTO)) {
            throw new EntidadeJaExisteException("Aluno", "email", alunoDTO.getEmail());
        }

        Aluno aluno = alunoMapper.toEntity(alunoDTO);
        salvarAluno(aluno);

        return alunoMapper.toDTO(aluno);
    }

    public AlunoDTO atualizarAluno(Long id, AlunoDTO alunoDTO) {
        Aluno aluno = getAluno(id);

        if (usuarioService.usuarioJaExiste(aluno, alunoDTO)) {
            throw new EntidadeJaExisteException("Aluno", "email", alunoDTO.getEmail());
        }

        Aluno alunoAtualizado = alunoMapper.toEntity(aluno, alunoDTO);
        salvarAluno(alunoAtualizado);

        return alunoMapper.toDTO(alunoAtualizado);
    }

    public MessageDTO removerAluno(Long id) {
        Aluno aluno = getAluno(id);

        alunoRepository.delete(aluno);

        return new MessageDTO(
                String.format("Aluno com id %s foi removido com sucesso do sistema", id)
        );
    }
}
