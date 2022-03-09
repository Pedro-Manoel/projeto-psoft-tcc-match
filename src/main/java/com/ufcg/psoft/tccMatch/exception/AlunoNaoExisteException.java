package com.ufcg.psoft.tccMatch.exception;

public class AlunoNaoExisteException extends RuntimeException {
    public AlunoNaoExisteException(Long id) {
        super(String.format("Aluno com id %s não está cadastrado no sistema", id));
    }
}
