package com.ufcg.psoft.tccMatch.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RespostaSolicitacaoOrientacaoTcc extends Model {
	private boolean aceita;
	
    private String mensagem;
}
