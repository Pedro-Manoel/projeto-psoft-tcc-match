package com.ufcg.psoft.tccMatch.exception;

public class SolicitacaoOrientacaoTccNaoAceitaException extends RuntimeException {
    public SolicitacaoOrientacaoTccNaoAceitaException(Long id) {
        super(
                String.format("A solicitação de orientação de TCC com id <%s> não foi aceita pelo professor solicitado ou já está vinculada a alguma orientação de TCC", id.toString())
        );
    }
}
