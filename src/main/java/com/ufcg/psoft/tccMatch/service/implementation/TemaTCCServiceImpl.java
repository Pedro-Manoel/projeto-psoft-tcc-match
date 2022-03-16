package com.ufcg.psoft.tccMatch.service.implementation;

import com.ufcg.psoft.tccMatch.dto.TemaTCCDTO;
import com.ufcg.psoft.tccMatch.exception.EntidadeJaExisteException;
import com.ufcg.psoft.tccMatch.mapper.AlunoMapper;
import com.ufcg.psoft.tccMatch.model.AreaEstudo;
import com.ufcg.psoft.tccMatch.model.TemaTCC;
import com.ufcg.psoft.tccMatch.model.usuario.UsuarioTCC;
import com.ufcg.psoft.tccMatch.repository.TemaTCCRepository;
import com.ufcg.psoft.tccMatch.service.AlunoService;
import com.ufcg.psoft.tccMatch.service.AreaEstudoService;
import com.ufcg.psoft.tccMatch.service.TemaTCCService;
import com.ufcg.psoft.tccMatch.service.UsuarioService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class TemaTCCServiceImpl implements TemaTCCService {

    private TemaTCCRepository temaTCCRepository;

    private final AreaEstudoService areaEstudoService;
    private final UsuarioService usuarioService;
    // private final TemaTCCMapper temaTCCMapper = TemaTCCMapper.INSTANCE;

    // BUG - ID não esta sendo retornado
    @Override
    public TemaTCC criarTemaTCC(Long id, TemaTCCDTO temaTCCDTO) {
        UsuarioTCC usuarioTCC = usuarioService.getUsuarioTCC(id);

        List<AreaEstudo> areasEstudo = areaEstudoService.getAreasEstudo(temaTCCDTO.getAreasEstudo());

        if (temaTCCRepository.existsByTitulo(temaTCCDTO.getTitulo())) {
            throw new EntidadeJaExisteException("Tema TCC", "título", temaTCCDTO.getTitulo());
        }

        TemaTCC temaTCC = new TemaTCC();
        temaTCC.setTitulo(temaTCCDTO.getTitulo());
        temaTCC.setDescricao(temaTCCDTO.getDescricao());
        temaTCC.setAreasEstudo(areasEstudo);
        temaTCC.setStatus(temaTCCDTO.getStatus());

        usuarioTCC.adicionarTemaTCC(temaTCC);
        usuarioService.salvarUsuario(usuarioTCC);

        return temaTCC;
    }
}
