package com.ufcg.psoft.tccMatch.exception.controller;

import com.ufcg.psoft.tccMatch.exception.AlunoNaoExisteException;
import com.ufcg.psoft.tccMatch.exception.ProfessorJaExisteException;
import com.ufcg.psoft.tccMatch.exception.ProfessorNaoExisteException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ProfessorExceptionController {
    @ExceptionHandler(ProfessorJaExisteException.class)
    public ResponseEntity<?> handleException(ProfessorJaExisteException exception){
        return AppError.responseBadRequest(exception);
    }

    @ExceptionHandler(ProfessorNaoExisteException.class)
    public ResponseEntity<?> handleException(ProfessorNaoExisteException exception){
        return AppError.responseNotFound(exception);
    }
}
