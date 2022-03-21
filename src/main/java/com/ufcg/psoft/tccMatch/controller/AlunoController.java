package com.ufcg.psoft.tccMatch.controller;

import com.ufcg.psoft.tccMatch.dto.AreaEstudoDTO;
import com.ufcg.psoft.tccMatch.dto.TemaTccDTO;
import com.ufcg.psoft.tccMatch.dto.TemaTccUsuarioDTO;
import com.ufcg.psoft.tccMatch.dto.usuario.AlunoDTO;
import com.ufcg.psoft.tccMatch.dto.MessageDTO;
import com.ufcg.psoft.tccMatch.model.AreaEstudo;
import com.ufcg.psoft.tccMatch.service.AlunoService;
import com.ufcg.psoft.tccMatch.service.AreaEstudoService;
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
@RequestMapping("/api/alunos")
@Tag(name = "Aluno")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class AlunoController {

    private final AlunoService alunoService;
    private final AreaEstudoService areaEstudoService;
    private final TemaTccService temaTccService;

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
    public ResponseEntity<?> selecionarAreasEstudoAluno (@PathVariable("id") Long id, @RequestBody List<AreaEstudoDTO> areasEstudoDTO) {
        List<AreaEstudo> areasEstudo = areaEstudoService.selecionarAreasEstudoUsuarioTcc(id, areasEstudoDTO);

        return new ResponseEntity<>(areasEstudo, HttpStatus.CREATED);
    }

    @PostMapping("/{id}/temastcc")
    @Operation(summary = "Criar tema de TCC de aluno")
    public ResponseEntity<?> criarTemaTcc (@PathVariable("id") Long id, @RequestBody TemaTccDTO temaTccDTO) {
        TemaTccDTO temaTccCriadoDTO = temaTccService.criarTemaTcc(id , temaTccDTO);

        return new ResponseEntity<>(temaTccCriadoDTO, HttpStatus.CREATED);
    }

    @GetMapping("/temastcc")
    @Operation(summary = "Listar temas de TCC dos alunos")
    public ResponseEntity<?> listarTemasTcc () {
        List<TemaTccUsuarioDTO> temasTccUsuariosDTO = alunoService.listarTemasTccAlunos();

        return new ResponseEntity<>(temasTccUsuariosDTO, HttpStatus.OK);
    }
}
