package com.ufcg.psoft.tccMatch.error.exception;

public class EntidadeJaExisteException extends RuntimeException {
    public EntidadeJaExisteException(String entidade, String nomeAtributo, String valorAtributo) {
        super(String.format("%s com %s <%s> já está cadastrado(a) no sistema", entidade, nomeAtributo, valorAtributo));
    }
}
