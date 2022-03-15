package com.ufcg.psoft.tccMatch.model.usuario;

import com.ufcg.psoft.tccMatch.security.util.Role;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Transient;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Professor extends UsuarioTCC {
    
	private String laboratorios;
	
	private Integer quota;

	@Transient
	public String getAutoridade() { return Role.USER_PROF; }

	// private List<SolicitacaoOrientacaoTCC> solicitacoesTCC;
}
