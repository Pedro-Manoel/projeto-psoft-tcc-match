package com.ufcg.psoft.tccMatch.service.implementation;

import com.ufcg.psoft.tccMatch.dto.AreaEstudoDTO;
import com.ufcg.psoft.tccMatch.exception.AreaEstudoJaExisteException;
import com.ufcg.psoft.tccMatch.model.AreaEstudo;
import com.ufcg.psoft.tccMatch.model.usuario.Aluno;
import com.ufcg.psoft.tccMatch.repository.AreaEstudoRepository;
import com.ufcg.psoft.tccMatch.service.AreaEstudoService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class AreaEstudoImpl implements AreaEstudoService {
    private AreaEstudoRepository areaEstudoRepository;
    
    public AreaEstudo criarAreaEstudo (AreaEstudoDTO areaEstudoDTO) {
        if (areaEstudoRepository.existsByNome(areaEstudoDTO.getNome())) {
            throw new AreaEstudoJaExisteException(areaEstudoDTO.getNome());
        }

        AreaEstudo areaEstudoSendoCriada = new AreaEstudo();
        areaEstudoSendoCriada.setNome(areaEstudoDTO.getNome());
        salvarAreaEstudo(areaEstudoSendoCriada);

        return areaEstudoSendoCriada;
    }

    private void salvarAreaEstudo (AreaEstudo areaEstudo) {
        areaEstudoRepository.save(areaEstudo);
    }
}
