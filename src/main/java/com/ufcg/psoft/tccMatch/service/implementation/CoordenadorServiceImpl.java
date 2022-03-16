package com.ufcg.psoft.tccMatch.service.implementation;

import com.ufcg.psoft.tccMatch.exception.EntidadeNaoExisteException;
import com.ufcg.psoft.tccMatch.model.ProblemaOrientacaoTCC;
import com.ufcg.psoft.tccMatch.model.usuario.Aluno;
import com.ufcg.psoft.tccMatch.model.usuario.Coordenador;
import com.ufcg.psoft.tccMatch.repository.CoordenadorRepository;
import com.ufcg.psoft.tccMatch.service.CoordenadorService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class CoordenadorServiceImpl implements CoordenadorService {

    private final CoordenadorRepository coordenadorRepository;
    private final Long COORDENADOR_ID = 0L;

    @Override
    public void adicionarProblemaOrientacaoTCC(ProblemaOrientacaoTCC problemaOrientacaoTCC) {
        Coordenador coordenador = getCoordenador();

        coordenador.adicionarProblemaOrientacaoTCC(problemaOrientacaoTCC);
        salvarCoordenador(coordenador);
    }

    private Coordenador getCoordenador () {
        return coordenadorRepository.findById(COORDENADOR_ID)
                .orElseThrow(() -> new EntidadeNaoExisteException("Coordenador", "id", COORDENADOR_ID.toString()));
    }

    private void salvarCoordenador (Coordenador coordenador) {
        coordenadorRepository.save(coordenador);
    }
}
