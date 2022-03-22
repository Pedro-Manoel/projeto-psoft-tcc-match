package com.ufcg.psoft.tccMatch.controller;

import com.ufcg.psoft.tccMatch.dto.*;
import com.ufcg.psoft.tccMatch.dto.message.MessageDTO;
import com.ufcg.psoft.tccMatch.dto.tcc.TemaTccDTO;
import com.ufcg.psoft.tccMatch.dto.tcc.TemaTccUsuarioDTO;
import com.ufcg.psoft.tccMatch.dto.usuario.ProfessorDTO;
import com.ufcg.psoft.tccMatch.dto.usuario.UsuarioDTO;
import com.ufcg.psoft.tccMatch.model.usuario.Aluno;
import com.ufcg.psoft.tccMatch.model.usuario.Professor;
import com.ufcg.psoft.tccMatch.model.usuario.UsuarioTcc;
import com.ufcg.psoft.tccMatch.service.*;
import com.ufcg.psoft.tccMatch.service.tcc.TemaTccService;
import com.ufcg.psoft.tccMatch.service.usuario.AlunoService;
import com.ufcg.psoft.tccMatch.service.usuario.ProfessorService;
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
@RequestMapping("/api/professores")
@Tag(name = "Professor")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class ProfessorController {

    private final ProfessorService professorService;
    private final AlunoService alunoService;
    private final AreaEstudoService areaEstudoService;
    private final TemaTccService temaTccService;

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

    @PostMapping("/{id}/areasestudo")
    @Operation(summary = "Selecionar áreas de estudo de professor")
    public ResponseEntity<?> selecionarAreasEstudoProfessor (@PathVariable("id") Long id, @RequestBody List<AreaEstudoDTO> areasEstudoDTO) {
        Professor professor = professorService.getProfessor(id);

        List<AreaEstudoDTO> areasEstudoSelecionadasDTO = areaEstudoService.selecionarAreasEstudoUsuario(professor, areasEstudoDTO);

        return new ResponseEntity<>(areasEstudoSelecionadasDTO, HttpStatus.CREATED);
    }

    @PostMapping("/{id}/temastcc")
    @Operation(summary = "Criar tema de TCC de professor")
    public ResponseEntity<?> criarTemaTccProfessor (@PathVariable("id") Long id, @RequestBody TemaTccDTO temaTccDTO) {
        Professor professor = professorService.getProfessor(id);

        TemaTccDTO temaTccCriadoDTO = temaTccService.criarTemaTccUsuario(professor, temaTccDTO);

        return new ResponseEntity<>(temaTccCriadoDTO, HttpStatus.CREATED);
    }

    @GetMapping("{id}/temastcc")
    @Operation(summary = "Listar temas de TCC de professor")
    public ResponseEntity<?> listarTemasTccProfessor (@PathVariable("id") Long id) {
        Professor professor = professorService.getProfessor(id);

        List<TemaTccDTO> temasTccProfessorDTO = temaTccService.listarTemasTccUsuario(professor);

        return new ResponseEntity<>(temasTccProfessorDTO, HttpStatus.OK);
    }

    @GetMapping("/temastcc")
    @Operation(summary = "Listar temas de TCC dos professores")
    public ResponseEntity<?> listarTemasTccProfessores () {
        List<Professor> professores = professorService.getProfessores();
        List<UsuarioTcc> usuariosTcc = Collections.unmodifiableList(professores);

        List<TemaTccUsuarioDTO> temasTccProfessoresDTO = temaTccService.listarTemasTccUsuarios(usuariosTcc);

        return new ResponseEntity<>(temasTccProfessoresDTO, HttpStatus.OK);
    }

    @GetMapping("/aluno/{idAluno}")
    @Operation(summary = "Listar professores disponíveis para orientação de TCC")
    public ResponseEntity<?> listarProfessoresDisponiveisOrientacao (@PathVariable("idAluno") Long id) {
        Aluno aluno = alunoService.getAluno(id);
        List<UsuarioDTO> professoresDTO = professorService.listarProfessoresDisponiveisOrientacaoTcc(aluno.getAreasEstudo());

        return new ResponseEntity<>(professoresDTO, HttpStatus.OK);
    }
}
