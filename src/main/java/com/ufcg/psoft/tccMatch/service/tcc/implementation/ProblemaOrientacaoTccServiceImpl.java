package com.ufcg.psoft.tccMatch.service.tcc.implementation;

import com.ufcg.psoft.tccMatch.dto.tcc.ProblemaOrientacaoTccDTO;
import com.ufcg.psoft.tccMatch.mapper.tcc.ProblemaOrientacaoTccMapper;
import com.ufcg.psoft.tccMatch.model.tcc.OrientacaoTcc;
import com.ufcg.psoft.tccMatch.model.tcc.ProblemaOrientacaoTcc;
import com.ufcg.psoft.tccMatch.model.usuario.UsuarioTcc;
import com.ufcg.psoft.tccMatch.repository.tcc.ProblemaOrientacaoTccRepository;
import com.ufcg.psoft.tccMatch.service.tcc.OrientacaoTccService;
import com.ufcg.psoft.tccMatch.service.tcc.ProblemaOrientacaoTccService;
import com.ufcg.psoft.tccMatch.service.usuario.UsuarioService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class ProblemaOrientacaoTccServiceImpl implements ProblemaOrientacaoTccService {

    private final UsuarioService usuarioService;
    private final OrientacaoTccService orientacaoTccService;

    private final ProblemaOrientacaoTccRepository problemaOrientacaoTccRepository;

    private final ProblemaOrientacaoTccMapper problemaOrientacaoTccMapper;

    private void salvarProblemaOrientacaoTcc(ProblemaOrientacaoTcc problemaOrientacaoTcc) {
        problemaOrientacaoTccRepository.save(problemaOrientacaoTcc);
    }

    public ProblemaOrientacaoTccDTO reportarProblemaOrientacaoTcc (Long idUsuario, ProblemaOrientacaoTccDTO problemaOrientacaoTccDTO) {
        UsuarioTcc usuarioTcc = usuarioService.getUsuarioTcc(idUsuario);
        OrientacaoTcc orientacaoTcc = orientacaoTccService.getOrientacaoTcc(problemaOrientacaoTccDTO.getIdOrientacaoTcc());

        ProblemaOrientacaoTcc problemaOrientacaoTcc = new ProblemaOrientacaoTcc();
        problemaOrientacaoTcc.setProblema(problemaOrientacaoTccDTO.getProblema());
        problemaOrientacaoTcc.setUsuario(usuarioTcc);
        problemaOrientacaoTcc.setOrientacaoTcc(orientacaoTcc);
        salvarProblemaOrientacaoTcc(problemaOrientacaoTcc);

        return problemaOrientacaoTccMapper.toDTO(problemaOrientacaoTcc);
    }
}
