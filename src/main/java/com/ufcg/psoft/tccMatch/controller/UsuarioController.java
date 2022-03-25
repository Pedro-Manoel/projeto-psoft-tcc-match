package com.ufcg.psoft.tccMatch.controller;

import com.ufcg.psoft.tccMatch.model.usuario.Usuario;
import com.ufcg.psoft.tccMatch.notification.dto.EmailDTO;
import com.ufcg.psoft.tccMatch.notification.service.EmailService;
import com.ufcg.psoft.tccMatch.security.dto.LoginDTO;
import com.ufcg.psoft.tccMatch.security.service.AutenticacaoService;
import com.ufcg.psoft.tccMatch.security.dto.TokenDTO;
import com.ufcg.psoft.tccMatch.security.util.Role;
import com.ufcg.psoft.tccMatch.service.usuario.UsuarioService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/usuarios")
@Tag(name = "Usuário")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class UsuarioController {

    private final UsuarioService usuarioService;
    private final EmailService emailService;
    private final AutenticacaoService autenticacaoService;

    @PostMapping("/login")
    @Operation(summary = "Fazer login de usuário")
    public ResponseEntity<?> fazerLoginUsuario (@RequestBody LoginDTO loginDTO)  {
        TokenDTO tokenDTO = autenticacaoService.autenticar(loginDTO);

        return new ResponseEntity<>(tokenDTO, HttpStatus.CREATED);
    }

    @GetMapping("/in/emails")
    @RolesAllowed({Role.USER_ALUNO, Role.USER_PROF, Role.USER_ADMIN})
    @Operation(
            summary = "Consultar caixa de E-mail de usuário",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    public ResponseEntity<?> consultarCaixaEmailUsuario ()  {
        Long id = autenticacaoService.getIdUsuarioAutenticado();
        Usuario usuario = usuarioService.getUsuario(id);
        List<EmailDTO> emailsDTO = emailService.consultarCaixaEmail(usuario);

        return new ResponseEntity<>(emailsDTO, HttpStatus.CREATED);
    }
}
