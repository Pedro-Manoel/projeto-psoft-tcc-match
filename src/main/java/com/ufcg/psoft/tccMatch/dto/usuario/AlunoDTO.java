package com.ufcg.psoft.tccMatch.dto.usuario;

import com.ufcg.psoft.tccMatch.dto.usuario.UsuarioDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class AlunoDTO extends UsuarioDTO {

    private String matricula;

    private String periodoPrevistoConclusao;

    // private CaixaEmail caixaEmail;
    // private  List<AreaEstudo> areasEstudo ;
	// private List<TemaTcc> temasTcc;
}
