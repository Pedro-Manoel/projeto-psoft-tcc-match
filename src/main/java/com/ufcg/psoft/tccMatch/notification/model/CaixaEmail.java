package com.ufcg.psoft.tccMatch.notification.model;

import com.ufcg.psoft.tccMatch.model.Model;
import com.ufcg.psoft.tccMatch.notification.model.Email;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CaixaEmail extends Model {
	@OneToMany(cascade = CascadeType.ALL)
	private List<Email> emails;

	public void adicionarEmail(Email email) {
		this.emails.add(email);
	}

}
