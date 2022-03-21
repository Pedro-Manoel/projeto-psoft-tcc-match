package com.ufcg.psoft.tccMatch.controller;

import com.ufcg.psoft.tccMatch.dto.*;
import com.ufcg.psoft.tccMatch.dto.usuario.ProfessorDTO;
import com.ufcg.psoft.tccMatch.model.AreaEstudo;
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
    public ResponseEntity<?> listarTemasTcc () {
        List<TemaTccUsuarioDTO> temasTccUsuariosDTO = professorService.listarTemasTccProfessores();

        return new ResponseEntity<>(temasTccUsuariosDTO, HttpStatus.OK);
    }
}
