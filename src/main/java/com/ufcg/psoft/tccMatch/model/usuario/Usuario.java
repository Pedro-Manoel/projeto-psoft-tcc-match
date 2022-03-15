package com.ufcg.psoft.tccMatch.model.usuario;

import com.ufcg.psoft.tccMatch.model.Model;
import lombok.*;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public abstract class Usuario extends Model {
	private String nome;
    
    @Column(unique = true)
	private String email;
    
	private String senha;

	public abstract String getAutoridade();

	// public CaixaEmail caixaEmail;
}
