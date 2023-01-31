package com.example.springboot23.exception;

public class PokemonNotFoundException extends RuntimeException {

    public static final long serialVersionUID = 1;

    public PokemonNotFoundException(String message) {
        super(message);
    }
}
