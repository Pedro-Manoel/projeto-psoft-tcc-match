package com.ufcg.psoft.tccMatch.controller;

import com.ufcg.psoft.tccMatch.dto.MessageDTO;
import com.ufcg.psoft.tccMatch.dto.usuario.ProfessorDTO;
import com.ufcg.psoft.tccMatch.dto.QuotaProfessorDTO;
import com.ufcg.psoft.tccMatch.model.usuario.Professor;
import com.ufcg.psoft.tccMatch.service.ProfessorService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/api/professores")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class ProfessorController {
    private final ProfessorService professorService;
    
    @PostMapping
    public ResponseEntity<?> criarProfessor (@RequestBody ProfessorDTO professorDTO) {
        ProfessorDTO professorCriadoDTO = professorService.criarProfessor(professorDTO);

        return new ResponseEntity<>(professorCriadoDTO, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> atualizarProfessor (@PathVariable("id") Long id, @RequestBody ProfessorDTO professorDTO) {
        ProfessorDTO professorAtualizadoDTO = professorService.atualizarProfessor(id, professorDTO);

        return new ResponseEntity<>(professorAtualizadoDTO, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> removerProfessor (@PathVariable("id") Long id) {
        MessageDTO messageDTO = professorService.removerProfessor(id);

        return new ResponseEntity<>(messageDTO, HttpStatus.OK);
    }

    @PatchMapping("/{id}/quota")
    public ResponseEntity<?> atualizarQuotaProfessor (@PathVariable("id") Long id, @RequestBody QuotaProfessorDTO quotaProfessorDTO) {
        ProfessorDTO professorQuotaAtualizadaDTO = professorService.atualizarQuotaProfessor(id, quotaProfessorDTO);

        return new ResponseEntity<>(professorQuotaAtualizadaDTO, HttpStatus.OK);
    }
}
