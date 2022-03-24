package com.ufcg.psoft.tccMatch.controller;

import com.ufcg.psoft.tccMatch.dto.tcc.solicitacao.RespostaSolicitacaoOrientacaoTccDTO;
import com.ufcg.psoft.tccMatch.dto.tcc.solicitacao.SolicitacaoOrientacaoTccDTO;
import com.ufcg.psoft.tccMatch.security.service.AutenticacaoService;
import com.ufcg.psoft.tccMatch.security.util.Role;
import com.ufcg.psoft.tccMatch.service.tcc.SolicitacaoOrientacaoTccService;
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
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/solicitacoesorientacaotcc")
@Tag(name = "Solicitação Orientação TCC")
@SecurityRequirement(name = "bearerAuth")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class SolicitacaoOrientacaoTccController {

    private final SolicitacaoOrientacaoTccService solicitacaoOrientacaoTccService;
    private final AutenticacaoService autenticacaoService;

    private final ApplicationEventPublisher applicationEventPublisher;

    @PostMapping()
    @RolesAllowed(Role.USER_ALUNO)
    @Operation(summary = "Solicitar Orientação de TCC a professor")
    public ResponseEntity<?> solicitarOrientacaoTcc (@RequestBody SolicitacaoOrientacaoTccDTO solicitacaoOrientacaoTccDTO) {
        Long id = autenticacaoService.getIdUsuarioAutenticado();
        SolicitacaoOrientacaoTccDTO solicitacaoOrientacaoTccCriadaDTO = solicitacaoOrientacaoTccService.solicitarOrientacaoTcc(id, solicitacaoOrientacaoTccDTO);

        return new ResponseEntity<>(solicitacaoOrientacaoTccCriadaDTO, HttpStatus.CREATED);
    }

    @GetMapping()
    @RolesAllowed(Role.USER_PROF)
    @Operation(summary = "Listar solicitações de orientação de TCC para professor")
    public ResponseEntity<?> listarSolicitacoesOrientacaoTcc () {
        Long id = autenticacaoService.getIdUsuarioAutenticado();
        List<SolicitacaoOrientacaoTccDTO> solicitacoesOrientacaoTccDTO = solicitacaoOrientacaoTccService.listarSolicitacoesOrientacoesTccProfessor(id);

        return new ResponseEntity<>(solicitacoesOrientacaoTccDTO, HttpStatus.OK);
    }

    @PostMapping("/{id}/responder")
    @RolesAllowed(Role.USER_PROF)
    @Operation(summary = "Responder solicitação de orientação de TCC para professor")
    public ResponseEntity<?> responderSolicitacaoOrientacaoTcc (
            @PathVariable("id") Long idSolicitacao,
            @RequestBody RespostaSolicitacaoOrientacaoTccDTO respostaSolicitacaoOrientacaoTccDTO
    ) {
        Long id = autenticacaoService.getIdUsuarioAutenticado();
        SolicitacaoOrientacaoTccDTO solicitacaoOrientacaoTccDTO = solicitacaoOrientacaoTccService.responderSolicitacaoOrientacaoTccProfessor(id, idSolicitacao, respostaSolicitacaoOrientacaoTccDTO);

        return new ResponseEntity<>(solicitacaoOrientacaoTccDTO, HttpStatus.OK);
    }
}
