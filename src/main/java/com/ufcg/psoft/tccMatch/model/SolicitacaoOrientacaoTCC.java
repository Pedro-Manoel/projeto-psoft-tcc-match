package com.ufcg.psoft.tccMatch.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.ufcg.psoft.tccMatch.dto.AlunoDTO;

@Entity
public class SolicitacaoOrientacaoTCC {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private AlunoDTO aluno;
	private TemaTCC temaTCC;
	private RespostaSolicitacaoOrientacaoTCC resposta;
	
	
	
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public AlunoDTO getAluno() {
		return aluno;
	}
	public void setAluno(AlunoDTO aluno) {
		this.aluno = aluno;
	}
	public TemaTCC getTemaTCC() {
		return temaTCC;
	}
	public void setTemaTCC(TemaTCC temaTCC) {
		this.temaTCC = temaTCC;
	}
	public RespostaSolicitacaoOrientacaoTCC getResposta() {
		return resposta;
	}
	public void setResposta(RespostaSolicitacaoOrientacaoTCC resposta) {
		this.resposta = resposta;
	}
	
	
 }
