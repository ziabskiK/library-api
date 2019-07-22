package com.app.spring.exception;

public class BookNotFoundException extends RuntimeException {
    public BookNotFoundException(int id) {
        super("Could not find book with ID: " + id);
    }
}
