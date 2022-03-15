package com.ufcg.psoft.tccMatch.exception.controller;

import com.ufcg.psoft.tccMatch.dto.ErrorMessageDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class AppError {
    public static ResponseEntity<ErrorMessageDTO> responseBadRequest (RuntimeException exception) {
        return new ResponseEntity<>(
                new ErrorMessageDTO(exception.getMessage()),
                HttpStatus.BAD_REQUEST
        );
    }

    public static ResponseEntity<ErrorMessageDTO> responseNotFound (RuntimeException exception) {
        return new ResponseEntity<>(
                new ErrorMessageDTO(exception.getMessage()),
                HttpStatus.NOT_FOUND
        );
    }

    public static ResponseEntity<ErrorMessageDTO> responseUnauthorized (RuntimeException exception) {
        return new ResponseEntity<>(
                new ErrorMessageDTO(exception.getMessage()),
                HttpStatus.UNAUTHORIZED
        );
    }
}
