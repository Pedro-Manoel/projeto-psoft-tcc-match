package com.ufcg.psoft.tccMatch.service;

import com.ufcg.psoft.tccMatch.dto.TemaTCCDTO;
import com.ufcg.psoft.tccMatch.model.TemaTCC;

public interface TemaTCCService {
    TemaTCC criarTemaTCC (Long id, TemaTCCDTO temaTCCDTO);
}
