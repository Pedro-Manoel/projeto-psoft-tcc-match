package com.ufcg.psoft.tccMatch.controller;

import com.ufcg.psoft.tccMatch.dto.MessageDTO;
import com.ufcg.psoft.tccMatch.dto.TemaTCCDTO;
import com.ufcg.psoft.tccMatch.dto.usuario.ProfessorDTO;
import com.ufcg.psoft.tccMatch.dto.QuotaProfessorDTO;
import com.ufcg.psoft.tccMatch.model.TemaTCC;
import com.ufcg.psoft.tccMatch.security.util.Role;
import com.ufcg.psoft.tccMatch.service.ProfessorService;
import com.ufcg.psoft.tccMatch.service.TemaTCCService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;

@RestController
@CrossOrigin
@RequestMapping("/api/professores")
@Tag(name = "Professor")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class ProfessorController {
    private final ProfessorService professorService;
    private final TemaTCCService temaTCCService;

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
    public ResponseEntity<?> criarTemaTCC (@PathVariable("id") Long id, @RequestBody TemaTCCDTO temaTCCDTO) {
        TemaTCC temaTCC = temaTCCService.criarTemaTCC(id , temaTCCDTO);

        return new ResponseEntity<>(temaTCC, HttpStatus.CREATED);
    }
}
