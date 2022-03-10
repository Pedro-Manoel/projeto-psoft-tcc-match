package com.ufcg.psoft.tccMatch.exception;

public class AreaEstudoNaoExisteException extends RuntimeException{
    public AreaEstudoNaoExisteException(String nome) {
        super(String.format("Area de estudo com nome %s não existe no sistema", nome));
    }
}
