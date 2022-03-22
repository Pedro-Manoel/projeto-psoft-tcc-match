package com.ufcg.psoft.tccMatch.controller;

import com.ufcg.psoft.tccMatch.dto.tcc.ProblemaOrientacaoTccDTO;
import com.ufcg.psoft.tccMatch.service.tcc.ProblemaOrientacaoTccService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/api/problemasorientacaotcc")
@Tag(name = "Problema Orientação TCC")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class ProblemaOrientacaoTccController {

    private final ProblemaOrientacaoTccService problemaOrientacaoTccService;

    @PostMapping("/{id}")
    @Operation(summary = "Reportar problema de orientação de TCC")
    public ResponseEntity<?> reportarProblemaTcc (@PathVariable("id") Long id, @RequestBody ProblemaOrientacaoTccDTO problemaOrientacaoTccDTO) {
        ProblemaOrientacaoTccDTO problemaOrientacaoTcc = problemaOrientacaoTccService.reportarProblemaOrientacaoTcc(id, problemaOrientacaoTccDTO);

        return new ResponseEntity<>(problemaOrientacaoTcc, HttpStatus.CREATED);
    }
}
