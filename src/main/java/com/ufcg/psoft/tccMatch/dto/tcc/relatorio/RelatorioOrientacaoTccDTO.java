package com.ufcg.psoft.tccMatch.dto.tcc.relatorio;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RelatorioOrientacaoTccDTO {
    private String semestre;

    private Integer totalOrientacoesTcc;

    private RelatorioOrientacaoTccAreaEstudoDTO finalizadas;

    private RelatorioOrientacaoTccAreaEstudoDTO emCurso;
}
