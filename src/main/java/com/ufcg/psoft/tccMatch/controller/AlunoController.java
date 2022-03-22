package com.ufcg.psoft.tccMatch.controller;

import com.ufcg.psoft.tccMatch.dto.AreaEstudoDTO;
import com.ufcg.psoft.tccMatch.dto.tcc.TemaTccDTO;
import com.ufcg.psoft.tccMatch.dto.tcc.TemaTccUsuarioDTO;
import com.ufcg.psoft.tccMatch.dto.usuario.AlunoDTO;
import com.ufcg.psoft.tccMatch.dto.message.MessageDTO;
import com.ufcg.psoft.tccMatch.model.usuario.Aluno;
import com.ufcg.psoft.tccMatch.model.usuario.UsuarioTcc;
import com.ufcg.psoft.tccMatch.service.usuario.AlunoService;
import com.ufcg.psoft.tccMatch.service.AreaEstudoService;
import com.ufcg.psoft.tccMatch.service.tcc.TemaTccService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
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
        Aluno aluno = alunoService.getAluno(id);

        List<AreaEstudoDTO> areasEstudoSelecionadasDTO = areaEstudoService.selecionarAreasEstudoUsuario(aluno, areasEstudoDTO);

        return new ResponseEntity<>(areasEstudoSelecionadasDTO, HttpStatus.CREATED);
    }

    @PostMapping("/{id}/temastcc")
    @Operation(summary = "Criar tema de TCC de aluno")
    public ResponseEntity<?> criarTemaTccAluno (@PathVariable("id") Long id, @RequestBody TemaTccDTO temaTccDTO) {
        Aluno aluno = alunoService.getAluno(id);

        TemaTccDTO temaTccCriadoDTO = temaTccService.criarTemaTccUsuario(aluno, temaTccDTO);

        return new ResponseEntity<>(temaTccCriadoDTO, HttpStatus.CREATED);
    }

    @GetMapping("/temastcc")
    @Operation(summary = "Listar temas de TCC dos alunos")
    public ResponseEntity<?> listarTemasTccAlunos () {
        List<Aluno> alunos = alunoService.getAlunos();
        List<UsuarioTcc> usuariosTcc = Collections.unmodifiableList(alunos);

        List<TemaTccUsuarioDTO> temasTccAlunosDTO = temaTccService.listarTemasTccUsuarios(usuariosTcc);

        return new ResponseEntity<>(temasTccAlunosDTO, HttpStatus.OK);
    }
}
