package com.ufcg.psoft.tccMatch.error.exception;

public class TemaTccInvalidoUsuarioException extends RuntimeException {
    public TemaTccInvalidoUsuarioException(String atributo, String valor) {
        super(String.format("O tema de TCC com o %s <%s> não está vinculado ao usuário solicitado", atributo, valor));
    }
}
