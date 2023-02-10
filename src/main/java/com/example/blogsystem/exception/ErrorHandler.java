package com.example.blogsystem.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ErrorHandler {

    @ExceptionHandler(CustomException.class)
    public ResponseEntity<?>handleException(CustomException ex){
        return  new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_GATEWAY);
    }
    @ExceptionHandler()
    public ResponseEntity<?>handleException(Exception ex){
        return  new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_GATEWAY);
    }
}
