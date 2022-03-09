package com.ufcg.psoft.tccMatch.exception;

public class ProfessorJaExisteException extends RuntimeException {
    public ProfessorJaExisteException(String email) {
        super(String.format("Professor com email %s já está cadastrado no sistema", email));
    }
}
