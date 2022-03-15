package com.ufcg.psoft.tccMatch.service.implementation;

import com.ufcg.psoft.tccMatch.dto.usuario.UsuarioDTO;
import com.ufcg.psoft.tccMatch.model.usuario.Usuario;
import com.ufcg.psoft.tccMatch.repository.UsuarioRepository;
import com.ufcg.psoft.tccMatch.service.UsuarioService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class UsuarioServiceImpl implements UsuarioService {

    private UsuarioRepository usuarioRepository;

    public boolean usuarioJaExiste (UsuarioDTO usuarioDTO) {
        return usuarioRepository.existsByEmail(usuarioDTO.getEmail());
    }

    public boolean usuarioJaExiste (Usuario usuario, UsuarioDTO usuarioDTO) {
        if (!usuario.getEmail().equals(usuarioDTO.getEmail())) {
            return usuarioJaExiste(usuarioDTO);
        }
        return false;
    }
}
