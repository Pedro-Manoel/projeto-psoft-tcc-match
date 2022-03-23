package com.ufcg.psoft.tccMatch.notification.controller;

import com.ufcg.psoft.tccMatch.model.AreaEstudo;
import com.ufcg.psoft.tccMatch.model.usuario.Aluno;
import com.ufcg.psoft.tccMatch.model.usuario.Coordenador;
import com.ufcg.psoft.tccMatch.notification.event.ManifestacaoOrientacaoTemaTccAlunoEvent;
import com.ufcg.psoft.tccMatch.notification.event.SolicitacaoOrientacaoTccAceitaEvent;
import com.ufcg.psoft.tccMatch.notification.event.SolicitacaoOrientacaoTccCriadaEvent;
import com.ufcg.psoft.tccMatch.notification.event.TemaTccProfessorCriadoEvent;
import com.ufcg.psoft.tccMatch.notification.service.EmailService;
import com.ufcg.psoft.tccMatch.service.usuario.AlunoService;
import com.ufcg.psoft.tccMatch.service.usuario.CoordenadorService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Component
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class AppEventController {

    private final EmailService emailService;
    private final AlunoService alunoService;
    private final CoordenadorService coordenadorService;

    @EventListener
    public void handleEvent(TemaTccProfessorCriadoEvent temaTccProfessorCriadoEvent) {
        Set<Aluno> alunos = new HashSet<>();

        for (AreaEstudo areaEstudo : temaTccProfessorCriadoEvent.getTemaTcc().getAreasEstudo()) {
            List<Aluno> alunosTemaTcc = alunoService.getAlunos(areaEstudo);
            alunos.addAll(alunosTemaTcc);
        }

        String mensagem = String.format(
                "Um novo tema de TCC, com uma área de estudo em comum com alguma das suas, " +
                "foi cadastrado por um professor no sistema. Título do tema de TCC: %s"
                , temaTccProfessorCriadoEvent.getTemaTcc().getTitulo()
        );

        for (Aluno aluno : alunos) {
            emailService.enviarEmail(aluno, mensagem);
        }
    }

    @EventListener
    public void handleEvent(ManifestacaoOrientacaoTemaTccAlunoEvent manifestacaoOrientacaoTemaTccAlunoEvent) {
        String mensagem = String.format(
                "Um professor manifestou interesse em orientar um tema de TCC cadastrado por você" +
                ". Id do professor: %s. Título do tema de TCC: %s"
                , manifestacaoOrientacaoTemaTccAlunoEvent.getProfessor().getId()
                , manifestacaoOrientacaoTemaTccAlunoEvent.getTemaTcc().getTitulo()
        );

        emailService.enviarEmail(manifestacaoOrientacaoTemaTccAlunoEvent.getAluno(), mensagem);
    }

    @EventListener
    public void handleEvent(SolicitacaoOrientacaoTccCriadaEvent solicitacaoOrientacaoTccCriadaEvent) {
        String mensagem = String.format(
                "Um aluno solicitou uma orientação de TCC em um tema de TCC cadastrado por você." +
                " Id da solicitação: %s. Título do tema de TCC: %s"
                , solicitacaoOrientacaoTccCriadaEvent.getSolicitacao().getId()
                , solicitacaoOrientacaoTccCriadaEvent.getSolicitacao().getTemaTcc().getTitulo()
        );

        emailService.enviarEmail(solicitacaoOrientacaoTccCriadaEvent.getProfessor(), mensagem);
    }

    @EventListener
    public void handleEvent(SolicitacaoOrientacaoTccAceitaEvent solicitacaoOrientacaoTccAceitaEvent) {
        Coordenador coordenador = coordenadorService.getCoordenador();

        String mensagem = String.format(
                "Um professor aceitou uma solicitação de orientação de TCC de um aluno." +
                " Id da solicitação: %s."
                , solicitacaoOrientacaoTccAceitaEvent.getSolicitacao().getId()
        );

        emailService.enviarEmail(coordenador, mensagem);
    }
}