package com.ufcg.psoft.tccMatch.service;

import com.ufcg.psoft.tccMatch.dto.AreaEstudoDTO;
import com.ufcg.psoft.tccMatch.model.AreaEstudo;
import com.ufcg.psoft.tccMatch.model.usuario.UsuarioTcc;

import java.util.List;

public interface AreaEstudoService {
    AreaEstudoDTO criarAreaEstudo (AreaEstudoDTO areaEstudoDTO);

    List<AreaEstudoDTO> selecionarAreasEstudoUsuario (UsuarioTcc usuarioTcc, List<AreaEstudoDTO> areasEstudoDTO);

    List<AreaEstudo> getAreasEstudo (List<AreaEstudoDTO> areasEstudoDTO);
}
