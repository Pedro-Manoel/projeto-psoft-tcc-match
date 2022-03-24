package com.ufcg.psoft.tccMatch.error.exception;

public class SolicitacaoOrientacaoTccInvalidaException extends RuntimeException {
    public SolicitacaoOrientacaoTccInvalidaException(String titulo) {
        super(String.format(
                "Já existe uma solicitação sua em andamento para o tema de TCC <%s> com o professor solicitado", titulo
        ));
    }
}
