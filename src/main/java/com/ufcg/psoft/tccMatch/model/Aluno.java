package com.ufcg.psoft.tccMatch.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Aluno extends Usuario{


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String matricula;
	
	private String periodoPrevistoConclusao;
	
	private List<AreaEstudo> areasEstudo;
	
	private List<TemaTCC> temasTCC;
	
	
	public Aluno() {
		this.areasEstudo = new ArrayList<AreaEstudo>();
		this.temasTCC = new ArrayList<TemaTCC>();
	}
	
	
	
	
	
	
	
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public List<TemaTCC> getTemasTCC() {
		return temasTCC;
	}

	public void setTemasTCC(List<TemaTCC> temasTCC) {
		this.temasTCC = temasTCC;
	}
	
	
	
	
	
}
