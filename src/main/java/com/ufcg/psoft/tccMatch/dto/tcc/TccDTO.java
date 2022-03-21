package com.ufcg.psoft.tccMatch.dto.tcc;

import com.ufcg.psoft.tccMatch.dto.ModelDTO;
import com.ufcg.psoft.tccMatch.dto.usuario.UsuarioDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TccDTO extends ModelDTO {
    private UsuarioDTO aluno;

    private UsuarioDTO professor;

    private TemaTccDTO tema;
}
