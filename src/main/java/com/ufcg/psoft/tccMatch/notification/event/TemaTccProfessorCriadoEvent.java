package com.ufcg.psoft.tccMatch.notification.event;

import com.ufcg.psoft.tccMatch.model.tcc.TemaTcc;
import lombok.*;
import org.springframework.context.ApplicationEvent;

@Getter
@Setter
public class TemaTccProfessorCriadoEvent extends ApplicationEvent {
    private TemaTcc temaTcc;

    public TemaTccProfessorCriadoEvent(Object source, TemaTcc temaTcc) {
        super(source);
        this.temaTcc = temaTcc;
    }
}
