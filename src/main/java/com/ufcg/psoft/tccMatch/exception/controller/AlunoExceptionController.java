package com.ufcg.psoft.tccMatch.exception.controller;

import com.ufcg.psoft.tccMatch.exception.AlunoJaExisteException;
import com.ufcg.psoft.tccMatch.exception.AlunoNaoExisteException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class AlunoExceptionController {
    @ExceptionHandler(AlunoJaExisteException.class)
    public ResponseEntity<?> handleException(AlunoJaExisteException exception){
        return AppError.responseBadRequest(exception);
    }

    @ExceptionHandler(AlunoNaoExisteException.class)
    public ResponseEntity<?> handleException(AlunoNaoExisteException exception){
        return AppError.responseNotFound(exception);
    }
}
