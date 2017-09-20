package com.example;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value= HttpStatus.NOT_FOUND)
public class NotFoundException extends ApiException {

    public NotFoundException(String message, Object... args) {
        super(message, args);
    }

    public NotFoundException(String message, Throwable cause, Object... args) {
        super(message, cause, args);
    }
}