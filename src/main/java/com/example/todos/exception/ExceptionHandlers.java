package com.example.todos.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.server.ResponseStatusException;

@ControllerAdvice
public class ExceptionHandlers {

    @ExceptionHandler(ResponseStatusException.class)
    public ResponseEntity<ExceptionResponse> handleExceptionn(ResponseStatusException exc){
        return buildResponseEntity(exc, HttpStatus.valueOf(exc.getStatusCode().value()));
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ExceptionResponse> handleExceptionn(Exception exc){
        return buildResponseEntity(exc, HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<ExceptionResponse> buildResponseEntity(Exception exc, HttpStatus status){
        ExceptionResponse error = new ExceptionResponse();
        error.setStatus(status.value());
        error.setMessage(exc.getMessage());
        error.setTimestamp(System.currentTimeMillis());
        return new ResponseEntity<>(error, status);
    }
}
