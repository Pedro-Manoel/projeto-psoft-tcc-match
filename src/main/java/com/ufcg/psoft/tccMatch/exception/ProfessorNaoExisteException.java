package com.ufcg.psoft.tccMatch.exception;

public class ProfessorNaoExisteException extends RuntimeException {
    public ProfessorNaoExisteException(Long id) {
        super(String.format("Professor com id %s não está cadastrado no sistema", id));
    }
}
