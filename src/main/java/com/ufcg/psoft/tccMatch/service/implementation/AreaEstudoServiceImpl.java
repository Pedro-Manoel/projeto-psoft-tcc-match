package com.ufcg.psoft.tccMatch.service.implementation;

import com.ufcg.psoft.tccMatch.dto.AreaEstudoDTO;
import com.ufcg.psoft.tccMatch.error.exception.EntidadeJaExisteException;
import com.ufcg.psoft.tccMatch.error.exception.EntidadeNaoExisteException;
import com.ufcg.psoft.tccMatch.mapper.AreaEstudoMapper;
import com.ufcg.psoft.tccMatch.model.AreaEstudo;
import com.ufcg.psoft.tccMatch.model.usuario.UsuarioTcc;
import com.ufcg.psoft.tccMatch.repository.AreaEstudoRepository;
import com.ufcg.psoft.tccMatch.service.AreaEstudoService;
import com.ufcg.psoft.tccMatch.service.usuario.UsuarioService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class AreaEstudoServiceImpl implements AreaEstudoService {

    private final AreaEstudoRepository areaEstudoRepository;

    private final UsuarioService usuarioService;

    private final AreaEstudoMapper areaEstudoMapper;

    private void salvarAreaEstudo (AreaEstudo areaEstudo) {
        areaEstudoRepository.save(areaEstudo);
    }

    public AreaEstudoDTO criarAreaEstudo (AreaEstudoDTO areaEstudoDTO) {
        if (areaEstudoRepository.existsByNome(areaEstudoDTO.getNome())) {
            throw new EntidadeJaExisteException("Área de estudo", "nome", areaEstudoDTO.getNome());
        }

        AreaEstudo areaEstudo = areaEstudoMapper.toEntity(areaEstudoDTO);
        salvarAreaEstudo(areaEstudo);

        return areaEstudoMapper.toDTO(areaEstudo);
    }

    private AreaEstudo getAreaEstudo (String nome) {
        return areaEstudoRepository.getByNome(nome)
                .orElseThrow(() -> new EntidadeNaoExisteException("Área de estudo", "nome", nome));
    }

    public List<AreaEstudo> getAreasEstudo (List<AreaEstudoDTO> areasEstudoDTO) {
        return areasEstudoDTO
                .stream()
                .map(areaEstudoDTO -> getAreaEstudo(areaEstudoDTO.getNome()))
                .collect(Collectors.toList());
    }

    public List<AreaEstudoDTO> selecionarAreasEstudoUsuario (UsuarioTcc usuarioTcc, List<AreaEstudoDTO> areasEstudoDTO) {
        List<AreaEstudo> areasEstudo = getAreasEstudo(areasEstudoDTO);

        usuarioTcc.setAreasEstudo(areasEstudo);
        usuarioService.salvarUsuario(usuarioTcc);

        return areaEstudoMapper.toDTOs(areasEstudo);
    }
}
