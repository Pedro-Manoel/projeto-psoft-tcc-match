package com.ufcg.psoft.tccMatch.model.tcc;

import com.ufcg.psoft.tccMatch.model.AreaEstudo;
import com.ufcg.psoft.tccMatch.model.Model;
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
public class  TemaTcc extends Model {
	@Column(unique = true)
	private String titulo;
	
	private String descricao;

	@ManyToMany
	private List<AreaEstudo> areasEstudo;
	
	private String status;
}
