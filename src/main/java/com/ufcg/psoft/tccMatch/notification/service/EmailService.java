package com.ufcg.psoft.tccMatch.notification.service;

import com.ufcg.psoft.tccMatch.model.usuario.Usuario;
import com.ufcg.psoft.tccMatch.notification.dto.EmailDTO;

import java.util.List;

public interface EmailService {
    void enviarEmail(Usuario usuario, String mensagem);

    List<EmailDTO> consultarCaixaEmail(Usuario usuario);
}
