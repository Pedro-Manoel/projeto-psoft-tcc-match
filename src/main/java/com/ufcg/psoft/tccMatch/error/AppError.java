package com.ufcg.psoft.tccMatch.error;

import com.ufcg.psoft.tccMatch.dto.message.ErrorMessageDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public abstract class AppError {
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

    public static ResponseEntity<ErrorMessageDTO> responseInternalServerError (RuntimeException exception) {
        return new ResponseEntity<>(
                new ErrorMessageDTO(exception.getMessage()),
                HttpStatus.INTERNAL_SERVER_ERROR
        );
    }
}
