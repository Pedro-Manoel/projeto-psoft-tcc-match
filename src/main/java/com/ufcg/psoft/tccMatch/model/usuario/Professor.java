package com.ufcg.psoft.tccMatch.model.usuario;

import com.ufcg.psoft.tccMatch.model.AreaEstudo;
import com.ufcg.psoft.tccMatch.model.SolicitacaoOrientacaoTCC;
import com.ufcg.psoft.tccMatch.model.TemaTCC;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Professor extends Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public String nome;

    public String email;

    public String senha;
    
	private String laboratorio;
	
	private int quota;
	
	// private List<AreaEstudo> areasEstudo;
	
	// private List<SolicitacaoOrientacaoTCC> solicitacoesTCC;
	
	// private List<TemaTCC> temasTCC;
}
