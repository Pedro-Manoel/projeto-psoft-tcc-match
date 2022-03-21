package com.ufcg.psoft.tccMatch.service.implementation;

import com.ufcg.psoft.tccMatch.dto.ProblemaOrientacaoTccDTO;
import com.ufcg.psoft.tccMatch.model.ProblemaOrientacaoTcc;
import com.ufcg.psoft.tccMatch.model.usuario.UsuarioTcc;
import com.ufcg.psoft.tccMatch.repository.ProblemaOrientacaoTccRepository;
import com.ufcg.psoft.tccMatch.service.CoordenadorService;
import com.ufcg.psoft.tccMatch.service.ProblemaOrientacaoTccService;
import com.ufcg.psoft.tccMatch.service.UsuarioService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class ProblemaOrientacaoTccServiceImpl implements ProblemaOrientacaoTccService {

    private final ProblemaOrientacaoTccRepository problemaOrientacaoTccRepository;

    private final UsuarioService usuarioService;
    private final CoordenadorService coordenadorService;

    // Futuramente colocar a orientação onde o problema existe
    @Override
    public ProblemaOrientacaoTcc reportarProblema(Long id, ProblemaOrientacaoTccDTO problemaOrientacaoTccDTO) {
        UsuarioTcc usuarioTcc = usuarioService.getUsuarioTcc(id);

        ProblemaOrientacaoTcc problemaOrientacaoTcc = new ProblemaOrientacaoTcc();
        problemaOrientacaoTcc.setProblema(problemaOrientacaoTccDTO.getProblema());
        problemaOrientacaoTcc.setUsuario(usuarioTcc);
        salvarProblemaOrientacaoTcc(problemaOrientacaoTcc);

        coordenadorService.adicionarProblemaOrientacaoTcc(problemaOrientacaoTcc);

        return problemaOrientacaoTcc;
    }

    private void salvarProblemaOrientacaoTcc(ProblemaOrientacaoTcc problemaOrientacaoTcc) {
        problemaOrientacaoTccRepository.save(problemaOrientacaoTcc);
    }
}
