package com.ufcg.psoft.tccMatch.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class TemaTCC {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	
	private String titulo;
	
	private String descricao;
	
	private List<AreaEstudo> areasEstudo;
	
	private String status;
	
	
	public TemaTCC() {
		this.areasEstudo = new ArrayList<AreaEstudo>();
	}

	
	
	
	
	
	
	

	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getTitulo() {
		return titulo;
	}


	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}


	public String getDescricao() {
		return descricao;
	}


	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}


	public List<AreaEstudo> getAreasEstudo() {
		return areasEstudo;
	}


	public void setAreasEstudo(List<AreaEstudo> areasEstudo) {
		this.areasEstudo = areasEstudo;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}
	
	
	
	
}
