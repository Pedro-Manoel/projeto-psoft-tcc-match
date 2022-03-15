package com.ufcg.psoft.tccMatch.controller;

import com.ufcg.psoft.tccMatch.security.dto.LoginDTO;
import com.ufcg.psoft.tccMatch.security.service.AutenticacaoService;
import com.ufcg.psoft.tccMatch.security.dto.TokenDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/api/usuarios")
@Tag(name = "Usuário")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class UsuarioController {

    private AutenticacaoService autenticacaoService;

    @PostMapping("/login")
    @Operation(summary = "Fazer login de usuário")
    public ResponseEntity<?> login (@RequestBody LoginDTO loginDTO)  {
        TokenDTO tokenDTO = autenticacaoService.autenticar(loginDTO);

        return new ResponseEntity<>(tokenDTO, HttpStatus.CREATED);
    }
}
