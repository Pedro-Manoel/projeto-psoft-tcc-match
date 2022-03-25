package com.ufcg.psoft.tccMatch.controller;

import com.ufcg.psoft.tccMatch.dto.tcc.ProblemaOrientacaoTccDTO;
import com.ufcg.psoft.tccMatch.dto.tcc.relatorio.RelatorioProblemaOrientacaoTccDTO;
import com.ufcg.psoft.tccMatch.security.service.AutenticacaoService;
import com.ufcg.psoft.tccMatch.security.util.Role;
import com.ufcg.psoft.tccMatch.service.tcc.ProblemaOrientacaoTccService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;

@RestController
@CrossOrigin
@RequestMapping("/api/problemasorientacaotcc")
@Tag(name = "Problema Orientação TCC")
@SecurityRequirement(name = "bearerAuth")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class ProblemaOrientacaoTccController {

    private final ProblemaOrientacaoTccService problemaOrientacaoTccService;
    private final AutenticacaoService autenticacaoService;

    @PostMapping()
    @RolesAllowed({Role.USER_ALUNO, Role.USER_PROF})
    @Operation(summary = "Reportar problema de orientação de TCC")
    public ResponseEntity<?> reportarProblemaOrientacaoTcc (
            @RequestBody ProblemaOrientacaoTccDTO problemaOrientacaoTccDTO
    ) {
        Long id = autenticacaoService.getIdUsuarioAutenticado();
        ProblemaOrientacaoTccDTO problemaOrientacaoTcc =
                problemaOrientacaoTccService.reportarProblemaOrientacaoTcc(id, problemaOrientacaoTccDTO);

        return new ResponseEntity<>(problemaOrientacaoTcc, HttpStatus.CREATED);
    }

    @GetMapping("/relatorio")
    @RolesAllowed(Role.USER_ADMIN)
    @Operation(summary = "Gerar relatório dos problemas de orientação de TCC")
    public ResponseEntity<?> gerarRelatorioProblemasOrientacaoTcc (
            @RequestParam(defaultValue = "2022") String semestre
    ) {
        RelatorioProblemaOrientacaoTccDTO relatorioDTO = problemaOrientacaoTccService.gerarRelatorio(semestre);

        return new ResponseEntity<>(relatorioDTO, HttpStatus.CREATED);
    }
}
