package com.ufcg.psoft.tccMatch.model.tcc;

import com.ufcg.psoft.tccMatch.model.Model;
import com.ufcg.psoft.tccMatch.model.tcc.OrientacaoTcc;
import com.ufcg.psoft.tccMatch.model.usuario.Aluno;
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

	@OneToOne
	private OrientacaoTcc orientacaoTcc;

	private String problema;

	public boolean isUsuarioAluno () {
		return this.getUsuario().equals(this.getOrientacaoTcc().getTcc().getAluno());
	}
}
