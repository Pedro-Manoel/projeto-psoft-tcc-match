package com.ufcg.psoft.tccMatch.service.tcc;

import com.ufcg.psoft.tccMatch.dto.tcc.ProblemaOrientacaoTccDTO;

public interface ProblemaOrientacaoTccService {
    ProblemaOrientacaoTccDTO reportarProblemaOrientacaoTcc(Long idUsuario, ProblemaOrientacaoTccDTO problemaOrientacaoTccDTO);
}
