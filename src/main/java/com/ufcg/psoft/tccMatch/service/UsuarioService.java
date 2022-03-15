package com.ufcg.psoft.tccMatch.service;

import com.ufcg.psoft.tccMatch.dto.usuario.UsuarioDTO;
import com.ufcg.psoft.tccMatch.model.usuario.Usuario;

public interface UsuarioService {
    boolean usuarioJaExiste (UsuarioDTO usuarioDTO);

    boolean usuarioJaExiste (Usuario usuario, UsuarioDTO usuarioDTO);
}
