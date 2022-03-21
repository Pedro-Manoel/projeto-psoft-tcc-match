package com.ufcg.psoft.tccMatch.service.tcc;

import com.ufcg.psoft.tccMatch.dto.tcc.TemaTccDTO;
import com.ufcg.psoft.tccMatch.dto.tcc.TemaTccUsuarioDTO;
import com.ufcg.psoft.tccMatch.model.tcc.TemaTcc;
import com.ufcg.psoft.tccMatch.model.usuario.UsuarioTcc;

import java.util.List;

public interface TemaTccService {
    TemaTccDTO criarTemaTccUsuario(UsuarioTcc usuarioTcc, TemaTccDTO temaTccDTO);

    TemaTcc getTemaTcc(Long id);

    List<TemaTccDTO> listarTemasTccUsuario(UsuarioTcc usuarioTcc);

    List<TemaTccUsuarioDTO> listarTemasTccUsuarios(List<UsuarioTcc> usuariosTcc);
}
