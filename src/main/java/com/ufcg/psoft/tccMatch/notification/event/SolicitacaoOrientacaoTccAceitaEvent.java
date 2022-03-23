package com.ufcg.psoft.tccMatch.notification.event;

import com.ufcg.psoft.tccMatch.model.tcc.SolicitacaoOrientacaoTcc;
import com.ufcg.psoft.tccMatch.model.usuario.Coordenador;
import lombok.Getter;
import lombok.Setter;
import org.springframework.context.ApplicationEvent;

@Getter
@Setter
public class SolicitacaoOrientacaoTccAceitaEvent extends ApplicationEvent {
    SolicitacaoOrientacaoTcc solicitacao;

    public SolicitacaoOrientacaoTccAceitaEvent(Object source, SolicitacaoOrientacaoTcc solicitacao) {
        super(source);
        this.solicitacao = solicitacao;
    }
}
