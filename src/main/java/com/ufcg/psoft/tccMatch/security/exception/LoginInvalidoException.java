package com.ufcg.psoft.tccMatch.security.exception;

public class LoginInvalidoException extends RuntimeException {
    public LoginInvalidoException() {
        super("E-mail ou senha inválido(s)");
    }
}
