package com.ufcg.psoft.tccMatch.dto;

import java.util.List;

import com.ufcg.psoft.tccMatch.model.AreaEstudo;
import com.ufcg.psoft.tccMatch.model.CaixaEmail;
import com.ufcg.psoft.tccMatch.model.SolicitacaoOrientacaoTCC;
import com.ufcg.psoft.tccMatch.model.TemaTCC;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ProfessorDTO {

	private String nome;
	private String email;
	private CaixaEmail caixaEmail;
	private String laboratorio;
	private int quota;
	private List<AreaEstudo> areasEstudo;
	private List<SolicitacaoOrientacaoTCC> solicitacoesTCC;
	private List<TemaTCC> temasTCC;
}
