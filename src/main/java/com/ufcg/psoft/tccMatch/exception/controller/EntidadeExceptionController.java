package com.ufcg.psoft.tccMatch.exception.controller;

import com.ufcg.psoft.tccMatch.exception.EntidadeJaExisteException;
import com.ufcg.psoft.tccMatch.exception.EntidadeNaoExisteException;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
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
}
