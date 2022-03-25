package com.ufcg.psoft.tccMatch.error.exception;

public class SolicitacaoOrientacaoTccInvalidaProfessorException extends RuntimeException {
    public SolicitacaoOrientacaoTccInvalidaProfessorException (String atributo, String valor) {
        super(
                String.format(
                        "A solicitação de orientação de TCC com o %s <%s> não está vinculada ao professor solicitado",
                        atributo,
                        valor
                )
        );
    }
}
