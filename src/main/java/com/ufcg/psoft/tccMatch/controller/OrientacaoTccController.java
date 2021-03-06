package com.ufcg.psoft.tccMatch.controller;

import com.ufcg.psoft.tccMatch.dto.tcc.OrientacaoTccDTO;
import com.ufcg.psoft.tccMatch.dto.tcc.relatorio.RelatorioOrientacaoTccDTO;
import com.ufcg.psoft.tccMatch.security.service.AutenticacaoService;
import com.ufcg.psoft.tccMatch.security.util.Role;
import com.ufcg.psoft.tccMatch.service.tcc.OrientacaoTccService;
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
@RequestMapping("/api/orientacoestcc")
@Tag(name = "Orientação TCC")
@SecurityRequirement(name = "bearerAuth")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class OrientacaoTccController {

    private final OrientacaoTccService orientacaoTccService;
    private final AutenticacaoService autenticacaoService;

    @PostMapping()
    @RolesAllowed(Role.USER_ADMIN)
    @Operation(summary = "Criar orientação de TCC")
    public ResponseEntity<?> criarOrientacaoTcc (@RequestBody OrientacaoTccDTO orientacaoTccDTO) {
        OrientacaoTccDTO orientacaoTccCriadaDTO = orientacaoTccService.criarOrientacaoTcc(orientacaoTccDTO);

        return new ResponseEntity<>(orientacaoTccCriadaDTO, HttpStatus.CREATED);
    }

    @PostMapping("/{id}/finalizar")
    @RolesAllowed(Role.USER_ADMIN)
    @Operation(summary = "Finalizar orientação de TCC")
    public ResponseEntity<?> finalizarOrientacaoTcc (@PathVariable("id") Long id) {
        OrientacaoTccDTO orientacaoTccFinalizadaDTO = orientacaoTccService.finalizarOrientacaoTcc(id);

        return new ResponseEntity<>(orientacaoTccFinalizadaDTO, HttpStatus.CREATED);
    }

    @GetMapping("/professor/in")
    @RolesAllowed(Role.USER_PROF)
    @Operation(summary = "Listar orientações de TCC em curso do professor")
    public ResponseEntity<?> listarOrientacaoTccEmCursoProfessor () {
        Long id = autenticacaoService.getIdUsuarioAutenticado();
        List<OrientacaoTccDTO> orientacoesTccDTO =
                orientacaoTccService.listarOrientacoesTccEmCursoProfessor(id);

        return new ResponseEntity<>(orientacoesTccDTO, HttpStatus.CREATED);
    }

    @GetMapping()
    @RolesAllowed(Role.USER_ADMIN)
    @Operation(summary = "Listar orientações de TCC")
    public ResponseEntity<?> listarOrientacaoTccEmCursoPorSemestre (
            @RequestParam(defaultValue = "false") Boolean finalizada,
            @RequestParam(defaultValue = "2022") String semestre
    ) {
        List<OrientacaoTccDTO> orientacoesTccDTO =
                orientacaoTccService.listarOrientacoesTcc(finalizada, semestre);

        return new ResponseEntity<>(orientacoesTccDTO, HttpStatus.CREATED);
    }

    @GetMapping("/relatorio")
    @RolesAllowed(Role.USER_ADMIN)
    @Operation(summary = "Gerar relatório de orientações de TCC")
    public ResponseEntity<?> gerarRelatorioOrientacoesTcc (
            @RequestParam(defaultValue = "2022") String semestre
    ) {
        RelatorioOrientacaoTccDTO relatorioDTO = orientacaoTccService.gerarRelatorio(semestre);

        return new ResponseEntity<>(relatorioDTO, HttpStatus.OK);
    }
}
