package com.ufcg.psoft.tccMatch.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Coordenador extends Usuario{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private List<TCC> tccs;
	private List<ProblemaOrientacaoTCC> problemasOrientacaoTCC;
	
	
	public Coordenador() {
		this.tccs = new ArrayList<TCC>();
		this.problemasOrientacaoTCC = new ArrayList<ProblemaOrientacaoTCC>();
	}
	
	
	
	
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public List<TCC> getTccs() {
		return tccs;
	}
	public void setTccs(List<TCC> tccs) {
		this.tccs = tccs;
	}
	public List<ProblemaOrientacaoTCC> getProblemasOrientacaoTCC() {
		return problemasOrientacaoTCC;
	}
	public void setProblemasOrientacaoTCC(List<ProblemaOrientacaoTCC> problemasOrientacaoTCC) {
		this.problemasOrientacaoTCC = problemasOrientacaoTCC;
	}
	
	
	
	
	
	
}
