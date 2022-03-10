package com.ufcg.psoft.tccMatch.exception;

public class AreaEstudoJaExisteException extends RuntimeException{
    public AreaEstudoJaExisteException(String nome) {
        super(String.format("Area de estudo com nome %s já está cadastrado no sistema", nome));
    }
}
