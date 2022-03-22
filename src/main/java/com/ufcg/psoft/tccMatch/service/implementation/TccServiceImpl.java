package com.ufcg.psoft.tccMatch.service.implementation;

import com.ufcg.psoft.tccMatch.dto.MessageDTO;
import com.ufcg.psoft.tccMatch.dto.OrientacaoTccDTO;
import com.ufcg.psoft.tccMatch.dto.SolicitacaoOrientacaoTccDTO;
import com.ufcg.psoft.tccMatch.exception.*;
import com.ufcg.psoft.tccMatch.mapper.OrientacaoTccMapper;
import com.ufcg.psoft.tccMatch.model.OrientacaoTcc;
import com.ufcg.psoft.tccMatch.model.SolicitacaoOrientacaoTcc;
import com.ufcg.psoft.tccMatch.model.Tcc;
import com.ufcg.psoft.tccMatch.model.TemaTcc;
import com.ufcg.psoft.tccMatch.model.usuario.Aluno;
import com.ufcg.psoft.tccMatch.model.usuario.Coordenador;
import com.ufcg.psoft.tccMatch.model.usuario.Professor;
import com.ufcg.psoft.tccMatch.repository.OrientacaoTccRepository;
import com.ufcg.psoft.tccMatch.service.CoordenadorService;
import com.ufcg.psoft.tccMatch.service.ProfessorService;
import com.ufcg.psoft.tccMatch.service.TccService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * No lugar de coordenador ter uma lista de orientaçãoTcc e ProblemasRoeintacaoTcc
 * é melhor eles não existirem e só trabalhar com os repositorios
 *
 */

@Service
@Transactional
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class TccServiceImpl implements TccService {

    private final ProfessorService professorService;
    private final OrientacaoTccRepository orientacaoTccRepository;
    private final CoordenadorService coordenadorService;

    private final OrientacaoTccMapper orientacaoTccMapper;

    public MessageDTO solicitarOrientacao(Aluno aluno, SolicitacaoOrientacaoTccDTO solicitacaoOrientacaoTccDTO) {
        Professor professor = professorService.getProfessor(solicitacaoOrientacaoTccDTO.getProfessorId());
        TemaTcc temaTcc = professor.getTemaTcc(solicitacaoOrientacaoTccDTO.getTemaTcc());

        if (temaTcc == null) {
            throw new TemaTccInvalidoProfessorException(solicitacaoOrientacaoTccDTO.getTemaTcc());
        }

        if (professor.solicitacaoEmAndamento(aluno, temaTcc)) {
            throw new SolicitacaoOrientacaoTccInvalidaException(solicitacaoOrientacaoTccDTO.getTemaTcc());
        }

        SolicitacaoOrientacaoTcc solicitacaoOrientacaoTcc = new SolicitacaoOrientacaoTcc();
        solicitacaoOrientacaoTcc.setAluno(aluno);
        solicitacaoOrientacaoTcc.setTemaTcc(temaTcc);
        professor.adicionarSolicitacaoOrientacaoTcc(solicitacaoOrientacaoTcc);

        professorService.salvarProfessor(professor);

        return new MessageDTO("Solicitação realizada com sucesso");
    }

    private void salvarOrientacaoTcc (OrientacaoTcc orientacaoTcc) { orientacaoTccRepository.save(orientacaoTcc); }


    public OrientacaoTccDTO criarOrientacaoTcc (Professor professor, OrientacaoTccDTO orientacaoTccDTO) {
        SolicitacaoOrientacaoTcc solicitacaoOrientacaoTcc = professor.getSolicitacaoOrientacao(orientacaoTccDTO.getIdSolicitacao());

        if (!solicitacaoOrientacaoTcc.isAceita() | solicitacaoOrientacaoTcc.isVinculadaComTcc()) {
            throw new SolicitacaoOrientacaoTccNaoAceitaException(solicitacaoOrientacaoTcc.getId());
        }

        solicitacaoOrientacaoTcc.setVinculadaComTcc(true);
        professorService.salvarProfessor(professor);


        Tcc tcc = new Tcc();
        tcc.setAluno(solicitacaoOrientacaoTcc.getAluno());
        tcc.setTema(solicitacaoOrientacaoTcc.getTemaTcc());
        tcc.setProfessor(professor);

        OrientacaoTcc orientacaoTcc = new OrientacaoTcc();
        orientacaoTcc.setTcc(tcc);
        orientacaoTcc.setSemestre(orientacaoTccDTO.getSemestre());

        salvarOrientacaoTcc(orientacaoTcc);

        // Colocar tudo isso no service de coordenador depois
        Coordenador coordenador = coordenadorService.getCoordenador();
        coordenador.adicionarOrientacaoTcc(orientacaoTcc);
        coordenadorService.salvarCoordenador(coordenador);

        return orientacaoTccMapper.toDTO(orientacaoTcc);
    }

    public OrientacaoTcc getOrientacaoTcc (Long id) {
        return orientacaoTccRepository.findById(id)
                .orElseThrow(() -> new EntidadeNaoExisteException("Orientação de TCC", "id", id.toString()));
    }

    public OrientacaoTccDTO finalizarOrientacaoTcc (Long id) {
        OrientacaoTcc orientacaoTcc = getOrientacaoTcc(id);

        if (orientacaoTcc.isConcluida()) {
            throw new OrientacaoTccJaFinalizadaException(id);
        }

        orientacaoTcc.finalizar();
        salvarOrientacaoTcc(orientacaoTcc);

        System.out.println(orientacaoTcc.isConcluida());

        return orientacaoTccMapper.toDTO(orientacaoTcc);
    }

    public List<OrientacaoTccDTO> listarOrientacoesTccEmCursoProfessor (Professor professor) {
        List<OrientacaoTcc> orientacoesTcc = orientacaoTccRepository.findByConcluidaIsFalseAndTccProfessor_Id(professor.getId());

        return orientacaoTccMapper.toDTOs(orientacoesTcc);
    }
}
