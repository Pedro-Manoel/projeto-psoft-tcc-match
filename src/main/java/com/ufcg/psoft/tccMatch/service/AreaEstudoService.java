package com.ufcg.psoft.tccMatch.service;

import com.ufcg.psoft.tccMatch.dto.AreaEstudoDTO;
import com.ufcg.psoft.tccMatch.model.AreaEstudo;
import com.ufcg.psoft.tccMatch.model.usuario.Aluno;

import java.util.List;

public interface AreaEstudoService {
    AreaEstudoDTO criarAreaEstudo (AreaEstudoDTO areaEstudoDTO);

    List<AreaEstudo> selecionarAreasEstudoUsuarioTcc(Long id, List<AreaEstudoDTO> areasEstudoDTO);

    List<AreaEstudo> getAreasEstudo(List<AreaEstudoDTO> areasEstudoDTO);
}
