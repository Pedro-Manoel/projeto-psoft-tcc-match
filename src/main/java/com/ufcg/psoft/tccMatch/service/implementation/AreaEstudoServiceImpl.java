package com.ufcg.psoft.tccMatch.service.implementation;

import com.ufcg.psoft.tccMatch.dto.AreaEstudoDTO;
import com.ufcg.psoft.tccMatch.exception.EntidadeJaExisteException;
import com.ufcg.psoft.tccMatch.exception.EntidadeNaoExisteException;
import com.ufcg.psoft.tccMatch.mapper.AreaEstudoMapper;
import com.ufcg.psoft.tccMatch.model.AreaEstudo;
import com.ufcg.psoft.tccMatch.model.usuario.Aluno;
import com.ufcg.psoft.tccMatch.model.usuario.UsuarioTCC;
import com.ufcg.psoft.tccMatch.repository.AreaEstudoRepository;
import com.ufcg.psoft.tccMatch.service.AreaEstudoService;
import com.ufcg.psoft.tccMatch.service.UsuarioService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ufcg.psoft.tccMatch.service.AlunoService;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class AreaEstudoServiceImpl implements AreaEstudoService {

    private final AreaEstudoRepository areaEstudoRepository;

    private final AreaEstudoMapper areaEstudoMapper = AreaEstudoMapper.INSTANCE;

    private final UsuarioService usuarioService;

    public AreaEstudoDTO criarAreaEstudo (AreaEstudoDTO areaEstudoDTO) {
        if (areaEstudoRepository.existsByNome(areaEstudoDTO.getNome())) {
            throw new EntidadeJaExisteException("Área de estudo", "nome", areaEstudoDTO.getNome());
        }

        AreaEstudo areaEstudo = areaEstudoMapper.toEntity(areaEstudoDTO);
        salvarAreaEstudo(areaEstudo);

        return areaEstudoMapper.toDTO(areaEstudo);
    }
    
    public List<AreaEstudo> selecionarAreasEstudoUsuarioTCC(Long id, List<String> nomesAreasEstudo) {
        UsuarioTCC usuarioTCC = usuarioService.getUsuarioTCC(id);

        for (String nomeAreaEstudo : nomesAreasEstudo) {
            AreaEstudo areaEstudo = getAreaEstudo(nomeAreaEstudo);
            usuarioTCC.adicionarAreaEstudo(areaEstudo);
        }

        usuarioService.salvarUsuario(usuarioTCC);

        return usuarioTCC.getAreasEstudo();
        
    }

    private void salvarAreaEstudo (AreaEstudo areaEstudo) {
        areaEstudoRepository.save(areaEstudo);
    }

    private AreaEstudo getAreaEstudo (String nome) {
        return areaEstudoRepository.getByNome(nome)
            .orElseThrow(() -> new EntidadeNaoExisteException("Área de estudo", "nome", nome));
    }

    public List<AreaEstudo> getAreasEstudo(List<String> nomesAreasEstudo) {
        List<AreaEstudo> areasEstudos = new ArrayList<>();

        for (String nomeAreaEstudo : nomesAreasEstudo) {
            AreaEstudo areaEstudo = getAreaEstudo(nomeAreaEstudo);
            areasEstudos.add(areaEstudo);
        }

        return areasEstudos;
    }
}
