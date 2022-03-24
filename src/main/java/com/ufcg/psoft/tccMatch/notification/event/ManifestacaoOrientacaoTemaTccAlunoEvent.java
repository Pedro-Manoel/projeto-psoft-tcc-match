package com.ufcg.psoft.tccMatch.notification.event;

import com.ufcg.psoft.tccMatch.model.tcc.TemaTcc;
import com.ufcg.psoft.tccMatch.model.usuario.Aluno;
import com.ufcg.psoft.tccMatch.model.usuario.Professor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.context.ApplicationEvent;

@Getter
@Setter
public class ManifestacaoOrientacaoTemaTccAlunoEvent extends ApplicationEvent {
    private Professor professor;
    private Aluno aluno;
    private TemaTcc temaTcc;

    public ManifestacaoOrientacaoTemaTccAlunoEvent(Object source, Professor professor, Aluno aluno, TemaTcc temaTcc) {
        super(source);
        this.professor = professor;
        this.aluno = aluno;
        this.temaTcc = temaTcc;
    }
}
