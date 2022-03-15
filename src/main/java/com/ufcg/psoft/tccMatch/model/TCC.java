package com.ufcg.psoft.tccMatch.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.ufcg.psoft.tccMatch.dto.usuario.AlunoDTO;
import com.ufcg.psoft.tccMatch.dto.usuario.ProfessorDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TCC extends Model {
	private AlunoDTO aluno;
	
	private ProfessorDTO professorDTO;
	
	private String semestre;
	
	private TemaTCC tema;
	
	private boolean concluido;
}
