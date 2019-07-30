package com.app.spring.exception;

public class IncorrectRequestException extends RuntimeException {
    public IncorrectRequestException() {
        super("Invalid email or password!");
    }
}
