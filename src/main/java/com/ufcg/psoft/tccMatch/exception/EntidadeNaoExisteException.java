package com.ufcg.psoft.tccMatch.exception;

public class EntidadeNaoExisteException extends RuntimeException {
    public EntidadeNaoExisteException(String entidade, String nomeAtributo, String valorAtributo) {
        super(String.format("%s com %s <%s> não está cadastrado no sistema",entidade, nomeAtributo, valorAtributo));
    }
}
