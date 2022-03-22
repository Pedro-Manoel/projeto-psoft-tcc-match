package com.ufcg.psoft.tccMatch.controller;

import com.ufcg.psoft.tccMatch.dto.tcc.RespostaSolicitacaoOrientacaoTccDTO;
import com.ufcg.psoft.tccMatch.dto.tcc.SolicitacaoOrientacaoTccDTO;
import com.ufcg.psoft.tccMatch.service.tcc.SolicitacaoOrientacaoTccService;
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
@RequestMapping("/api/solicitacoesorientacaotcc")
@Tag(name = "Solicitação Orientação TCC")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class SolicitacaoOrientacaoTccController {

    private final SolicitacaoOrientacaoTccService solicitacaoOrientacaoTccService;

    @PostMapping("/{idAluno}")
    @Operation(summary = "Solicitar Orientação de TCC a professor")
    public ResponseEntity<?> solicitarOrientacaoTcc (@PathVariable("idAluno") Long id, @RequestBody SolicitacaoOrientacaoTccDTO solicitacaoOrientacaoTccDTO) {
        SolicitacaoOrientacaoTccDTO solicitacaoOrientacaoTccCriadaDTO = solicitacaoOrientacaoTccService.solicitarOrientacaoTcc(id, solicitacaoOrientacaoTccDTO);

        return new ResponseEntity<>(solicitacaoOrientacaoTccCriadaDTO, HttpStatus.CREATED);
    }

    @GetMapping("/professor/{id}")
    @Operation(summary = "Listar solicitações de orientação de TCC para professor")
    public ResponseEntity<?> listarSolicitacoesOrientacaoTcc (@PathVariable("id") Long id) {
        List<SolicitacaoOrientacaoTccDTO> solicitacoesOrientacaoTccDTO = solicitacaoOrientacaoTccService.listarSolicitacoesOrientacoesTccProfessor(id);

        return new ResponseEntity<>(solicitacoesOrientacaoTccDTO, HttpStatus.OK);
    }

    @PostMapping("/{idSolicitacao}/professor/{id}")
    @Operation(summary = "Responder solicitação de orientação de TCC para professor")
    public ResponseEntity<?> responderSolicitacaoOrientacaoTcc (
            @PathVariable("id") Long id,
            @PathVariable("idSolicitacao") Long idSolicitacao,
            @RequestBody RespostaSolicitacaoOrientacaoTccDTO respostaSolicitacaoOrientacaoTccDTO
    ) {
        SolicitacaoOrientacaoTccDTO solicitacaoOrientacaoTccDTO = solicitacaoOrientacaoTccService.responderSolicitacaoOrientacaoTccProfessor(id, idSolicitacao, respostaSolicitacaoOrientacaoTccDTO);

        return new ResponseEntity<>(solicitacaoOrientacaoTccDTO, HttpStatus.OK);
    }
}
