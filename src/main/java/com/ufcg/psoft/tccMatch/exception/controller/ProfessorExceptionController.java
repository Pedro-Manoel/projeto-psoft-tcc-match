package com.ufcg.psoft.tccMatch.exception.controller;

import com.ufcg.psoft.tccMatch.exception.ProfessorJaExisteException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ProfessorExceptionController {
    @ExceptionHandler(ProfessorJaExisteException.class)
    public ResponseEntity<?> handleException(ProfessorJaExisteException exception){
        return AppError.responseBadRequest(exception);
    }
}
