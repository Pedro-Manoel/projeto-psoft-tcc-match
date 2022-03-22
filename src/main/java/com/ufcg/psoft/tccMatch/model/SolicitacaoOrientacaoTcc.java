package com.ufcg.psoft.tccMatch.model;

import com.ufcg.psoft.tccMatch.model.usuario.Aluno;
import com.ufcg.psoft.tccMatch.model.usuario.Professor;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

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

    @OneToOne(cascade = CascadeType.ALL)
    private RespostaSolicitacaoOrientacaoTcc resposta;

    private boolean vinculadaComTcc;

    public boolean isAceita () {
        if (this.resposta == null) {
            return false;
        } else {
            return resposta.isAceita();
        }

        // return !emAndamento() && resposta.isAceita();
    }
 }
