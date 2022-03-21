package com.ufcg.psoft.tccMatch.notification.event;

import org.springframework.context.ApplicationEvent;

public class SolicitacaoOrientacaoTccCriadaEvent extends ApplicationEvent {
    public SolicitacaoOrientacaoTccCriadaEvent(Object source) {
        super(source);
    }
}
