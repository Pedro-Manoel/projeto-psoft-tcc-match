package com.ufcg.psoft.tccMatch.dto;

import java.util.List;

import com.ufcg.psoft.tccMatch.model.AreaEstudo;
import com.ufcg.psoft.tccMatch.model.CaixaEmail;
import com.ufcg.psoft.tccMatch.model.TemaTCC;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class AlunoDTO {

	private String nome;
    
    private String matricula;
    
    private String email;
    
    private String senha;
    
    private String periodoPrevistoConclusao;

    // private CaixaEmail caixaEmail;
    // private  List<AreaEstudo> areasEstudo ;
	// private List<TemaTCC> temasTcc;
}
