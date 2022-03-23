package com.ufcg.psoft.tccMatch.dto.tcc.tema;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ufcg.psoft.tccMatch.dto.ModelDTO;
import com.ufcg.psoft.tccMatch.dto.tcc.tema.TemaTccDTO;
import com.ufcg.psoft.tccMatch.dto.usuario.UsuarioDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TemaTccUsuarioDTO extends ModelDTO {
    @JsonIgnore
    private Long id;

    private UsuarioDTO usuario;

    private TemaTccDTO temaTcc;
}