package com.ufcg.psoft.tccMatch.dto.usuario;

import com.ufcg.psoft.tccMatch.dto.usuario.UsuarioDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ProfessorDTO extends UsuarioDTO {

	private String laboratorios;
	private Integer quota;

    //private CaixaEmail caixaEmail;
	//private List<AreaEstudo> areasEstudo;
	//private List<SolicitacaoOrientacaoTCC> solicitacoesTCC;
	//private List<TemaTCC> temasTCC;
}
