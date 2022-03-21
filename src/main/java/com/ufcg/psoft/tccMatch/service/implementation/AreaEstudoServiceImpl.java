package com.ufcg.psoft.tccMatch.service.implementation;

import com.ufcg.psoft.tccMatch.dto.AreaEstudoDTO;
import com.ufcg.psoft.tccMatch.exception.EntidadeJaExisteException;
import com.ufcg.psoft.tccMatch.exception.EntidadeNaoExisteException;
import com.ufcg.psoft.tccMatch.mapper.AreaEstudoMapper;
import com.ufcg.psoft.tccMatch.model.AreaEstudo;
import com.ufcg.psoft.tccMatch.model.usuario.UsuarioTcc;
import com.ufcg.psoft.tccMatch.repository.AreaEstudoRepository;
import com.ufcg.psoft.tccMatch.service.AreaEstudoService;
import com.ufcg.psoft.tccMatch.service.UsuarioService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class AreaEstudoServiceImpl implements AreaEstudoService {

    private final AreaEstudoRepository areaEstudoRepository;

    private final UsuarioService usuarioService;

    private final AreaEstudoMapper areaEstudoMapper;

    public AreaEstudoDTO criarAreaEstudo (AreaEstudoDTO areaEstudoDTO) {
        if (areaEstudoRepository.existsByNome(areaEstudoDTO.getNome())) {
            throw new EntidadeJaExisteException("Área de estudo", "nome", areaEstudoDTO.getNome());
        }

        AreaEstudo areaEstudo = areaEstudoMapper.toEntity(areaEstudoDTO);
        salvarAreaEstudo(areaEstudo);

        return areaEstudoMapper.toDTO(areaEstudo);
    }
    
    public List<AreaEstudo> selecionarAreasEstudoUsuarioTcc(Long id, List<AreaEstudoDTO> areasEstudoDTO) {
        UsuarioTcc usuarioTcc = usuarioService.getUsuarioTcc(id);

        for (AreaEstudoDTO areaEstudoDTO : areasEstudoDTO) {
            AreaEstudo areaEstudo = getAreaEstudo(areaEstudoDTO.getNome());
            usuarioTcc.adicionarAreaEstudo(areaEstudo);
        }

        usuarioService.salvarUsuario(usuarioTcc);

        return usuarioTcc.getAreasEstudo();
        
    }

    private void salvarAreaEstudo (AreaEstudo areaEstudo) {
        areaEstudoRepository.save(areaEstudo);
    }

    private AreaEstudo getAreaEstudo (String nome) {
        return areaEstudoRepository.getByNome(nome)
            .orElseThrow(() -> new EntidadeNaoExisteException("Área de estudo", "nome", nome));
    }

    public List<AreaEstudo> getAreasEstudo(List<AreaEstudoDTO> areasEstudoDTO) {
        List<AreaEstudo> areasEstudos = new ArrayList<>();

        for (AreaEstudoDTO areaEstudoDTO : areasEstudoDTO) {
            AreaEstudo areaEstudo = getAreaEstudo(areaEstudoDTO.getNome());
            areasEstudos.add(areaEstudo);
        }

        return areasEstudos;
    }
}
