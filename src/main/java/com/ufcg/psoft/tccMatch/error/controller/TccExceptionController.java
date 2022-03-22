package com.ufcg.psoft.tccMatch.error.controller;

import com.ufcg.psoft.tccMatch.error.AppError;
import com.ufcg.psoft.tccMatch.error.exception.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class TccExceptionController {
    @ExceptionHandler(TemaTccInvalidoProfessorException.class)
    public ResponseEntity<?> handleException(TemaTccInvalidoProfessorException exception){
        return AppError.responseBadRequest(exception);
    }

    @ExceptionHandler(SolicitacaoOrientacaoTccInvalidaException.class)
    public ResponseEntity<?> handleException(SolicitacaoOrientacaoTccInvalidaException exception){
        return AppError.responseBadRequest(exception);
    }

    @ExceptionHandler(SolicitacaoOrientacaoTccNaoAceitaException.class)
    public ResponseEntity<?> handleException(SolicitacaoOrientacaoTccNaoAceitaException exception){
        return AppError.responseBadRequest(exception);
    }

    @ExceptionHandler(SolicitacaoOrientacaoTccJaRespondidaException.class)
    public ResponseEntity<?> handleException(SolicitacaoOrientacaoTccJaRespondidaException exception){
        return AppError.responseBadRequest(exception);
    }

    @ExceptionHandler(OrientacaoTccJaFinalizadaException.class)
    public ResponseEntity<?> handleException(OrientacaoTccJaFinalizadaException exception){
        return AppError.responseBadRequest(exception);
    }

    @ExceptionHandler(ProfessorNaoDisponivelOrientacaoTccException.class)
    public ResponseEntity<?> handleException(ProfessorNaoDisponivelOrientacaoTccException exception){
        return AppError.responseBadRequest(exception);
    }

    @ExceptionHandler(SolicitacaoOrientacaoTccJaVinculadaComTccException.class)
    public ResponseEntity<?> handleException(SolicitacaoOrientacaoTccJaVinculadaComTccException exception){
        return AppError.responseBadRequest(exception);
    }
}
