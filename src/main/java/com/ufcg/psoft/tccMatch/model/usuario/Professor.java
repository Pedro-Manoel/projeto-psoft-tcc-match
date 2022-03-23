package com.ufcg.psoft.tccMatch.model.usuario;

import com.ufcg.psoft.tccMatch.error.exception.EntidadeNaoExisteException;
import com.ufcg.psoft.tccMatch.error.exception.SolicitacaoOrientacaoTccInvalidaProfessorException;
import com.ufcg.psoft.tccMatch.model.tcc.SolicitacaoOrientacaoTcc;
import com.ufcg.psoft.tccMatch.security.util.Role;
import lombok.*;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Transient;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Professor extends UsuarioTcc {
    
	private String laboratorios;
	
	private Integer quota;

	public void diminuirQuotaEmUm() {
		this.quota -= 1;
	}

	public boolean isDisponivelOrientacao() {
		return this.quota >= 1;
	}

	@OneToMany(cascade = CascadeType.ALL)
	private List<SolicitacaoOrientacaoTcc> solicitacoesOrientacaoTcc;

	public void adicionarSolicitacaoOrientacaoTcc(SolicitacaoOrientacaoTcc solicitacaoOrientacaoTcc) {
		this.solicitacoesOrientacaoTcc.add(solicitacaoOrientacaoTcc);
	}

	public boolean solicitacaoJaEstaEmAndamento(SolicitacaoOrientacaoTcc solicitacaoOrientacaoTcc) {
		boolean verificacao = false;

		for (SolicitacaoOrientacaoTcc solicitacaoOrientacaoTccProfessor : this.solicitacoesOrientacaoTcc) {
			if (
					solicitacaoOrientacaoTcc.equals(solicitacaoOrientacaoTccProfessor) &&
					solicitacaoOrientacaoTccProfessor.isRespondida() &&
					solicitacaoOrientacaoTccProfessor.isAceita()
			) {
				verificacao = !solicitacaoOrientacaoTccProfessor.isVinculadaComTcc();
			} else {
				verificacao = false;
			}
		}

		return verificacao;
	}

	public SolicitacaoOrientacaoTcc getSolicitacaoOrientacao(Long id) {
		return this.solicitacoesOrientacaoTcc
				.stream()
				.filter(solicitacaoOrientacaoTcc -> solicitacaoOrientacaoTcc.getId().equals(id))
				.findAny()
				.orElseThrow(() -> new SolicitacaoOrientacaoTccInvalidaProfessorException("id", id.toString()));
	}

	public String getAutoridade() { return Role.USER_PROF; }
}

