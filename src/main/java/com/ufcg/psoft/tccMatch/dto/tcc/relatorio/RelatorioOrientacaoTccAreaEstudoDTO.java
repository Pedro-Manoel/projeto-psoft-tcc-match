package com.ufcg.psoft.tccMatch.dto.tcc.relatorio;

import com.ufcg.psoft.tccMatch.dto.tcc.OrientacaoTccDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.Map;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RelatorioOrientacaoTccAreaEstudoDTO {
    private Integer totalOrientacoesTcc;

    private Map<String, Integer> totalOrientacoesTccAreaEstudo;

    private List<OrientacaoTccDTO> orientacoesTcc;
}
