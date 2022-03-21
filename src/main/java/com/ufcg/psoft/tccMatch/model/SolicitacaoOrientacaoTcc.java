package com.ufcg.psoft.tccMatch.model;

import com.ufcg.psoft.tccMatch.model.usuario.Aluno;
import com.ufcg.psoft.tccMatch.model.usuario.Professor;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SolicitacaoOrientacaoTcc extends Model {
	@ManyToOne
    private Aluno aluno;

    @OneToOne
	private TemaTcc temaTcc;

    @OneToOne
    private RespostaSolicitacaoOrientacaoTcc resposta;

    public boolean emAndamento () { return this.resposta != null; }
 }
