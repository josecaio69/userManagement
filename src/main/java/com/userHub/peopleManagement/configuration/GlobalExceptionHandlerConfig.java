package com.userHub.peopleManagement.configuration;

import com.userHub.peopleManagement.Exception.PersonNotFoundException;
import com.userHub.peopleManagement.dto.ErrorResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import java.time.Instant;


@RestControllerAdvice
public class GlobalExceptionHandlerConfig {

    private static final String PERSON_NOT_FOUND = "PERSON_NOT_FOUND";

    @ExceptionHandler(PersonNotFoundException.class)
    public ResponseEntity<ErrorResponseDTO> handlePersonNotFoundException(
            PersonNotFoundException ex,
            WebRequest request) {

        ErrorResponseDTO error = new ErrorResponseDTO(
                HttpStatus.NOT_FOUND.value(),
                PERSON_NOT_FOUND,
                ex.getMessage(),
                Instant.now(),
                request.getDescription(false).replace("uri=", ""));

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }
}
