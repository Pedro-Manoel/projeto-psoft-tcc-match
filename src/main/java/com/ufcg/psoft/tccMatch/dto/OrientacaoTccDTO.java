package com.ufcg.psoft.tccMatch.dto;

import io.swagger.v3.oas.annotations.Hidden;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrientacaoTccDTO extends ModelDTO {
    @Hidden
    private TccDTO tcc;

    private Long idSolicitacao;

    private String semestre;
}
