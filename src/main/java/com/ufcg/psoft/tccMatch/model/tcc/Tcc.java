package com.ufcg.psoft.tccMatch.model.tcc;

import com.ufcg.psoft.tccMatch.model.Model;
import com.ufcg.psoft.tccMatch.model.usuario.Aluno;
import com.ufcg.psoft.tccMatch.model.usuario.Professor;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Tcc extends Model {
    @OneToOne
    private Aluno aluno;

    @OneToOne
    private Professor professor;

    @OneToOne
    private TemaTcc tema;
}
