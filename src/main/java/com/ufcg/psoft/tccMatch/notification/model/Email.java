package com.ufcg.psoft.tccMatch.notification.model;

import com.ufcg.psoft.tccMatch.model.Model;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

import javax.persistence.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Email extends Model {
	private String mensagem;

	private Date data;
}
