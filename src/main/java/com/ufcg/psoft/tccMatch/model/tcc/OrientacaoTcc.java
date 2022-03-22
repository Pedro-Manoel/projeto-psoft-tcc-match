package com.ufcg.psoft.tccMatch.model.tcc;

import com.ufcg.psoft.tccMatch.model.Model;
import io.swagger.v3.oas.annotations.Hidden;
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

	@Hidden
	private boolean concluida;

	public void finalizar() { this.concluida = true; }
}
