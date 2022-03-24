package com.ufcg.psoft.tccMatch.service.usuario.implementation;

import com.ufcg.psoft.tccMatch.dto.usuario.UsuarioDTO;
import com.ufcg.psoft.tccMatch.error.exception.EntidadeJaExisteException;
import com.ufcg.psoft.tccMatch.error.exception.EntidadeNaoExisteException;
import com.ufcg.psoft.tccMatch.model.usuario.Usuario;
import com.ufcg.psoft.tccMatch.model.usuario.UsuarioTcc;
import com.ufcg.psoft.tccMatch.repository.usuario.UsuarioRepository;
import com.ufcg.psoft.tccMatch.repository.usuario.UsuarioTccRepository;
import com.ufcg.psoft.tccMatch.service.usuario.UsuarioService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class UsuarioServiceImpl implements UsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final UsuarioTccRepository usuarioTccRepository;

    public void salvarUsuario (Usuario usuario) {
        usuarioRepository.save(usuario);
    }

    public void verificarUsuario (UsuarioDTO usuarioDTO) {
        if (usuarioRepository.existsByEmail(usuarioDTO.getEmail())) {
            throw new EntidadeJaExisteException("Usuário", "email", usuarioDTO.getEmail());
        }
    }

    public void verificarUsuario (Usuario usuario, UsuarioDTO usuarioDTO) {
        if (!usuario.getEmail().equals(usuarioDTO.getEmail())) {
            verificarUsuario(usuarioDTO);
        }
    }

    public Usuario getUsuario(String email) {
        return usuarioRepository.findByEmail(email)
                .orElseThrow(() -> new EntidadeNaoExisteException("Usuário", "email", email));
    }

    public Usuario getUsuario(Long id) {
        return usuarioRepository.findById(id)
                .orElseThrow(() -> new EntidadeNaoExisteException("Usuário", "id", id.toString()));
    }

    public UsuarioTcc getUsuarioTcc(Long id) {
        return usuarioTccRepository.findById(id)
                .orElseThrow(() -> new EntidadeNaoExisteException("Usuário", "id", id.toString()));
    }
}
