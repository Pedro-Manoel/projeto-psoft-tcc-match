package com.ufcg.psoft.tccMatch.service.usuario;

import com.ufcg.psoft.tccMatch.dto.usuario.UsuarioDTO;
import com.ufcg.psoft.tccMatch.model.usuario.Usuario;
import com.ufcg.psoft.tccMatch.model.usuario.UsuarioTcc;

public interface UsuarioService {
    void salvarUsuario (Usuario usuario);

    void verificarUsuario(UsuarioDTO usuarioDTO);

    void verificarUsuario (Usuario usuario, UsuarioDTO usuarioDTO);

    Usuario getUsuario(String email);

    Usuario getUsuario(Long id);

    UsuarioTcc getUsuarioTcc(Long id);
}
