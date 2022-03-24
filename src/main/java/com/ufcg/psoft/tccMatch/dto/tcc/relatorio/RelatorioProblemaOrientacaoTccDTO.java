package com.ufcg.psoft.tccMatch.dto.tcc.relatorio;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RelatorioProblemaOrientacaoTccDTO {
    private String semestre;

    private Integer totalProblemas;

    private RelatorioProblemaOrientacaoTccUsuarioDTO alunos;

    private RelatorioProblemaOrientacaoTccUsuarioDTO professores;
}
