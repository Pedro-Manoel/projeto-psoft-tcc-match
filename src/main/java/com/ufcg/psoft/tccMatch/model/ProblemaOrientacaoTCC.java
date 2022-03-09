package com.ufcg.psoft.tccMatch.model;

import com.ufcg.psoft.tccMatch.model.usuario.Usuario;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

//@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProblemaOrientacaoTCC {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private Usuario ususario;
	private String problema;
}