package com.ufcg.psoft.tccMatch.notification.controller;

import com.ufcg.psoft.tccMatch.model.AreaEstudo;
import com.ufcg.psoft.tccMatch.model.usuario.Aluno;
import com.ufcg.psoft.tccMatch.notification.event.ManifestacaoOrientacaoTemaTccAlunoEvent;
import com.ufcg.psoft.tccMatch.notification.event.SolicitacaoOrientacaoTccCriadaEvent;
import com.ufcg.psoft.tccMatch.notification.event.TemaTccProfessorCriadoEvent;
import com.ufcg.psoft.tccMatch.notification.model.Email;
import com.ufcg.psoft.tccMatch.notification.service.EmailService;
import com.ufcg.psoft.tccMatch.service.usuario.AlunoService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Component
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class AppEventController {

    private final EmailService emailService;
    private final AlunoService alunoService;

    @EventListener
    public void handleEvent(TemaTccProfessorCriadoEvent temaTccProfessorCriadoEvent) {
        Set<Aluno> alunos = new HashSet<>();

        for (AreaEstudo areaEstudo : temaTccProfessorCriadoEvent.getTemaTcc().getAreasEstudo()) {
            List<Aluno> alunosTemaTcc = alunoService.getAlunos(areaEstudo);
            alunos.addAll(alunosTemaTcc);
        }

        for (Aluno aluno : alunos) {
            Email email = new Email();
            email.setMensagem(
                    String.format(
                            "Um novo tema de TCC, com uma área de estudo em comum com alguma das suas, " +
                            "acaba de ser cadastrado por um professor no sistema. Título do tema de TCC: %s"
                    , temaTccProfessorCriadoEvent.getTemaTcc().getTitulo())
            );
            email.setData(new Date());
            emailService.enviarEmail(aluno, email);
        }
    }

    @EventListener
    public void handleEvent(ManifestacaoOrientacaoTemaTccAlunoEvent manifestacaoOrientacaoTemaTccAlunoEvent) {
        Email email = new Email();
        email.setMensagem(
                String.format(
                        "Um professor acaba de manifestar interesse em orientar um tema de TCC cadastrado por você" +
                        ". Id do professor: %s. Título do tema de TCC: %s",
                        manifestacaoOrientacaoTemaTccAlunoEvent.getProfessor().getId(),
                        manifestacaoOrientacaoTemaTccAlunoEvent.getTemaTcc().getTitulo()
                )
        );
        email.setData(new Date());
        emailService.enviarEmail(manifestacaoOrientacaoTemaTccAlunoEvent.getAluno(), email);
    }

    @EventListener
    public void handleEvent(SolicitacaoOrientacaoTccCriadaEvent solicitacaoOrientacaoTccCriadaEvent) {
        Email email = new Email();
        email.setMensagem(
                String.format()
        );
        email.setData(new Date());
        emailService.enviarEmail(, email);
    }
}