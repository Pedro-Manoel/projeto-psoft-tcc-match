package com.ufcg.psoft.tccMatch.error.controller;

import com.ufcg.psoft.tccMatch.error.AppError;
import com.ufcg.psoft.tccMatch.error.exception.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class TccExceptionController {
    @ExceptionHandler({
            TemaTccInvalidoUsuarioException.class,

            SolicitacaoOrientacaoTccInvalidaException.class,
            SolicitacaoOrientacaoTccNaoAceitaException.class,
            SolicitacaoOrientacaoTccJaRespondidaException.class,
            SolicitacaoOrientacaoTccJaVinculadaComTccException.class,
            SolicitacaoOrientacaoTccInvalidaProfessorException.class,

            OrientacaoTccJaFinalizadaException.class,
            OrientacaoTccUsuarioNaoVinculadoException.class,

            ProfessorNaoDisponivelOrientacaoTccException.class
    })
    public ResponseEntity<?> handleException (RuntimeException exception){
        return AppError.responseBadRequest(exception);
    }
}
