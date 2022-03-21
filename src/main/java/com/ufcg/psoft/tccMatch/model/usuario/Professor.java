package com.ufcg.psoft.tccMatch.model.usuario;

import com.ufcg.psoft.tccMatch.security.util.Role;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Transient;

@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Professor extends UsuarioTcc {
    
	private String laboratorios;
	
	private Integer quota;

	@Transient
	public String getAutoridade() { return Role.USER_PROF; }

	// private List<SolicitacaoOrientacaoTcc> solicitacoesTcc;
}
