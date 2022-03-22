package com.ufcg.psoft.tccMatch.controller;

import com.ufcg.psoft.tccMatch.dto.MessageDTO;
import com.ufcg.psoft.tccMatch.dto.OrientacaoTccDTO;
import com.ufcg.psoft.tccMatch.dto.SolicitacaoOrientacaoTccDTO;
import com.ufcg.psoft.tccMatch.model.OrientacaoTcc;
import com.ufcg.psoft.tccMatch.model.ProblemaOrientacaoTcc;
import com.ufcg.psoft.tccMatch.model.usuario.Aluno;
import com.ufcg.psoft.tccMatch.model.usuario.Professor;
import com.ufcg.psoft.tccMatch.service.AlunoService;
import com.ufcg.psoft.tccMatch.service.ProfessorService;
import com.ufcg.psoft.tccMatch.service.implementation.TccServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/orientacoestcc")
@Tag(name = "Orientação TCC")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class OrientacaoTccController {

    private TccServiceImpl tccService;
    private AlunoService alunoService;
    private ProfessorService professorService;

    @PostMapping("solicitacoes/{id}")
    @Operation(summary = "Solicitar Orientação de TCC a professor")
    public ResponseEntity<?> solicitarOrientacaoTcc (@PathVariable("id") Long id, @RequestBody SolicitacaoOrientacaoTccDTO solicitacaoOrientacaoTccDTO) {
        Aluno aluno = alunoService.getAluno(id);
        MessageDTO messageDTO = tccService.solicitarOrientacao(aluno, solicitacaoOrientacaoTccDTO);

        return new ResponseEntity<>(messageDTO, HttpStatus.CREATED);
    }

    @PostMapping("/{id}")
    @Operation(summary = "Criar Orientação de TCC")
    public ResponseEntity<?> criarOrientacaoTcc (@PathVariable("id") Long id, @RequestBody OrientacaoTccDTO orientacaoTccDTO) {
        Professor professor = professorService.getProfessor(id);
        OrientacaoTccDTO orientacaoTccCriadaDTO = tccService.criarOrientacaoTcc(professor, orientacaoTccDTO);

        return new ResponseEntity<>(orientacaoTccCriadaDTO, HttpStatus.CREATED);
    }

    @PostMapping("/{id}/finalizar")
    @Operation(summary = "Finalizar Orientação de TCC")
    public ResponseEntity<?> finalizarOrientacaoTcc (@PathVariable("id") Long id) {
        OrientacaoTccDTO orientacaoTccFinalizadaDTO = tccService.finalizarOrientacaoTcc(id);

        return new ResponseEntity<>(orientacaoTccFinalizadaDTO, HttpStatus.CREATED);
    }

    @GetMapping("/professor/{id}")
    @Operation(summary = "Listar Orientações de TCC em curso do professor")
    public ResponseEntity<?> listarOrientacaoTccEmCursoProfessor (@PathVariable("id") Long id) {
        Professor professor = professorService.getProfessor(id);
        List<OrientacaoTccDTO> orinetacoesTccDTO =  tccService.listarOrientacoesTccEmCursoProfessor(professor);

        return new ResponseEntity<>(orinetacoesTccDTO, HttpStatus.CREATED);
    }

    // aqui para baixo

    @GetMapping()
    @Operation(summary = "Listar Orientações de TCC")
    public ResponseEntity<?> listarOrientacaoTccEmCursoPorSemestre (
            @RequestParam(defaultValue = "false") Boolean finalizada,
            @RequestParam(defaultValue = "2022") String semestre
    ) {
        List<OrientacaoTccDTO> orinetacoesTccDTO =  tccService.listarOrientacoesTcc(finalizada, semestre);

        return new ResponseEntity<>(orinetacoesTccDTO, HttpStatus.CREATED);
    }
}