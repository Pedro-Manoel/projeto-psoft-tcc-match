package com.ufcg.psoft.tccMatch.exception.controller;

import com.ufcg.psoft.tccMatch.exception.TemaTCCJaExisteException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class TemaTCCExceptionController {
    @ExceptionHandler(TemaTCCJaExisteException.class)
    public ResponseEntity<?> handleException(TemaTCCJaExisteException exception){
        return AppError.responseBadRequest(exception);
    }
}
