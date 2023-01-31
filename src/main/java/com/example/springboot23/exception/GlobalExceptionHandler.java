package com.example.springboot23.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.util.Date;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(PokemonNotFoundException.class)
    public ResponseEntity<ErrorObject> handlePokemonNotFoundException(
            PokemonNotFoundException ex, WebRequest request
    ) {

        ErrorObject object = new ErrorObject();
        object.setStatusCode(HttpStatus.NOT_FOUND.value());
        object.setMessage(ex.getMessage());
        object.setTimeStamp(new Date());

        return new ResponseEntity<>(object, HttpStatus.NOT_FOUND);

    }
}
