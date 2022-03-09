package com.ufcg.psoft.tccMatch.controller;

import com.ufcg.psoft.tccMatch.dto.AlunoDTO;
import com.ufcg.psoft.tccMatch.model.usuario.Aluno;
import com.ufcg.psoft.tccMatch.service.AlunoService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/api/alunos")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class AlunoController {
    private final AlunoService alunoService;

    @PostMapping
    public ResponseEntity<?> criarAluno (@RequestBody AlunoDTO alunoDTO) {
        Aluno aluno = alunoService.criarAluno(alunoDTO);

        return new ResponseEntity<>(aluno, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> atualizarAluno (@PathVariable("id") Long id, @RequestBody AlunoDTO alunoDTO) {
        Aluno aluno = alunoService.atualizarAluno(id, alunoDTO);

        return new ResponseEntity<>(aluno, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> removerAluno (@PathVariable("id") Long id) {
        alunoService.removerAluno(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
