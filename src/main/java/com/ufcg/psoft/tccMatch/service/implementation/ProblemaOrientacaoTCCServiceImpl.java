package com.ufcg.psoft.tccMatch.service.implementation;

import com.ufcg.psoft.tccMatch.dto.ProblemaOrientacaoTCCDTO;
import com.ufcg.psoft.tccMatch.model.ProblemaOrientacaoTCC;
import com.ufcg.psoft.tccMatch.model.usuario.UsuarioTCC;
import com.ufcg.psoft.tccMatch.repository.CoordenadorRepository;
import com.ufcg.psoft.tccMatch.service.CoordenadorService;
import com.ufcg.psoft.tccMatch.service.ProblemaOrientacaoTCCService;
import com.ufcg.psoft.tccMatch.service.UsuarioService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class ProblemaOrientacaoTCCServiceImpl implements ProblemaOrientacaoTCCService {

    private final UsuarioService usuarioService;
    private final CoordenadorService coordenadorService;

    // BUG - Não esta retornando o ID no Swagger
    @Override
    public ProblemaOrientacaoTCC reportarProblema(Long id, ProblemaOrientacaoTCCDTO problemaOrientacaoTCCDTO) {
        UsuarioTCC usuarioTCC = usuarioService.getUsuarioTCC(id);

        ProblemaOrientacaoTCC problemaOrientacaoTCC = new ProblemaOrientacaoTCC();
        problemaOrientacaoTCC.setProblema(problemaOrientacaoTCCDTO.getProblema());

        problemaOrientacaoTCC.setUsuario(usuarioTCC);
        coordenadorService.adicionarProblemaOrientacaoTCC(problemaOrientacaoTCC);

        return problemaOrientacaoTCC;
    }
}
