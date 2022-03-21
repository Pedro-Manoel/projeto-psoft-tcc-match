package com.ufcg.psoft.tccMatch.model;

import com.ufcg.psoft.tccMatch.dto.usuario.AlunoDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SolicitacaoOrientacaoTcc extends Model {
	private AlunoDTO aluno;
    
	private TemaTcc temaTCC;
	
    private RespostaSolicitacaoOrientacaoTcc resposta;
 }
