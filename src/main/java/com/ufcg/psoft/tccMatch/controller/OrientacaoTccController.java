package com.ufcg.psoft.tccMatch.controller;

import com.ufcg.psoft.tccMatch.dto.MessageDTO;
import com.ufcg.psoft.tccMatch.dto.SolicitacaoOrientacaoTccDTO;
import com.ufcg.psoft.tccMatch.model.ProblemaOrientacaoTcc;
import com.ufcg.psoft.tccMatch.model.usuario.Aluno;
import com.ufcg.psoft.tccMatch.service.AlunoService;
import com.ufcg.psoft.tccMatch.service.implementation.TccServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/api/orientacoestcc")
@Tag(name = "Orientação TCC")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class OrientacaoTccController {

    private TccServiceImpl tccService;
    private AlunoService alunoService;

    @PostMapping("/{id}")
    @Operation(summary = "Solicitar Orientação de TCC a professor")
    public ResponseEntity<?> solicitarOrientacaoTcc (@PathVariable("id") Long id, @RequestBody SolicitacaoOrientacaoTccDTO solicitacaoOrientacaoTccDTO) {
        Aluno aluno = alunoService.getAluno(id);
        MessageDTO messageDTO = tccService.solicitarOrientacao(aluno, solicitacaoOrientacaoTccDTO);

        return new ResponseEntity<>(messageDTO, HttpStatus.CREATED);
    }
}
