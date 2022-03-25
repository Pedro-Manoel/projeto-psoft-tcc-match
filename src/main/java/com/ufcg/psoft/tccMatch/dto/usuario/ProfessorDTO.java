package com.ufcg.psoft.tccMatch.dto.usuario;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProfessorDTO extends UsuarioDTO {
	private String laboratorios;

	private Integer quota;
}
