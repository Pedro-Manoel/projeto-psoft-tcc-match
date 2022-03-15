package com.ufcg.psoft.tccMatch.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

//@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Email extends Model {
	private String remetente;
	
	private boolean lida;
	
	private String data = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(Calendar.getInstance().getTime());
	
	private String mensagem;
}
