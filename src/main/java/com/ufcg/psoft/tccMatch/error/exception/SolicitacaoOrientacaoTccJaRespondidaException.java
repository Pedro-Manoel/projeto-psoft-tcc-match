package com.ufcg.psoft.tccMatch.error.exception;

public class SolicitacaoOrientacaoTccJaRespondidaException extends RuntimeException {
    public SolicitacaoOrientacaoTccJaRespondidaException(Long id) {
        super(
                String.format("Solicitação de orientação de TCC com id <%s> já foi respondida", id.toString())
        );
    }
}
