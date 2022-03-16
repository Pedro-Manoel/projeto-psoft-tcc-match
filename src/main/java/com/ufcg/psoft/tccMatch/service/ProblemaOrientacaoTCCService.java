package com.ufcg.psoft.tccMatch.service;

import com.ufcg.psoft.tccMatch.dto.ProblemaOrientacaoTCCDTO;
import com.ufcg.psoft.tccMatch.model.ProblemaOrientacaoTCC;

public interface ProblemaOrientacaoTCCService {
    ProblemaOrientacaoTCC reportarProblema (Long id, ProblemaOrientacaoTCCDTO problemaOrientacaoTCCDTO);
}
