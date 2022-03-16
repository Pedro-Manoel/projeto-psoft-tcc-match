package com.ufcg.psoft.tccMatch.model;

import com.ufcg.psoft.tccMatch.model.usuario.UsuarioTCC;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProblemaOrientacaoTCC extends Model {
	@OneToOne
	private UsuarioTCC usuario;
	private String problema;
}
