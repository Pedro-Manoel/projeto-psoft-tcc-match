package com.ufcg.psoft.tccMatch.controller;

import com.ufcg.psoft.tccMatch.dto.AreaEstudoDTO;
import com.ufcg.psoft.tccMatch.model.AreaEstudo;
import com.ufcg.psoft.tccMatch.model.usuario.Aluno;
import com.ufcg.psoft.tccMatch.service.AreaEstudoService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/areasestudo")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class AreaEstudoController {
    private final AreaEstudoService areaEstudoService;
    
    @PostMapping
    public ResponseEntity<?> criarAreaEstudo (@RequestBody AreaEstudoDTO areaEstudoDTO) {
        AreaEstudo areaEstudo = areaEstudoService.criarAreaEstudo(areaEstudoDTO);

        return new ResponseEntity<>(areaEstudo, HttpStatus.CREATED);
    }

    
    
    
}
