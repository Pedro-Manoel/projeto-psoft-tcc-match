package com.ufcg.psoft.tccMatch.service.tcc.implementation;

import com.ufcg.psoft.tccMatch.dto.tcc.TemaTccDTO;
import com.ufcg.psoft.tccMatch.dto.tcc.TemaTccUsuarioDTO;
import com.ufcg.psoft.tccMatch.error.exception.EntidadeJaExisteException;
import com.ufcg.psoft.tccMatch.mapper.tcc.TemaTccMapper;
import com.ufcg.psoft.tccMatch.mapper.usuario.UsuarioMapper;
import com.ufcg.psoft.tccMatch.model.AreaEstudo;
import com.ufcg.psoft.tccMatch.model.tcc.TemaTcc;
import com.ufcg.psoft.tccMatch.model.usuario.UsuarioTcc;
import com.ufcg.psoft.tccMatch.repository.tcc.TemaTccRepository;
import com.ufcg.psoft.tccMatch.service.AreaEstudoService;
import com.ufcg.psoft.tccMatch.service.tcc.TemaTccService;
import com.ufcg.psoft.tccMatch.service.usuario.UsuarioService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class TemaTccServiceImpl implements TemaTccService {

    private final TemaTccRepository temaTccRepository;

    private final AreaEstudoService areaEstudoService;
    private final UsuarioService usuarioService;

    private final TemaTccMapper temaTccMapper;
    private final UsuarioMapper usuarioMapper;

    private void salvarTemaTcc (TemaTcc temaTcc) {
        temaTccRepository.save(temaTcc);
    }

    public TemaTccDTO criarTemaTccUsuario (UsuarioTcc usuarioTcc, TemaTccDTO temaTccDTO) {
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

    public List<TemaTccDTO> listarTemasTccUsuario (UsuarioTcc usuarioTcc) {
        List<TemaTcc> temasTccUsuario = usuarioTcc.getTemasTcc();

        return temaTccMapper.toDTOs(temasTccUsuario);
    }

    public List<TemaTccUsuarioDTO> listarTemasTccUsuarios (List<UsuarioTcc> usuariosTcc) {
        List<TemaTccUsuarioDTO> temasTccUsuarioDTO = new ArrayList<>();

        for (UsuarioTcc usuarioTcc : usuariosTcc) {
            for (TemaTcc temaTcc : usuarioTcc.getTemasTcc()) {
                TemaTccUsuarioDTO temaTccUsuarioDTO = new TemaTccUsuarioDTO();
                temaTccUsuarioDTO.setTemaTcc(temaTccMapper.toDTO(temaTcc));
                temaTccUsuarioDTO.setUsuario(usuarioMapper.toDTO(usuarioTcc));
                temasTccUsuarioDTO.add(temaTccUsuarioDTO);
            }
        }

        return temasTccUsuarioDTO;
    }
}
