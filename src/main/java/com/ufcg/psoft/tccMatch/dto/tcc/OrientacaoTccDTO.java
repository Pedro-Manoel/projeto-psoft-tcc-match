package com.ufcg.psoft.tccMatch.dto.tcc;

import com.ufcg.psoft.tccMatch.dto.ModelDTO;
import com.ufcg.psoft.tccMatch.dto.tcc.TccDTO;
import io.swagger.v3.oas.annotations.Hidden;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrientacaoTccDTO extends ModelDTO {
    @Hidden
    private TccDTO tcc;

    private Long idProfessor;

    private Long idSolicitacao;

    private String semestre;

    @Hidden
    private boolean concluida;
}
