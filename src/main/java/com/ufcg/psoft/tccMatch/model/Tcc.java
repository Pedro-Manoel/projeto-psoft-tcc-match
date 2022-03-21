package com.ufcg.psoft.tccMatch.model;

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
public class Tcc extends Model {
	private AlunoDTO aluno;
	
	private ProfessorDTO professorDTO;
	
	private String semestre;
	
	private TemaTcc tema;
	
	private boolean concluido;
}
