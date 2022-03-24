package com.ufcg.psoft.tccMatch.security.error.exception;

public class LoginInvalidoException extends RuntimeException {
    public LoginInvalidoException() {
        super("E-mail ou senha inválido(s)");
    }
}
