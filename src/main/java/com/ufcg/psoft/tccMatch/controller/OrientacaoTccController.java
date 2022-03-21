package com.ufcg.psoft.tccMatch.controller;

import com.ufcg.psoft.tccMatch.dto.tcc.OrientacaoTccDTO;
import com.ufcg.psoft.tccMatch.service.tcc.OrientacaoTccService;
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
@RequestMapping("/api/orientacoestcc")
@Tag(name = "Orientação TCC")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class OrientacaoTccController {

    private final OrientacaoTccService orientacaoTccService;

    @PostMapping("/{id}")
    @Operation(summary = "Criar Orientação de TCC")
    public ResponseEntity<?> criarOrientacaoTcc (@PathVariable("id") Long id, @RequestBody OrientacaoTccDTO orientacaoTccDTO) {
        OrientacaoTccDTO orientacaoTccCriadaDTO = orientacaoTccService.criarOrientacaoTcc(id, orientacaoTccDTO);

        return new ResponseEntity<>(orientacaoTccCriadaDTO, HttpStatus.CREATED);
    }

    @PostMapping("/{id}/finalizar")
    @Operation(summary = "Finalizar Orientação de TCC")
    public ResponseEntity<?> finalizarOrientacaoTcc (@PathVariable("id") Long id) {
        OrientacaoTccDTO orientacaoTccFinalizadaDTO = orientacaoTccService.finalizarOrientacaoTcc(id);

        return new ResponseEntity<>(orientacaoTccFinalizadaDTO, HttpStatus.CREATED);
    }

    @GetMapping("/professor/{id}")
    @Operation(summary = "Listar Orientações de TCC em curso do professor")
    public ResponseEntity<?> listarOrientacaoTccEmCursoProfessor (@PathVariable("id") Long id) {
        List<OrientacaoTccDTO> orinetacoesTccDTO =  orientacaoTccService.listarOrientacoesTccEmCursoProfessor(id);

        return new ResponseEntity<>(orinetacoesTccDTO, HttpStatus.CREATED);
    }

    @GetMapping()
    @Operation(summary = "Listar Orientações de TCC")
    public ResponseEntity<?> listarOrientacaoTccEmCursoPorSemestre (
            @RequestParam(defaultValue = "false") Boolean finalizada,
            @RequestParam(defaultValue = "2022") String semestre
    ) {
        List<OrientacaoTccDTO> orinetacoesTccDTO =  orientacaoTccService.listarOrientacoesTcc(finalizada, semestre);

        return new ResponseEntity<>(orinetacoesTccDTO, HttpStatus.CREATED);
    }
}
