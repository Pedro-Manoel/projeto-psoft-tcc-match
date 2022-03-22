package com.ufcg.psoft.tccMatch.service.usuario.implementation;

import com.ufcg.psoft.tccMatch.dto.usuario.UsuarioDTO;
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

    public UsuarioTcc getUsuarioTcc(Long id) {
        return usuarioTccRepository.findById(id)
                .orElseThrow(() -> new EntidadeNaoExisteException("Usuário", "id", id.toString()));
    }
}
