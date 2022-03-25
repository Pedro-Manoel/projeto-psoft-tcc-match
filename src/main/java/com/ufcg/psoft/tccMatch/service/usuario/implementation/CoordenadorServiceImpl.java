package com.ufcg.psoft.tccMatch.service.usuario.implementation;

import com.ufcg.psoft.tccMatch.error.exception.EntidadeNaoExisteException;
import com.ufcg.psoft.tccMatch.model.usuario.Coordenador;
import com.ufcg.psoft.tccMatch.repository.usuario.CoordenadorRepository;
import com.ufcg.psoft.tccMatch.service.usuario.CoordenadorService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class CoordenadorServiceImpl implements CoordenadorService {

    private final Long COORDENADOR_ID = 0L;

    private final CoordenadorRepository coordenadorRepository;

    public Coordenador getCoordenador () {
        return coordenadorRepository.findById(COORDENADOR_ID)
                .orElseThrow(() -> new EntidadeNaoExisteException("Coordenador", "id", COORDENADOR_ID.toString()));
    }
}
