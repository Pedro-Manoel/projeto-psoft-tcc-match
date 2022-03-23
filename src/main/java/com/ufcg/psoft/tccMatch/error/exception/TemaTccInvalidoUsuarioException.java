package com.ufcg.psoft.tccMatch.error.exception;

public class TemaTccInvalidoUsuarioException extends RuntimeException {
    public TemaTccInvalidoUsuarioException(String titulo) {
        super(String.format("O tema de TCC com título <%s> não está vinculado ao usuário solicitado", titulo));
    }
}
