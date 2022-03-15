package com.ufcg.psoft.tccMatch.exception;

public class EntidadeJaExisteException extends RuntimeException {
    public EntidadeJaExisteException(String entidade, String nomeAtributo, String valorAtributo) {
        super(String.format("%s com %s <%s> já está cadastrado no sistema",entidade, nomeAtributo, valorAtributo));
    }
}
