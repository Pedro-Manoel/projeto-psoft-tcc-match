package com.ufcg.psoft.tccMatch.service.tcc;

import com.ufcg.psoft.tccMatch.dto.tcc.ProblemaOrientacaoTccDTO;
import com.ufcg.psoft.tccMatch.dto.tcc.relatorio.RelatorioProblemaOrientacaoTccDTO;

public interface ProblemaOrientacaoTccService {
    ProblemaOrientacaoTccDTO reportarProblemaOrientacaoTcc(Long idUsuario, ProblemaOrientacaoTccDTO problemaOrientacaoTccDTO);

    RelatorioProblemaOrientacaoTccDTO gerarRelatorio (String semestre);
}
