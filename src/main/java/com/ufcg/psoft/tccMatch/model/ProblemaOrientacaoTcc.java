package com.ufcg.psoft.tccMatch.model;

import com.ufcg.psoft.tccMatch.model.usuario.UsuarioTcc;
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
public class ProblemaOrientacaoTcc extends Model {
	@OneToOne
	private UsuarioTcc usuario;
	private String problema;
}
