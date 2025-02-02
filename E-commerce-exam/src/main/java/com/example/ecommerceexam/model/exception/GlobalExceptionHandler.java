package com.example.ecommerceexam.model.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(ApplicationException.class)
    ResponseEntity<String> handler(ApplicationException exception) {

        return ResponseEntity
                .status(exception.exc.status)
                .body(exception.exc.message);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    ResponseEntity<List<String>> handler(MethodArgumentNotValidException exception) {
        List<String> errors = exception.getBindingResult().getFieldErrors()
                .stream()
                .map(excp -> excp.getDefaultMessage() + " " + excp.getDefaultMessage())
                .toList();
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errors);
    }
}