package com.ufcg.psoft.tccMatch.controller;

import com.ufcg.psoft.tccMatch.dto.*;
import com.ufcg.psoft.tccMatch.dto.usuario.ProfessorDTO;
import com.ufcg.psoft.tccMatch.model.AreaEstudo;
import com.ufcg.psoft.tccMatch.model.usuario.Aluno;
import com.ufcg.psoft.tccMatch.service.AlunoService;
import com.ufcg.psoft.tccMatch.service.AreaEstudoService;
import com.ufcg.psoft.tccMatch.service.ProfessorService;
import com.ufcg.psoft.tccMatch.service.TemaTccService;
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
@RequestMapping("/api/professores")
@Tag(name = "Professor")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class ProfessorController {

    private final ProfessorService professorService;
    private final TemaTccService temaTccService;
    private final AreaEstudoService areaEstudoService;
    private final AlunoService alunoService;

    @PostMapping
    @Operation(summary = "Criar professor")
    public ResponseEntity<?> criarProfessor (@RequestBody ProfessorDTO professorDTO) {
        ProfessorDTO professorCriadoDTO = professorService.criarProfessor(professorDTO);

        return new ResponseEntity<>(professorCriadoDTO, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Atualizar professor")
    public ResponseEntity<?> atualizarProfessor (@PathVariable("id") Long id, @RequestBody ProfessorDTO professorDTO) {
        ProfessorDTO professorAtualizadoDTO = professorService.atualizarProfessor(id, professorDTO);

        return new ResponseEntity<>(professorAtualizadoDTO, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Remover professor")
    public ResponseEntity<?> removerProfessor (@PathVariable("id") Long id) {
        MessageDTO messageDTO = professorService.removerProfessor(id);

        return new ResponseEntity<>(messageDTO, HttpStatus.OK);
    }

    @PatchMapping("/{id}/quota")
    @Operation(summary = "Atualizar quota de professor")
    public ResponseEntity<?> atualizarQuotaProfessor (@PathVariable("id") Long id, @RequestBody QuotaProfessorDTO quotaProfessorDTO) {
        ProfessorDTO professorQuotaAtualizadaDTO = professorService.atualizarQuotaProfessor(id, quotaProfessorDTO);

        return new ResponseEntity<>(professorQuotaAtualizadaDTO, HttpStatus.OK);
    }

    @PostMapping("/{id}/temastcc")
    @Operation(summary = "Criar tema de TCC de professor")
    public ResponseEntity<?> criarTemaTcc (@PathVariable("id") Long id, @RequestBody TemaTccDTO temaTccDTO) {
        TemaTccDTO temaTccCriadoDTO = temaTccService.criarTemaTcc(id , temaTccDTO);

        return new ResponseEntity<>(temaTccCriadoDTO, HttpStatus.CREATED);
    }

    @PostMapping("/{id}/areasestudo")
    @Operation(summary = "Selecionar áreas de estudo de professor")
    public ResponseEntity<?> selecionarAreasEstudoAluno (@PathVariable("id") Long id, @RequestBody List<AreaEstudoDTO> areasEstudoDTO) {
        List<AreaEstudo> areasEstudo = areaEstudoService.selecionarAreasEstudoUsuarioTcc(id, areasEstudoDTO);

        return new ResponseEntity<>(areasEstudo, HttpStatus.CREATED);
    }

    @GetMapping("/temastcc")
    @Operation(summary = "Listar temas de TCC dos professores")
    public ResponseEntity<?> listarTemasTccProfessores () {
        List<TemaTccUsuarioDTO> temasTccProfessoresDTO = professorService.listarTemasTccProfessores();

        return new ResponseEntity<>(temasTccProfessoresDTO, HttpStatus.OK);
    }

    @GetMapping("{id}/temastcc")
    @Operation(summary = "Listar temas de TCC de professor")
    public ResponseEntity<?> listarTemasTccProfessor (@PathVariable("id") Long id) {
        List<TemaTccDTO> temasTccProfessorDTO = professorService.listarTemasTccProfessor(id);

        return new ResponseEntity<>(temasTccProfessorDTO, HttpStatus.OK);
    }

    @GetMapping("/aluno/{idAluno}")
    @Operation(summary = "Listar professores disponíveis para orientação")
    public ResponseEntity<?> listarProfessoresDisponiveisOrientacao (@PathVariable("idAluno") Long id) {
        Aluno aluno = alunoService.getAluno(id);
        List<ProfessorDTO> professoresDTO = professorService.listarProfessoresDisponiveisOrientacao(aluno.getAreasEstudo());

        return new ResponseEntity<>(professoresDTO, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Listar solicitações de orientação de TCC para professor")
    public ResponseEntity<?> listarSolicitacoesOrientacaoTcc (@PathVariable("id") Long id) {
        List<SolicitacaoOrientacaoTccDTO> solicitacoesOrientacaoTccDTO = professorService.listarSolicitacoesOrientacaoTcc(id);

        return new ResponseEntity<>(solicitacoesOrientacaoTccDTO, HttpStatus.OK);

        // SolicitacaoOrientacaoTccDTO responderSolicitacaoOrientacaoTcc(Long id, Long idSolicitacao, RespostaSolicitacaoOrientacaoTccDTO respostaSolicitacaoOrientacaoTccDTO)
    }

    @PostMapping("/{id}/solicitacao/{idSolicitacao}")
    @Operation(summary = "Responder solicitação de orientação de TCC para professor")
    public ResponseEntity<?> listarSolicitacoesOrientacaoTcc (@PathVariable("id") Long id, @PathVariable("idSolicitacao") Long idSolicitacao, @RequestBody RespostaSolicitacaoOrientacaoTccDTO respostaSolicitacaoOrientacaoTccDTO) {
        SolicitacaoOrientacaoTccDTO solicitacaoOrientacaoTccDTO = professorService.responderSolicitacaoOrientacaoTcc(id, idSolicitacao, respostaSolicitacaoOrientacaoTccDTO);

        return new ResponseEntity<>(solicitacaoOrientacaoTccDTO, HttpStatus.OK);


    }
}
