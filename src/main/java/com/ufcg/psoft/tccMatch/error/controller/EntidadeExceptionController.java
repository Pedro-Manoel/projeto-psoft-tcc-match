package com.ufcg.psoft.tccMatch.error.controller;

import com.ufcg.psoft.tccMatch.error.AppError;
import com.ufcg.psoft.tccMatch.error.exception.EntidadeJaExisteException;
import com.ufcg.psoft.tccMatch.error.exception.EntidadeNaoExisteException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class EntidadeExceptionController {
    @ExceptionHandler(EntidadeJaExisteException.class)
    public ResponseEntity<?> handleException (EntidadeJaExisteException exception){
        return AppError.responseBadRequest(exception);
    }

    @ExceptionHandler(EntidadeNaoExisteException.class)
    public ResponseEntity<?> handleException (EntidadeNaoExisteException exception){
        return AppError.responseNotFound(exception);
    }
}
