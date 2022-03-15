package com.ufcg.psoft.tccMatch.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

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
public class SolicitacaoOrientacaoTCC extends Model {
	private AlunoDTO aluno;
    
	private TemaTCC temaTCC;
	
    private RespostaSolicitacaoOrientacaoTCC resposta;
 }
