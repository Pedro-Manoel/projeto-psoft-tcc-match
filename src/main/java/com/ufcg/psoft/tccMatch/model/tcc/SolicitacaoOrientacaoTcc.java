package com.ufcg.psoft.tccMatch.model.tcc;

import com.ufcg.psoft.tccMatch.model.Model;
import com.ufcg.psoft.tccMatch.model.usuario.Aluno;
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

    public boolean isRespondida () { return this.resposta != null; }

    public boolean isAceita () {
        if (this.resposta == null) {
            return false;
        } else {
            return resposta.isAceita();
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SolicitacaoOrientacaoTcc that = (SolicitacaoOrientacaoTcc) o;

        if (!aluno.equals(that.aluno)) return false;
        return temaTcc.equals(that.temaTcc);
    }

    @Override
    public int hashCode() {
        int result = aluno.hashCode();
        result = 31 * result + temaTcc.hashCode();
        return result;
    }
}
