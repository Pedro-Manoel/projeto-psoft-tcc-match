package com.ufcg.psoft.tccMatch.service;

import com.ufcg.psoft.tccMatch.dto.usuario.UsuarioDTO;
import com.ufcg.psoft.tccMatch.model.usuario.Usuario;
import com.ufcg.psoft.tccMatch.model.usuario.UsuarioTcc;

public interface UsuarioService {
    void salvarUsuario (Usuario usuario);

    boolean usuarioJaExiste (UsuarioDTO usuarioDTO);

    boolean usuarioJaExiste (Usuario usuario, UsuarioDTO usuarioDTO);

    Usuario getUsuario(String email);

    Usuario getUsuario(Long id);

    UsuarioTcc getUsuarioTcc(Long id);
}
