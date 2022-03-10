package com.ufcg.psoft.tccMatch.service.implementation;

import com.ufcg.psoft.tccMatch.dto.AreaEstudoDTO;
import com.ufcg.psoft.tccMatch.exception.AreaEstudoJaExisteException;
import com.ufcg.psoft.tccMatch.exception.AreaEstudoNaoExisteException;
import com.ufcg.psoft.tccMatch.model.AreaEstudo;
import com.ufcg.psoft.tccMatch.model.usuario.Aluno;
import com.ufcg.psoft.tccMatch.repository.AreaEstudoRepository;
import com.ufcg.psoft.tccMatch.service.AreaEstudoService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ufcg.psoft.tccMatch.service.AlunoService;

import java.util.List;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class AreaEstudoImpl implements AreaEstudoService {
    private AlunoService alunoService;
    private AreaEstudoRepository areaEstudoRepository;
    
    public AreaEstudo criarAreaEstudo (AreaEstudoDTO areaEstudoDTO) {
        if (areaEstudoRepository.existsByNome(areaEstudoDTO.getNome())) {
            throw new AreaEstudoJaExisteException(areaEstudoDTO.getNome());
        }

        AreaEstudo areaEstudoSendoCriada = new AreaEstudo();
        areaEstudoSendoCriada.setNome(areaEstudoDTO.getNome());
        salvarAreaEstudo(areaEstudoSendoCriada);

        return areaEstudoSendoCriada;
    }
    
    public List<AreaEstudo> selecionarAreasEstudoAluno(Long id,List<AreaEstudoDTO> areasEstudoDTO) {
        Aluno aluno = alunoService.getAluno(id);
        for (AreaEstudoDTO areaEstudoDTO : areasEstudoDTO) {
            AreaEstudo areaEstudo = getAreaEstudo(areaEstudoDTO.getNome());
            aluno.adicionarAreaEstudo(areaEstudo);
        }
        alunoService.salvarAluno(aluno);
        return aluno.getAreasEstudo();
        
    }

    private void salvarAreaEstudo (AreaEstudo areaEstudo) {
        areaEstudoRepository.save(areaEstudo);
    }

    public List<AreaEstudo> selecionarAreasEstudoProfessor(Long id,List<AreaEstudoDTO> areaEstudoDTO) {

        return null;
    }

    private void salvarAreaEstudoProfessor (AreaEstudo areaEstudo) {
        areaEstudoRepository.save(areaEstudo);
    }

    private AreaEstudo getAreaEstudo (String nome) {
        return areaEstudoRepository.getByNome(nome)
            .orElseThrow(() -> new AreaEstudoNaoExisteException(nome));
    }
}
