package com.ufcg.psoft.tccMatch.model.usuario;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ufcg.psoft.tccMatch.model.CaixaEmail;
import com.ufcg.psoft.tccMatch.model.Model;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public abstract class Usuario extends Model {
	public String nome;
    
    @Column(unique = true)
	public String email;
    
	public String senha;

	// public CaixaEmail caixaEmail;
}
