package com.ufcg.psoft.tccMatch.dto.tcc.solicitacao;

import com.ufcg.psoft.tccMatch.dto.ModelDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RespostaSolicitacaoOrientacaoTccDTO extends ModelDTO {
    private boolean aceita;

    private String mensagem;
}
