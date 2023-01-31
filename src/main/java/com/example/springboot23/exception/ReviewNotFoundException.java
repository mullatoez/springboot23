package com.example.springboot23.exception;

public class ReviewNotFoundException extends RuntimeException {

    public static final long serialVersionUID = 2;

    public ReviewNotFoundException(String message) {
        super(message);
    }
}
