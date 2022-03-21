package com.ufcg.psoft.tccMatch.error.exception;

public class OrientacaoTccJaFinalizadaException extends RuntimeException {
    public OrientacaoTccJaFinalizadaException(Long id) {
        super(
                String.format("Orientação de TCC com id <%s> já foi finalizada", id.toString())
        );
    }
}
