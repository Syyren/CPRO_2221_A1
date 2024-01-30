package com.mcgrandle.cpro2221_a1.utils;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

//Creating a handler that runs across the entire application
@ControllerAdvice
public class CustomExceptionHandler
{
    @ExceptionHandler(CustomException.class)
    public ResponseEntity<String> handleCustomException(CustomException exception)
    {
        String message = "Error " + exception.getMessage();
        return new ResponseEntity<>(message, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
