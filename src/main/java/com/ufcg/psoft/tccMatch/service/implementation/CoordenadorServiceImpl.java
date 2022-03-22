package com.ufcg.psoft.tccMatch.service.implementation;

import com.ufcg.psoft.tccMatch.dto.OrientacaoTccDTO;
import com.ufcg.psoft.tccMatch.exception.EntidadeNaoExisteException;
import com.ufcg.psoft.tccMatch.exception.SolicitacaoOrientacaoTccNaoAceitaException;
import com.ufcg.psoft.tccMatch.model.OrientacaoTcc;
import com.ufcg.psoft.tccMatch.model.ProblemaOrientacaoTcc;
import com.ufcg.psoft.tccMatch.model.SolicitacaoOrientacaoTcc;
import com.ufcg.psoft.tccMatch.model.Tcc;
import com.ufcg.psoft.tccMatch.model.usuario.Coordenador;
import com.ufcg.psoft.tccMatch.model.usuario.Professor;
import com.ufcg.psoft.tccMatch.repository.CoordenadorRepository;
import com.ufcg.psoft.tccMatch.repository.OrientacaoTccRepository;
import com.ufcg.psoft.tccMatch.service.CoordenadorService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class CoordenadorServiceImpl implements CoordenadorService {

    private final Long COORDENADOR_ID = 0L;

    private final CoordenadorRepository coordenadorRepository;

    @Override
    public void adicionarProblemaOrientacaoTcc(ProblemaOrientacaoTcc problemaOrientacaoTcc) {
        Coordenador coordenador = getCoordenador();

        coordenador.adicionarProblemaOrientacaoTcc(problemaOrientacaoTcc);
        salvarCoordenador(coordenador);
    }

    public Coordenador getCoordenador () {
        return coordenadorRepository.findById(COORDENADOR_ID)
                .orElseThrow(() -> new EntidadeNaoExisteException("Coordenador", "id", COORDENADOR_ID.toString()));
    }

    public void salvarCoordenador (Coordenador coordenador) {
        coordenadorRepository.save(coordenador);
    }
}
