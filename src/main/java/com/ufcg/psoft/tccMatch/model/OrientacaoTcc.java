package com.ufcg.psoft.tccMatch.model;

import com.ufcg.psoft.tccMatch.dto.usuario.AlunoDTO;
import com.ufcg.psoft.tccMatch.dto.usuario.ProfessorDTO;
import com.ufcg.psoft.tccMatch.model.usuario.Aluno;
import com.ufcg.psoft.tccMatch.model.usuario.Professor;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrientacaoTcc extends Model {
	@OneToOne(cascade = CascadeType.ALL)
	private Tcc tcc;

	private String semestre;
	
	private boolean concluida;
}
