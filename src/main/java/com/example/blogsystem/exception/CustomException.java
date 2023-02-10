package com.example.blogsystem.exception;

import org.springframework.web.bind.annotation.RestControllerAdvice;


public class CustomException extends Exception{
    private String message;
    public CustomException(String msg){
        super(msg);
    }

}
