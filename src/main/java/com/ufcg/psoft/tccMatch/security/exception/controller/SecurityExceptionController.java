package com.ufcg.psoft.tccMatch.security.exception.controller;

import com.ufcg.psoft.tccMatch.exception.controller.AppError;
import com.ufcg.psoft.tccMatch.security.exception.LoginInvalidoException;
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
