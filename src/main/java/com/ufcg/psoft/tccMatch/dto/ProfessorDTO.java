package com.ufcg.psoft.tccMatch.dto;

import java.util.List;

import com.ufcg.psoft.tccMatch.model.AreaEstudo;
import com.ufcg.psoft.tccMatch.model.CaixaEmail;
import com.ufcg.psoft.tccMatch.model.SolicitacaoOrientacaoTCC;
import com.ufcg.psoft.tccMatch.model.TemaTCC;

public class ProfessorDTO {

	private String nome;
	private String email;
	private CaixaEmail caixaEmail;
	private String laboratorio;
	private int quota;
	private List<AreaEstudo> areasEstudo;
	private List<SolicitacaoOrientacaoTCC> solicitacoesTCC;
	private List<TemaTCC> temasTCC;
	
	
	
	
	
	
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
	public String getLaboratorio() {
		return laboratorio;
	}
	public void setLaboratorio(String laboratorio) {
		this.laboratorio = laboratorio;
	}
	public int getQuota() {
		return quota;
	}
	public void setQuota(int quota) {
		this.quota = quota;
	}
	public List<AreaEstudo> getAreasEstudo() {
		return areasEstudo;
	}
	public void setAreasEstudo(List<AreaEstudo> areasEstudo) {
		this.areasEstudo = areasEstudo;
	}
	public List<SolicitacaoOrientacaoTCC> getSolicitacoesTCC() {
		return solicitacoesTCC;
	}
	public void setSolicitacoesTCC(List<SolicitacaoOrientacaoTCC> solicitacoesTCC) {
		this.solicitacoesTCC = solicitacoesTCC;
	}
	public List<TemaTCC> getTemasTCC() {
		return temasTCC;
	}
	public void setTemasTCC(List<TemaTCC> temasTCC) {
		this.temasTCC = temasTCC;
	}
	
	
	
	
	
	
	
}
