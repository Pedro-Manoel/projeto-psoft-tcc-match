package com.ufcg.psoft.tccMatch.error.exception;

public class TemaTccInvalidoProfessorException extends RuntimeException {
    public TemaTccInvalidoProfessorException(String titulo) {
        super(String.format("O tema de tcc com título <%s> não está vinculado ao professor solicitado", titulo));
    }
}
