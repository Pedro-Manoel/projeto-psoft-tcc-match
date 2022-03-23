package com.ufcg.psoft.tccMatch.notification.event;

import com.ufcg.psoft.tccMatch.model.tcc.SolicitacaoOrientacaoTcc;
import com.ufcg.psoft.tccMatch.model.usuario.Professor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.context.ApplicationEvent;

@Getter
@Setter
public class SolicitacaoOrientacaoTccCriadaEvent extends ApplicationEvent {
    private Professor professor;
    private SolicitacaoOrientacaoTcc solicitacao;

    public SolicitacaoOrientacaoTccCriadaEvent(Object source, Professor professor, SolicitacaoOrientacaoTcc solicitacao) {
        super(source);
        this.professor = professor;
        this.solicitacao = solicitacao;
    }
}
