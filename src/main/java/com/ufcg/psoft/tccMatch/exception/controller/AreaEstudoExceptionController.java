package com.ufcg.psoft.tccMatch.exception.controller;

import com.ufcg.psoft.tccMatch.exception.AreaEstudoJaExisteException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


@ControllerAdvice
public class AreaEstudoExceptionController {
    @ExceptionHandler(AreaEstudoJaExisteException.class)
    public ResponseEntity<?> handleException(AreaEstudoJaExisteException exception){
        return AppError.responseBadRequest(exception);
    }
}
