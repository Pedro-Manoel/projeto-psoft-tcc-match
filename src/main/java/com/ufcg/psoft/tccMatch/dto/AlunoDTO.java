package com.ufcg.psoft.tccMatch.dto;

import java.util.List;

import com.ufcg.psoft.tccMatch.model.AreaEstudo;
import com.ufcg.psoft.tccMatch.model.CaixaEmail;
import com.ufcg.psoft.tccMatch.model.TemaTCC;

public class AlunoDTO {

	private String nome;
	private String email;
	private CaixaEmail caixaEmail;
	private String matricula;
	private String periodoPrevistoConclusao;
	private  List<AreaEstudo> areasEstudo ;
	private List<TemaTCC> temasTcc;
	
	
	
	
	
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public CaixaEmail getCaixaEmail() {
		return caixaEmail;
	}
	public void setCaixaEmail(CaixaEmail caixaEmail) {
		this.caixaEmail = caixaEmail;
	}
	public String getMatricula() {
		return matricula;
	}
	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
	public String getPeriodoPrevistoConclusao() {
		return periodoPrevistoConclusao;
	}
	public void setPeriodoPrevistoConclusao(String periodoPrevistoConclusao) {
		this.periodoPrevistoConclusao = periodoPrevistoConclusao;
	}
	public List<AreaEstudo> getAreasEstudo() {
		return areasEstudo;
	}
	public void setAreasEstudo(List<AreaEstudo> areasEstudo) {
		this.areasEstudo = areasEstudo;
	}
	public List<TemaTCC> getTemasTcc() {
		return temasTcc;
	}
	public void setTemasTcc(List<TemaTCC> temasTcc) {
		this.temasTcc = temasTcc;
	}
	
	
	
	
	
	
	
}
