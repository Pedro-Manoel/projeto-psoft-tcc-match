package com.ufcg.psoft.tccMatch.controller;

import com.ufcg.psoft.tccMatch.dto.AreaEstudoDTO;
import com.ufcg.psoft.tccMatch.dto.tcc.tema.TemaTccDTO;
import com.ufcg.psoft.tccMatch.dto.tcc.tema.TemaTccUsuarioDTO;
import com.ufcg.psoft.tccMatch.dto.usuario.AlunoDTO;
import com.ufcg.psoft.tccMatch.dto.message.MessageDTO;
import com.ufcg.psoft.tccMatch.model.tcc.TemaTcc;
import com.ufcg.psoft.tccMatch.model.usuario.Aluno;
import com.ufcg.psoft.tccMatch.model.usuario.Professor;
import com.ufcg.psoft.tccMatch.model.usuario.UsuarioTcc;
import com.ufcg.psoft.tccMatch.notification.event.ManifestacaoOrientacaoTemaTccAlunoEvent;
import com.ufcg.psoft.tccMatch.security.service.AutenticacaoService;
import com.ufcg.psoft.tccMatch.security.util.Role;
import com.ufcg.psoft.tccMatch.service.usuario.AlunoService;
import com.ufcg.psoft.tccMatch.service.AreaEstudoService;
import com.ufcg.psoft.tccMatch.service.tcc.TemaTccService;
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
@RequestMapping("/api/alunos")
@Tag(name = "Aluno")
@SecurityRequirement(name = "bearerAuth")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class AlunoController {

    private final AlunoService alunoService;
    private final ProfessorService professorService;
    private final AreaEstudoService areaEstudoService;
    private final TemaTccService temaTccService;
    private final AutenticacaoService autenticacaoService;

    private final ApplicationEventPublisher applicationEventPublisher;

    @PostMapping
    @RolesAllowed(Role.USER_ADMIN)
    @Operation(summary = "Criar aluno")
    public ResponseEntity<?> criarAluno (@RequestBody AlunoDTO alunoDTO) {
        AlunoDTO alunoCriadoDTO = alunoService.criarAluno(alunoDTO);

        return new ResponseEntity<>(alunoCriadoDTO, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    @RolesAllowed(Role.USER_ADMIN)
    @Operation(summary = "Atualizar aluno")
    public ResponseEntity<?> atualizarAluno (@PathVariable("id") Long id, @RequestBody AlunoDTO alunoDTO) {
        AlunoDTO alunoAtualizadoDTO = alunoService.atualizarAluno(id, alunoDTO);

        return new ResponseEntity<>(alunoAtualizadoDTO, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    @RolesAllowed(Role.USER_ADMIN)
    @Operation(summary = "Remover aluno")
    public ResponseEntity<?> removerAluno (@PathVariable("id") Long id) {
        MessageDTO messageDTO = alunoService.removerAluno(id);

        return new ResponseEntity<>(messageDTO, HttpStatus.OK);
    }

    @PostMapping("/in/areasestudo")
    @RolesAllowed(Role.USER_ALUNO)
    @Operation(summary = "Selecionar áreas de estudo de aluno")
    public ResponseEntity<?> selecionarAreasEstudoAluno (@RequestBody List<AreaEstudoDTO> areasEstudoDTO) {
        Long id = autenticacaoService.getIdUsuarioAutenticado();
        Aluno aluno = alunoService.getAluno(id);

        List<AreaEstudoDTO> areasEstudoSelecionadasDTO = areaEstudoService.selecionarAreasEstudoUsuario(aluno, areasEstudoDTO);

        return new ResponseEntity<>(areasEstudoSelecionadasDTO, HttpStatus.CREATED);
    }

    @PostMapping("/in/temastcc")
    @RolesAllowed(Role.USER_ALUNO)
    @Operation(summary = "Criar tema de TCC de aluno")
    public ResponseEntity<?> criarTemaTccAluno (@RequestBody TemaTccDTO temaTccDTO) {
        Long id = autenticacaoService.getIdUsuarioAutenticado();
        Aluno aluno = alunoService.getAluno(id);

        TemaTccDTO temaTccCriadoDTO = temaTccService.criarTemaTccUsuario(aluno, temaTccDTO);

        return new ResponseEntity<>(temaTccCriadoDTO, HttpStatus.CREATED);
    }

    @GetMapping("/temastcc")
    @RolesAllowed(Role.USER_PROF)
    @Operation(summary = "Listar temas de TCC dos alunos")
    public ResponseEntity<?> listarTemasTccAlunos () {
        List<Aluno> alunos = alunoService.getAlunos();
        List<UsuarioTcc> usuariosTcc = Collections.unmodifiableList(alunos);

        List<TemaTccUsuarioDTO> temasTccAlunosDTO = temaTccService.listarTemasTccUsuarios(usuariosTcc);

        return new ResponseEntity<>(temasTccAlunosDTO, HttpStatus.OK);
    }

    @PostMapping("/{id}/temastcc/{idTemaTcc}/manifestar")
    @RolesAllowed(Role.USER_PROF)
    @Operation(summary = "Manifestar interesse em orientar um tema de TCC de aluno")
    public ResponseEntity<?> manifestarInteresseOrientarTemaTCCAluno (@PathVariable("id") Long idAluno, @PathVariable("idTemaTcc") Long idTemaTcc) {
        Long id = autenticacaoService.getIdUsuarioAutenticado();
        Professor professor = professorService.getProfessor(id);
        Aluno aluno = alunoService.getAluno(idAluno);
        TemaTcc temaTcc = aluno.getTemaTcc(idTemaTcc);

        applicationEventPublisher.publishEvent(new ManifestacaoOrientacaoTemaTccAlunoEvent(this, professor, aluno, temaTcc));

        MessageDTO messageDTO = new MessageDTO("Manifestação de interesse notificada com sucesso para o aluno solicitado");

        return new ResponseEntity<>(messageDTO, HttpStatus.OK);
    }
}
