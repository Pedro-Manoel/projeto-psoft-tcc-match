package com.ufcg.psoft.tccMatch.controller;

import com.ufcg.psoft.tccMatch.dto.usuario.AlunoDTO;
import com.ufcg.psoft.tccMatch.dto.MessageDTO;
import com.ufcg.psoft.tccMatch.dto.TemaTCCDTO;
import com.ufcg.psoft.tccMatch.model.AreaEstudo;
import com.ufcg.psoft.tccMatch.model.TemaTCC;
import com.ufcg.psoft.tccMatch.model.usuario.Aluno;
import com.ufcg.psoft.tccMatch.security.util.MyUserDetail;
import com.ufcg.psoft.tccMatch.security.util.Role;
import com.ufcg.psoft.tccMatch.service.AlunoService;
import com.ufcg.psoft.tccMatch.service.AreaEstudoService;
import com.ufcg.psoft.tccMatch.service.TemaTCCService;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/alunos")
@Tag(name = "Aluno")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class AlunoController {
    private final AlunoService alunoService;
    private final AreaEstudoService areaEstudoService;
    private final TemaTCCService temaTCCService;

    @PostMapping
    @Operation(summary = "Criar aluno")
    public ResponseEntity<?> criarAluno (@RequestBody AlunoDTO alunoDTO) {
        AlunoDTO alunoCriadoDTO = alunoService.criarAluno(alunoDTO);

        return new ResponseEntity<>(alunoCriadoDTO, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Atualizar aluno")
    public ResponseEntity<?> atualizarAluno (@PathVariable("id") Long id, @RequestBody AlunoDTO alunoDTO) {
        AlunoDTO alunoAtualizadoDTO = alunoService.atualizarAluno(id, alunoDTO);

        return new ResponseEntity<>(alunoAtualizadoDTO, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Remover aluno")
    public ResponseEntity<?> removerAluno (@PathVariable("id") Long id) {
        MessageDTO messageDTO = alunoService.removerAluno(id);

        return new ResponseEntity<>(messageDTO, HttpStatus.OK);
    }

    @PostMapping("/{id}/areasestudo")
    @Operation(summary = "Selecionar áreas de estudo de aluno")
    public ResponseEntity<?> selecionarAreasEstudoAluno (@PathVariable("id") Long id, @RequestBody List<String> nomesAreasEstudo) {
        List<AreaEstudo> areasEstudo = areaEstudoService.selecionarAreasEstudoUsuarioTCC(id, nomesAreasEstudo);

        return new ResponseEntity<>(areasEstudo, HttpStatus.CREATED);
    }

    @PostMapping("/{id}/temastcc")
    @Operation(summary = "Criar tema de TCC de aluno")
    public ResponseEntity<?> criarTemaTCC (@PathVariable("id") Long id, @RequestBody TemaTCCDTO temaTCCDTO) {
        TemaTCC temaTCC = temaTCCService.criarTemaTCC(id , temaTCCDTO);

        return new ResponseEntity<>(temaTCC, HttpStatus.CREATED);
    }
}
