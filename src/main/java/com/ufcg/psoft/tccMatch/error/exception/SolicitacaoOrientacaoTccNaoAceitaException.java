package com.ufcg.psoft.tccMatch.error.exception;

public class SolicitacaoOrientacaoTccNaoAceitaException extends RuntimeException {
    public SolicitacaoOrientacaoTccNaoAceitaException (Long id) {
        super(
                String.format(
                        "A solicitação de orientação de TCC com id <%s> não foi aceita pelo professor solicitado",
                        id.toString()
                )
        );
    }
}
