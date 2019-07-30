package com.app.spring.exception;

public class UserExistsInDatabaseException extends RuntimeException {

    public UserExistsInDatabaseException() {
        super("User already exists!");
    }
}
