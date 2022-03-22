package com.ufcg.psoft.tccMatch.exception;

public class SolicitacaoOrientacaoTccInvalidaException extends RuntimeException {
    public SolicitacaoOrientacaoTccInvalidaException(String titulo) {
        super(String.format(
                "Já existe uma solicitação sua em andamento para o tema de tcc <%s> com o professor solicitado", titulo
        ));
    }
}
