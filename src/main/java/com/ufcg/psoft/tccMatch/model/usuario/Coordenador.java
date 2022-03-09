package com.ufcg.psoft.tccMatch.model.usuario;

import com.ufcg.psoft.tccMatch.model.ProblemaOrientacaoTCC;
import com.ufcg.psoft.tccMatch.model.TCC;
import com.ufcg.psoft.tccMatch.model.usuario.Usuario;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

//@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Coordenador{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private List<TCC> tccs;
	private List<ProblemaOrientacaoTCC> problemasOrientacaoTCC;
}
