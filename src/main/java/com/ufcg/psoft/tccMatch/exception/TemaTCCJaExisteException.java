package com.ufcg.psoft.tccMatch.exception;

public class TemaTCCJaExisteException extends RuntimeException {
    public TemaTCCJaExisteException(String titulo) {
        super(String.format("TemaTCC com titulo %s já está cadastrado no sistema", titulo));
    }
}
