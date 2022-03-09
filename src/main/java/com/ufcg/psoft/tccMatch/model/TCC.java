package com.ufcg.psoft.tccMatch.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.ufcg.psoft.tccMatch.dto.AlunoDTO;
import com.ufcg.psoft.tccMatch.dto.ProfessorDTO;

@Entity
public class TCC {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private AlunoDTO aluno;
	
	private ProfessorDTO professorDTO;
	
	private String semestre;
	
	private TemaTCC tema;
	
	private boolean concluido;
	
	
	
	
	
	
	
	

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

	public ProfessorDTO getProfessorDTO() {
		return professorDTO;
	}

	public void setProfessorDTO(ProfessorDTO professorDTO) {
		this.professorDTO = professorDTO;
	}

	public String getSemestre() {
		return semestre;
	}

	public void setSemestre(String semestre) {
		this.semestre = semestre;
	}

	public TemaTCC getTema() {
		return tema;
	}

	public void setTema(TemaTCC tema) {
		this.tema = tema;
	}

	public boolean isConcluido() {
		return concluido;
	}

	public void setConcluido(boolean concluido) {
		this.concluido = concluido;
	}
	
	
	
	
}
