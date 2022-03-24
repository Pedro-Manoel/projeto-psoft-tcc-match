package com.ufcg.psoft.tccMatch.error.exception;

public class OrientacaoTccUsuarioNaoVinculadoException extends RuntimeException {
    public OrientacaoTccUsuarioNaoVinculadoException(Long idUsuario, Long idOrientacaoTcc) {
        super(
                String.format("Usuário com id <%s> não está vinculado com a orientação de TCC com id <%s>", idUsuario, idOrientacaoTcc)
        );
    }
}
