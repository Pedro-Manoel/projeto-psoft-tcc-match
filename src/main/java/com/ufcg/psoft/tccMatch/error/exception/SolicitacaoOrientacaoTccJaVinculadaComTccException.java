package com.ufcg.psoft.tccMatch.error.exception;

public class SolicitacaoOrientacaoTccJaVinculadaComTccException extends RuntimeException {
    public SolicitacaoOrientacaoTccJaVinculadaComTccException (Long id) {
        super(
                String.format(
                        "Solicitação de orientação de TCC com id <%s> já está vinculada com uma orientação de TCC",
                        id.toString()
                )
        );
    }
}
