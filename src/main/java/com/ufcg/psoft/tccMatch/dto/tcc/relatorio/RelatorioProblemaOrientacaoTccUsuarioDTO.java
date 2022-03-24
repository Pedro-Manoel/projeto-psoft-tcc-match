package com.ufcg.psoft.tccMatch.dto.tcc.relatorio;

import com.ufcg.psoft.tccMatch.dto.tcc.ProblemaOrientacaoTccDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RelatorioProblemaOrientacaoTccUsuarioDTO {
    private Integer totalProblemas;

    private List<ProblemaOrientacaoTccDTO> problemas;
}
