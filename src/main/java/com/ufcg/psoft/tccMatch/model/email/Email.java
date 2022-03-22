package com.ufcg.psoft.tccMatch.model.email;

import com.ufcg.psoft.tccMatch.model.Model;
import com.ufcg.psoft.tccMatch.model.usuario.Usuario;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.persistence.*;

//@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Email extends Model {
	@OneToOne
	private Usuario remetente;

	private String mensagem;
}
