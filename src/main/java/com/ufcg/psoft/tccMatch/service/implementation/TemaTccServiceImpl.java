package com.ufcg.psoft.tccMatch.service.implementation;

import com.ufcg.psoft.tccMatch.dto.TemaTccDTO;
import com.ufcg.psoft.tccMatch.exception.EntidadeJaExisteException;
import com.ufcg.psoft.tccMatch.mapper.TemaTccMapper;
import com.ufcg.psoft.tccMatch.model.AreaEstudo;
import com.ufcg.psoft.tccMatch.model.TemaTcc;
import com.ufcg.psoft.tccMatch.model.usuario.UsuarioTcc;
import com.ufcg.psoft.tccMatch.repository.TemaTccRepository;
import com.ufcg.psoft.tccMatch.service.AreaEstudoService;
import com.ufcg.psoft.tccMatch.service.TemaTccService;
import com.ufcg.psoft.tccMatch.service.UsuarioService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class TemaTccServiceImpl implements TemaTccService {

    private TemaTccRepository temaTccRepository;

    private final AreaEstudoService areaEstudoService;
    private final UsuarioService usuarioService;

    private final TemaTccMapper temaTccMapper;

    @Override
    public TemaTccDTO criarTemaTcc(Long id, TemaTccDTO temaTccDTO) {
        UsuarioTcc usuarioTcc = usuarioService.getUsuarioTcc(id);

        List<AreaEstudo> areasEstudo = areaEstudoService.getAreasEstudo(temaTccDTO.getAreasEstudo());

        if (temaTccRepository.existsByTitulo(temaTccDTO.getTitulo())) {
            throw new EntidadeJaExisteException("Tema TCC", "título", temaTccDTO.getTitulo());
        }

        TemaTcc temaTcc = temaTccMapper.toEntity(temaTccDTO);
        temaTcc.setAreasEstudo(areasEstudo);
        salvarTemaTcc(temaTcc);

        usuarioTcc.adicionarTemaTcc(temaTcc);
        usuarioService.salvarUsuario(usuarioTcc);

        return temaTccMapper.toDTO(temaTcc);
    }

    private void salvarTemaTcc (TemaTcc temaTcc) {
        temaTccRepository.save(temaTcc);
    }
}