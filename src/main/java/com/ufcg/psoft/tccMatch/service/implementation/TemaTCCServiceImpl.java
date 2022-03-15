package com.ufcg.psoft.tccMatch.service.implementation;

import com.ufcg.psoft.tccMatch.dto.TemaTCCDTO;
import com.ufcg.psoft.tccMatch.exception.EntidadeJaExisteException;
import com.ufcg.psoft.tccMatch.model.AreaEstudo;
import com.ufcg.psoft.tccMatch.model.TemaTCC;
import com.ufcg.psoft.tccMatch.model.usuario.Aluno;
import com.ufcg.psoft.tccMatch.repository.TemaTCCRepository;
import com.ufcg.psoft.tccMatch.service.AlunoService;
import com.ufcg.psoft.tccMatch.service.AreaEstudoService;
import com.ufcg.psoft.tccMatch.service.TemaTCCService;
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

    private AlunoService alunoService;
    private AreaEstudoService areaEstudoService;

    @Override
    public TemaTCC criarTemaTCC(Long id, TemaTCCDTO temaTCCDTO) {
        Aluno aluno = alunoService.getAluno(id);
        List<AreaEstudo> areasEstudo = areaEstudoService.getAreasEstudo(temaTCCDTO.getAreasEstudo());

        if (temaTCCRepository.existsByTitulo(temaTCCDTO.getTitulo())) {
            throw new EntidadeJaExisteException("Tema TCC", "título", temaTCCDTO.getTitulo());
        }

        TemaTCC temaTCC = new TemaTCC();
        temaTCC.setTitulo(temaTCCDTO.getTitulo());
        temaTCC.setDescricao(temaTCCDTO.getDescricao());
        temaTCC.setAreasEstudo(areasEstudo);
        temaTCC.setStatus(temaTCCDTO.getStatus());

        aluno.adicionarTemaTCC(temaTCC);
        alunoService.salvarAluno(aluno);

        return temaTCC;
    }
}
