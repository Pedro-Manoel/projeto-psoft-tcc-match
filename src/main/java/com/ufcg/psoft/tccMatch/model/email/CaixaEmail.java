package com.ufcg.psoft.tccMatch.model.email;

import com.ufcg.psoft.tccMatch.model.Model;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;

//@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CaixaEmail extends Model {
	@OneToMany
	private List<Email> emails;
}
