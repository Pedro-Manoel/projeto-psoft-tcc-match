package com.ufcg.psoft.tccMatch.service.usuario;

import com.ufcg.psoft.tccMatch.model.usuario.Coordenador;

public interface CoordenadorService {
    Coordenador getCoordenador();

    void salvarCoordenador(Coordenador coordenador);
}
