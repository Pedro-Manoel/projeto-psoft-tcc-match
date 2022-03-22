package com.ufcg.psoft.tccMatch.model.usuario;

import com.ufcg.psoft.tccMatch.exception.EntidadeNaoExisteException;
import com.ufcg.psoft.tccMatch.model.SolicitacaoOrientacaoTcc;
import com.ufcg.psoft.tccMatch.model.TemaTcc;
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
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Professor extends UsuarioTcc {
    
	private String laboratorios;
	
	private Integer quota;

	@OneToMany(cascade = CascadeType.ALL)
	private List<SolicitacaoOrientacaoTcc> solicitacoesOrientacaoTcc;

	public void adicionarSolicitacaoOrientacaoTcc(SolicitacaoOrientacaoTcc solicitacaoOrientacaoTcc) {
		this.solicitacoesOrientacaoTcc.add(solicitacaoOrientacaoTcc);
	}

	/**
	 * Posso cria uma nova solicitação desde que não exista nenhuma solicitação minha que não esta vinculada
	 * a alguma orientação de TCC ou que já foi negada
	 *
	 * Precisa melhorar a lógica
	 *
	 */
	public boolean solicitacaoEmAndamento(Aluno aluno, TemaTcc temaTcc) {
		return this.solicitacoesOrientacaoTcc
				.stream()
				.anyMatch(solicitacaoOrientacaoTcc ->
						(solicitacaoOrientacaoTcc.getAluno().equals(aluno) &&
								solicitacaoOrientacaoTcc.getTemaTcc().equals(temaTcc)) &&
								!solicitacaoOrientacaoTcc.isAceita()

				);

		/*

				return this.solicitacoesOrientacaoTcc
				.stream()
				.anyMatch(solicitacaoOrientacaoTcc ->
						(solicitacaoOrientacaoTcc.getAluno().equals(aluno) &&
								solicitacaoOrientacaoTcc.getTemaTcc().equals(temaTcc)) &&
								(solicitacaoOrientacaoTcc.isAceita() &&
								!solicitacaoOrientacaoTcc.isVinculadaComTcc())

				);
		 */

	}

	@Transient
	public String getAutoridade() { return Role.USER_PROF; }

	public SolicitacaoOrientacaoTcc getSolicitacaoOrientacao(Long id) {
		return this.solicitacoesOrientacaoTcc
				.stream()
				.filter(solicitacaoOrientacaoTcc -> solicitacaoOrientacaoTcc.getId().equals(id))
				.findAny()
				.orElseThrow(() -> new EntidadeNaoExisteException("Solicitação de orientação de TCC", "id", id.toString()));
	}
}
