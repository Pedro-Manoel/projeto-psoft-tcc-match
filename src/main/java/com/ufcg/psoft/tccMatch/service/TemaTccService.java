package com.ufcg.psoft.tccMatch.service;

import com.ufcg.psoft.tccMatch.dto.TemaTccDTO;
import com.ufcg.psoft.tccMatch.dto.TemaTccUsuarioDTO;
import com.ufcg.psoft.tccMatch.model.usuario.Professor;
import com.ufcg.psoft.tccMatch.model.usuario.UsuarioTcc;

import java.util.Collection;
import java.util.List;

public interface TemaTccService {
    TemaTccDTO criarTemaTcc (Long id, TemaTccDTO temaTccDTO);

    List<TemaTccUsuarioDTO> listarTemasTccUsuario(UsuarioTcc usuarioTcc);
}
