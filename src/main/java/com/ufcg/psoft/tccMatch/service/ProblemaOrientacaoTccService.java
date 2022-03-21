package com.ufcg.psoft.tccMatch.service;

import com.ufcg.psoft.tccMatch.dto.ProblemaOrientacaoTccDTO;
import com.ufcg.psoft.tccMatch.model.ProblemaOrientacaoTcc;

public interface ProblemaOrientacaoTccService {
    ProblemaOrientacaoTcc reportarProblema (Long id, ProblemaOrientacaoTccDTO problemaOrientacaoTccDTO);
}
