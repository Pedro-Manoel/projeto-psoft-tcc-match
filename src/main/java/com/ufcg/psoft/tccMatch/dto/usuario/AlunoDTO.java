package com.ufcg.psoft.tccMatch.dto.usuario;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AlunoDTO extends UsuarioDTO {
    private String matricula;

    private String periodoPrevistoConclusao;
}
