package com.ufcg.psoft.tccMatch.error.exception;

public class ProfessorNaoDisponivelOrientacaoTccException extends RuntimeException {
    public ProfessorNaoDisponivelOrientacaoTccException(Long id) {
        super(
                String.format("Professor com id <%s> não está disponível para uma orientação de TCC no momento", id.toString())
        );
    }
}
