package com.ufcg.psoft.tccMatch.dto.usuario;

import com.ufcg.psoft.tccMatch.dto.ModelDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioDTO extends ModelDTO {
    private String nome;

    private String email;

    private String senha;
}
