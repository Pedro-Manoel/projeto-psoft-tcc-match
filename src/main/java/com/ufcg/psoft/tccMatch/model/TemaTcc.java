package com.ufcg.psoft.tccMatch.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

import javax.persistence.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class  TemaTcc extends Model{
	@Column(unique = true)
	private String titulo;
	
	private String descricao;

	@ManyToMany // Verificar depois se OneToMany funciona usando uuid
	private List<AreaEstudo> areasEstudo;
	
	private String status;
}
