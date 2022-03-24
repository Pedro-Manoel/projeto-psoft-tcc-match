package com.ufcg.psoft.tccMatch.model.tcc;

import com.ufcg.psoft.tccMatch.model.Model;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RespostaSolicitacaoOrientacaoTcc extends Model {
	private boolean aceita;
	
    private String mensagem;
}
