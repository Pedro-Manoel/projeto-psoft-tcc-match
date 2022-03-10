package com.ufcg.psoft.tccMatch.service;

import com.ufcg.psoft.tccMatch.dto.AreaEstudoDTO;
import com.ufcg.psoft.tccMatch.model.AreaEstudo;
import com.ufcg.psoft.tccMatch.model.usuario.Aluno;

public interface AreaEstudoService {
    AreaEstudo criarAreaEstudo (AreaEstudoDTO areaEstudoDTO);
}
