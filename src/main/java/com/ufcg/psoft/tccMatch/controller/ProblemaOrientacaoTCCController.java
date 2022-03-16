package com.ufcg.psoft.tccMatch.controller;

import com.ufcg.psoft.tccMatch.dto.ProblemaOrientacaoTCCDTO;
import com.ufcg.psoft.tccMatch.dto.TemaTCCDTO;
import com.ufcg.psoft.tccMatch.model.ProblemaOrientacaoTCC;
import com.ufcg.psoft.tccMatch.model.TemaTCC;
import com.ufcg.psoft.tccMatch.service.ProblemaOrientacaoTCCService;
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
public class ProblemaOrientacaoTCCController {
    private final ProblemaOrientacaoTCCService problemaOrientacaoTCCService;

    @PostMapping("/{id}")
    @Operation(summary = "Reportar Problema de Orientação TCC")
    public ResponseEntity<?> reportarProblemaTCC (@PathVariable("id") Long id, @RequestBody ProblemaOrientacaoTCCDTO problemaOrientacaoTCCDTO) {
        ProblemaOrientacaoTCC problemaOrientacaoTCC = problemaOrientacaoTCCService.reportarProblema( id, problemaOrientacaoTCCDTO);

        return new ResponseEntity<>(problemaOrientacaoTCC, HttpStatus.CREATED);
    }
}
