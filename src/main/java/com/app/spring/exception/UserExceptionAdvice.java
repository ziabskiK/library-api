package com.app.spring.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class UserExceptionAdvice {

    @ResponseBody
    @ExceptionHandler(UserExistsInDatabaseException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    String userExistsInDb(UserExistsInDatabaseException e) {
        return e.getMessage();
    }

    @ResponseBody
    @ExceptionHandler(IncorrectRequestException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    String incorrectRequestException(IncorrectRequestException e) {
        return e.getMessage();
    }
}
