package com.ufcg.psoft.tccMatch.dto.tcc;

import com.ufcg.psoft.tccMatch.dto.ModelDTO;
import com.ufcg.psoft.tccMatch.dto.usuario.UsuarioDTO;
import io.swagger.v3.oas.annotations.Hidden;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProblemaOrientacaoTccDTO extends ModelDTO {
    @Hidden
    private UsuarioDTO usuario;

    private Long idOrientacaoTcc;

    private String problema;
}
