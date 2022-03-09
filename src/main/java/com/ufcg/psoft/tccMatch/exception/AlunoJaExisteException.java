package com.ufcg.psoft.tccMatch.exception;

public class AlunoJaExisteException extends RuntimeException {
    public AlunoJaExisteException(String email) {
        super(String.format("Aluno com email %s já está cadastrado no sistema", email));
    }
}
