package com.ufcg.psoft.tccMatch.model.usuario;

import com.ufcg.psoft.tccMatch.model.Model;
import com.ufcg.psoft.tccMatch.notification.model.CaixaEmail;
import lombok.*;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Getter
@Setter
@ToString
@AllArgsConstructor
public abstract class Usuario extends Model {
	private String nome;
    
    @Column(unique = true)
	private String email;
    
	private String senha;

	@OneToOne(cascade = CascadeType.ALL)
	public CaixaEmail caixaEmail;

	public Usuario() { this.caixaEmail = new CaixaEmail(); }

	public abstract String getAutoridade();
}
