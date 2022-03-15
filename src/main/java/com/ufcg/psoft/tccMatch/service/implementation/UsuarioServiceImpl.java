package com.ufcg.psoft.tccMatch.service.implementation;

import com.ufcg.psoft.tccMatch.dto.usuario.UsuarioDTO;
import com.ufcg.psoft.tccMatch.exception.EntidadeNaoExisteException;
import com.ufcg.psoft.tccMatch.model.usuario.Aluno;
import com.ufcg.psoft.tccMatch.model.usuario.Usuario;
import com.ufcg.psoft.tccMatch.model.usuario.UsuarioTCC;
import com.ufcg.psoft.tccMatch.repository.UsuarioRepository;
import com.ufcg.psoft.tccMatch.repository.UsuarioTCCRepository;
import com.ufcg.psoft.tccMatch.service.UsuarioService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class UsuarioServiceImpl implements UsuarioService {

    private UsuarioRepository usuarioRepository;
    private UsuarioTCCRepository usuarioTCCRepository;

    public void salvarUsuario (Usuario usuario) {
        usuarioRepository.save(usuario);
    }

    public boolean usuarioJaExiste (UsuarioDTO usuarioDTO) {
        return usuarioRepository.existsByEmail(usuarioDTO.getEmail());
    }

    public boolean usuarioJaExiste (Usuario usuario, UsuarioDTO usuarioDTO) {
        if (!usuario.getEmail().equals(usuarioDTO.getEmail())) {
            return usuarioJaExiste(usuarioDTO);
        }
        return false;
    }

    public Usuario getUsuario(String email) {
        return usuarioRepository.findByEmail(email)
                .orElseThrow(() -> new EntidadeNaoExisteException("Usuário", "email", email));
    }

    public Usuario getUsuario(Long id) {
        return usuarioRepository.findById(id)
                .orElseThrow(() -> new EntidadeNaoExisteException("Usuário", "id", id.toString()));
    }

    public UsuarioTCC getUsuarioTCC(Long id) {
        return usuarioTCCRepository.findById(id)
                .orElseThrow(() -> new EntidadeNaoExisteException("Usuário", "id", id.toString()));
    }
}