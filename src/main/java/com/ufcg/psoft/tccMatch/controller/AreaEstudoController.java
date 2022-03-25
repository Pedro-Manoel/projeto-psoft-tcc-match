package com.ufcg.psoft.tccMatch.controller;

import com.ufcg.psoft.tccMatch.dto.AreaEstudoDTO;
import com.ufcg.psoft.tccMatch.security.util.Role;
import com.ufcg.psoft.tccMatch.service.AreaEstudoService;
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
@RequestMapping("/api/areasestudo")
@Tag(name = "Área Estudo")
@SecurityRequirement(name = "bearerAuth")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class AreaEstudoController {

    private final AreaEstudoService areaEstudoService;
    
    @PostMapping
    @RolesAllowed(Role.USER_ADMIN)
    @Operation(summary = "Criar área de estudo")
    public ResponseEntity<?> criarAreaEstudo (@RequestBody AreaEstudoDTO areaEstudoDTO) {
        AreaEstudoDTO areaEstudoCriadaDTO = areaEstudoService.criarAreaEstudo(areaEstudoDTO);

        return new ResponseEntity<>(areaEstudoCriadaDTO, HttpStatus.CREATED);
    }
}
