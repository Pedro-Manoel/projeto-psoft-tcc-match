package com.ufcg.psoft.tccMatch.controller;

import com.ufcg.psoft.tccMatch.dto.ProfessorDTO;
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
        Professor professor = professorService.criarProfessor(professorDTO);

        return new ResponseEntity<>(professor, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> atualizarProfessor (@PathVariable("id") Long id, @RequestBody ProfessorDTO professorDTO) {
        Professor professor = professorService.atualizarProfessor(id, professorDTO);

        return new ResponseEntity<>(professor, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> removerProfessor (@PathVariable("id") Long id) {
        professorService.removerProfessor(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
