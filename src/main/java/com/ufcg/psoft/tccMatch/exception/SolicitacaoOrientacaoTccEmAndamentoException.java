package com.ufcg.psoft.tccMatch.exception;

public class SolicitacaoOrientacaoTccEmAndamentoException extends RuntimeException {
    public SolicitacaoOrientacaoTccEmAndamentoException(String titulo) {
        super(String.format(
                "Já existe uma solicitação sua em andamento para o tema de tcc <%s> com o professor solicitado", titulo
        ));
    }
}
