package com.ufcg.psoft.tccMatch.controller;

import com.ufcg.psoft.tccMatch.dto.*;
import com.ufcg.psoft.tccMatch.dto.message.MessageDTO;
import com.ufcg.psoft.tccMatch.dto.tcc.tema.TemaTccDTO;
import com.ufcg.psoft.tccMatch.dto.tcc.tema.TemaTccUsuarioDTO;
import com.ufcg.psoft.tccMatch.dto.usuario.ProfessorDTO;
import com.ufcg.psoft.tccMatch.dto.usuario.QuotaProfessorDTO;
import com.ufcg.psoft.tccMatch.dto.usuario.UsuarioDTO;
import com.ufcg.psoft.tccMatch.model.tcc.TemaTcc;
import com.ufcg.psoft.tccMatch.model.usuario.Aluno;
import com.ufcg.psoft.tccMatch.model.usuario.Professor;
import com.ufcg.psoft.tccMatch.model.usuario.UsuarioTcc;
import com.ufcg.psoft.tccMatch.notification.event.TemaTccProfessorCriadoEvent;
import com.ufcg.psoft.tccMatch.security.service.AutenticacaoService;
import com.ufcg.psoft.tccMatch.security.util.Role;
import com.ufcg.psoft.tccMatch.service.*;
import com.ufcg.psoft.tccMatch.service.tcc.TemaTccService;
import com.ufcg.psoft.tccMatch.service.usuario.AlunoService;
import com.ufcg.psoft.tccMatch.service.usuario.ProfessorService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;
import java.util.Collections;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/professores")
@Tag(name = "Professor")
@SecurityRequirement(name = "bearerAuth")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class ProfessorController {

    private final ProfessorService professorService;
    private final AlunoService alunoService;
    private final AreaEstudoService areaEstudoService;
    private final TemaTccService temaTccService;
    private final AutenticacaoService autenticacaoService;

    private final ApplicationEventPublisher applicationEventPublisher;

    @PostMapping
    @RolesAllowed(Role.USER_ADMIN)
    @Operation(summary = "Criar professor")
    public ResponseEntity<?> criarProfessor (@RequestBody ProfessorDTO professorDTO) {
        ProfessorDTO professorCriadoDTO = professorService.criarProfessor(professorDTO);

        return new ResponseEntity<>(professorCriadoDTO, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    @RolesAllowed(Role.USER_ADMIN)
    @Operation(summary = "Atualizar professor")
    public ResponseEntity<?> atualizarProfessor (@PathVariable("id") Long id, @RequestBody ProfessorDTO professorDTO) {
        ProfessorDTO professorAtualizadoDTO = professorService.atualizarProfessor(id, professorDTO);

        return new ResponseEntity<>(professorAtualizadoDTO, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    @RolesAllowed(Role.USER_ADMIN)
    @Operation(summary = "Remover professor")
    public ResponseEntity<?> removerProfessor (@PathVariable("id") Long id) {
        MessageDTO messageDTO = professorService.removerProfessor(id);

        return new ResponseEntity<>(messageDTO, HttpStatus.OK);
    }

    @PatchMapping("/in/quota")
    @RolesAllowed(Role.USER_PROF)
    @Operation(summary = "Atualizar quota de professor")
    public ResponseEntity<?> atualizarQuotaProfessor (@RequestBody QuotaProfessorDTO quotaProfessorDTO) {
        Long id = autenticacaoService.getIdUsuarioAutenticado();
        ProfessorDTO professorQuotaAtualizadaDTO = professorService.atualizarQuotaProfessor(id, quotaProfessorDTO);

        return new ResponseEntity<>(professorQuotaAtualizadaDTO, HttpStatus.OK);
    }

    @PostMapping("/in/areasestudo")
    @RolesAllowed(Role.USER_PROF)
    @Operation(summary = "Selecionar áreas de estudo de professor")
    public ResponseEntity<?> selecionarAreasEstudoProfessor (@RequestBody List<AreaEstudoDTO> areasEstudoDTO) {
        Long id = autenticacaoService.getIdUsuarioAutenticado();
        Professor professor = professorService.getProfessor(id);

        List<AreaEstudoDTO> areasEstudoSelecionadasDTO = areaEstudoService.selecionarAreasEstudoUsuario(professor, areasEstudoDTO);

        return new ResponseEntity<>(areasEstudoSelecionadasDTO, HttpStatus.CREATED);
    }

    @PostMapping("/in/temastcc")
    @RolesAllowed(Role.USER_PROF)
    @Operation(summary = "Criar tema de TCC de professor")
    public ResponseEntity<?> criarTemaTccProfessor (@RequestBody TemaTccDTO temaTccDTO) {
        Long id = autenticacaoService.getIdUsuarioAutenticado();
        Professor professor = professorService.getProfessor(id);

        TemaTccDTO temaTccCriadoDTO = temaTccService.criarTemaTccUsuario(professor, temaTccDTO);
        TemaTcc temaTcc = temaTccService.getTemaTcc(temaTccCriadoDTO.getId());

        applicationEventPublisher.publishEvent(new TemaTccProfessorCriadoEvent(this, temaTcc));

        return new ResponseEntity<>(temaTccCriadoDTO, HttpStatus.CREATED);
    }

    @GetMapping("/in/temastcc")
    @RolesAllowed(Role.USER_PROF)
    @Operation(summary = "Listar temas de TCC de professor")
    public ResponseEntity<?> listarTemasTccProfessor () {
        Long id = autenticacaoService.getIdUsuarioAutenticado();
        Professor professor = professorService.getProfessor(id);

        List<TemaTccDTO> temasTccProfessorDTO = temaTccService.listarTemasTccUsuario(professor);

        return new ResponseEntity<>(temasTccProfessorDTO, HttpStatus.OK);
    }

    @GetMapping("/temastcc")
    @RolesAllowed(Role.USER_ALUNO)
    @Operation(summary = "Listar temas de TCC dos professores")
    public ResponseEntity<?> listarTemasTccProfessores () {
        List<Professor> professores = professorService.getProfessores();
        List<UsuarioTcc> usuariosTcc = Collections.unmodifiableList(professores);

        List<TemaTccUsuarioDTO> temasTccProfessoresDTO = temaTccService.listarTemasTccUsuarios(usuariosTcc);

        return new ResponseEntity<>(temasTccProfessoresDTO, HttpStatus.OK);
    }

    @GetMapping()
    @RolesAllowed(Role.USER_ALUNO)
    @Operation(summary = "Listar professores disponíveis para orientação de TCC")
    public ResponseEntity<?> listarProfessoresDisponiveisOrientacao () {
        Long id = autenticacaoService.getIdUsuarioAutenticado();
        Aluno aluno = alunoService.getAluno(id);
        List<UsuarioDTO> professoresDTO = professorService.listarProfessoresDisponiveisOrientacaoTcc(aluno.getAreasEstudo());

        return new ResponseEntity<>(professoresDTO, HttpStatus.OK);
    }
}
