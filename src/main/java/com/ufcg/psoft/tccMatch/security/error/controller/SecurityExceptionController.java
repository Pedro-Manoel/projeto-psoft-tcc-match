package com.ufcg.psoft.tccMatch.security.error.controller;

import com.ufcg.psoft.tccMatch.error.AppError;
import com.ufcg.psoft.tccMatch.security.error.exception.LoginInvalidoException;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class SecurityExceptionController {
    @ExceptionHandler(LoginInvalidoException.class)
    public ResponseEntity<?> handleException(LoginInvalidoException exception){
        return AppError.responseBadRequest(exception);
    }

    @ExceptionHandler(AccessDeniedException.class)
    public ResponseEntity<?> handleException(AccessDeniedException exception){
        return AppError.responseUnauthorized(exception);
    }
}
