package com.ufcg.psoft.tccMatch.exception.controller;

import com.ufcg.psoft.tccMatch.exception.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class EntidadeExceptionController {
    @ExceptionHandler(EntidadeJaExisteException.class)
    public ResponseEntity<?> handleException(EntidadeJaExisteException exception){
        return AppError.responseBadRequest(exception);
    }

    @ExceptionHandler(EntidadeNaoExisteException.class)
    public ResponseEntity<?> handleException(EntidadeNaoExisteException exception){
        return AppError.responseNotFound(exception);
    }

    @ExceptionHandler(SolicitacaoOrientacaoTccInvalidaException.class)
    public ResponseEntity<?> handleException(SolicitacaoOrientacaoTccInvalidaException exception){
        return AppError.responseBadRequest(exception);
    }

    @ExceptionHandler(TemaTccInvalidoProfessorException.class)
    public ResponseEntity<?> handleException(TemaTccInvalidoProfessorException exception){
        return AppError.responseBadRequest(exception);
    }

    @ExceptionHandler(SolicitacaoOrientacaoTccNaoAceitaException.class)
    public ResponseEntity<?> handleException(SolicitacaoOrientacaoTccNaoAceitaException exception){
        return AppError.responseBadRequest(exception);
    }

    @ExceptionHandler(OrientacaoTccJaFinalizadaException.class)
    public ResponseEntity<?> handleException(OrientacaoTccJaFinalizadaException exception){
        return AppError.responseBadRequest(exception);
    }
}
