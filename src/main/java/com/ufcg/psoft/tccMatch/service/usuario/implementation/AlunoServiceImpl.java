package com.ufcg.psoft.tccMatch.service.usuario.implementation;

import com.ufcg.psoft.tccMatch.dto.message.MessageDTO;
import com.ufcg.psoft.tccMatch.dto.usuario.AlunoDTO;
import com.ufcg.psoft.tccMatch.error.exception.EntidadeJaExisteException;
import com.ufcg.psoft.tccMatch.error.exception.EntidadeNaoExisteException;
import com.ufcg.psoft.tccMatch.mapper.usuario.AlunoMapper;
import com.ufcg.psoft.tccMatch.model.usuario.Aluno;
import com.ufcg.psoft.tccMatch.repository.usuario.AlunoRepository;
import com.ufcg.psoft.tccMatch.service.usuario.AlunoService;
import com.ufcg.psoft.tccMatch.service.usuario.UsuarioService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class AlunoServiceImpl implements AlunoService {

    private final AlunoRepository alunoRepository;

    private final UsuarioService usuarioService;
    private final PasswordEncoder passwordEncoder;

    private final AlunoMapper alunoMapper;

    public Aluno getAluno (Long id) {
        return alunoRepository.findById(id)
                .orElseThrow(() -> new EntidadeNaoExisteException("Aluno", "id", id.toString()));
    }

    public List<Aluno> getAlunos () { return alunoRepository.findAll(); }

    public void salvarAluno (Aluno aluno) {
        alunoRepository.save(aluno);
    }

    public AlunoDTO criarAluno (AlunoDTO alunoDTO) {
        if (usuarioService.usuarioJaExiste(alunoDTO)) {
            throw new EntidadeJaExisteException("Aluno", "email", alunoDTO.getEmail());
        }

        Aluno aluno = alunoMapper.toEntity(alunoDTO);
        String senhaCriptografada = passwordEncoder.encode(alunoDTO.getSenha());
        aluno.setSenha(senhaCriptografada);

        salvarAluno(aluno);

        return alunoMapper.toDTO(aluno);
    }

    public AlunoDTO atualizarAluno (Long id, AlunoDTO alunoDTO) {
        Aluno aluno = getAluno(id);

        if (usuarioService.usuarioJaExiste(aluno, alunoDTO)) {
            throw new EntidadeJaExisteException("Aluno", "email", alunoDTO.getEmail());
        }

        String senhaCriptografada = passwordEncoder.encode(alunoDTO.getSenha());
        alunoDTO.setSenha(senhaCriptografada);
        alunoMapper.toUpdateEntity(alunoDTO, aluno);
        salvarAluno(aluno);

        return alunoMapper.toDTO(aluno);
    }

    public MessageDTO removerAluno (Long id) {
        Aluno aluno = getAluno(id);

        alunoRepository.delete(aluno);

        return new MessageDTO(
                String.format("Aluno com id <%s> foi removido com sucesso do sistema", id)
        );
    }
}
