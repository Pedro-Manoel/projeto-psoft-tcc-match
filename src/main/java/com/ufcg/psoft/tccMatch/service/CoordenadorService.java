package com.ufcg.psoft.tccMatch.service;

import com.ufcg.psoft.tccMatch.model.ProblemaOrientacaoTcc;
import com.ufcg.psoft.tccMatch.model.usuario.Coordenador;

public interface CoordenadorService {
    void adicionarProblemaOrientacaoTcc (ProblemaOrientacaoTcc problemaOrientacaoTcc);

    Coordenador getCoordenador();

    void salvarCoordenador(Coordenador coordenador);
}
