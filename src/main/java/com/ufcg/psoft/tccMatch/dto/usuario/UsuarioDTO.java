package com.ufcg.psoft.tccMatch.dto.usuario;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioDTO {
    @ApiModelProperty(hidden = true)
    private Long id;

    private String nome;

    private String email;

    private String senha;
}
