package com.ufcg.psoft.tccMatch.controller;

import com.ufcg.psoft.tccMatch.dto.AlunoDTO;
import com.ufcg.psoft.tccMatch.dto.AreaEstudoDTO;
import com.ufcg.psoft.tccMatch.dto.MessageDTO;
import com.ufcg.psoft.tccMatch.model.AreaEstudo;
import com.ufcg.psoft.tccMatch.model.usuario.Aluno;
import com.ufcg.psoft.tccMatch.service.AlunoService;
import com.ufcg.psoft.tccMatch.service.AreaEstudoService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/alunos")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class AlunoController {
    private final AlunoService alunoService;
    private final AreaEstudoService areaEstudoService;

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
        
        MessageDTO messageDTO = new MessageDTO(
            String.format("Aluno com id %s foi removido com sucesso do sistema", id)
        );

        return new ResponseEntity<>(messageDTO, HttpStatus.OK);
    }

    @PostMapping("/{id}/selecionarAreasEstudo")
    public ResponseEntity<?> selecionarAreasEstudo (@PathVariable("id") Long id, @RequestBody List<AreaEstudoDTO> areasEstudoDTO) {
        List<AreaEstudo> areasEstudo = areaEstudoService.selecionarAreasEstudoAluno(id ,areasEstudoDTO);

        return new ResponseEntity<>(areasEstudo, HttpStatus.CREATED);
    }
}
