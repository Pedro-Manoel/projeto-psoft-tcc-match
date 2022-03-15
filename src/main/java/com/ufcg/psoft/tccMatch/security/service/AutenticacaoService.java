package com.ufcg.psoft.tccMatch.security.service;

import com.ufcg.psoft.tccMatch.security.dto.LoginDTO;
import com.ufcg.psoft.tccMatch.security.dto.TokenDTO;

public interface AutenticacaoService {
    TokenDTO autenticar(LoginDTO loginDTO);

    Long getIdUsuarioAutenticado();
}
