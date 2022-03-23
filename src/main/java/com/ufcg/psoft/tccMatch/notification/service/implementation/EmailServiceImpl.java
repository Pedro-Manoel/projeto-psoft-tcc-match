package com.ufcg.psoft.tccMatch.notification.service.implementation;

import com.ufcg.psoft.tccMatch.model.usuario.Usuario;
import com.ufcg.psoft.tccMatch.notification.dto.EmailDTO;
import com.ufcg.psoft.tccMatch.notification.mapper.EmailMapper;
import com.ufcg.psoft.tccMatch.notification.model.Email;
import com.ufcg.psoft.tccMatch.notification.service.EmailService;
import com.ufcg.psoft.tccMatch.service.usuario.UsuarioService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class EmailServiceImpl implements EmailService {

    private final UsuarioService usuarioService;

    private final EmailMapper emailMapper;

    public void enviarEmail(Usuario usuario, String mensagem) {
        Email email = new Email();
        email.setMensagem(mensagem);
        email.setData(new Date());

        usuario.getCaixaEmail().adicionarEmail(email);

        usuarioService.salvarUsuario(usuario);
    }

    public List<EmailDTO> consultarCaixaEmail(Usuario usuario) {
        List<Email> emails =
                usuario.getCaixaEmail().getEmails()
                .stream()
                .sorted(Comparator.comparing(Email::getData).reversed())
                .collect(Collectors.toList());

        return emailMapper.toDTOs(emails);
    }
}
