package com.ufcg.psoft.tccMatch.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Professor {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String laboratorio;
	
	private int quota;
	
	private List<AreaEstudo> areasEstudo;
	
	private List<SolicitacaoOrientacaoTCC> solicitacoesTCC;
	
	private List<TemaTCC> temasTCC;
	
	
	public Professor() {
		this.areasEstudo = new ArrayList<AreaEstudo>();
		this.solicitacoesTCC = new ArrayList<SolicitacaoOrientacaoTCC>();
		this.temasTCC = new ArrayList<TemaTCC>();
	}
	
	
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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
