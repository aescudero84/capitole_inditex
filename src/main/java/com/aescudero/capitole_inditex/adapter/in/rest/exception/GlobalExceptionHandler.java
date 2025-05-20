package com.aescudero.capitole_inditex.adapter.in.rest.exception;

import org.springframework.core.convert.ConversionFailedException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<String> handleMethodArgumentNotValid(MethodArgumentNotValidException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body("Bad Request: " + ex.getMessage());
    }

    @ExceptionHandler(ConversionFailedException.class)
    public ResponseEntity<String> handleConversionFailed(ConversionFailedException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body("Bad Request: Invalid date format. Expected ISO_DATE_TIME (e.g., 2020-07-01T10:00:00)");
    }

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<String> handleNotFound(NotFoundException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("Not Found: " + ex.getMessage());
    }
}
