package com.example;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value= HttpStatus.BAD_REQUEST)
public class ApiException extends RuntimeException {
    private final String key;
    private final Object[] args;

    public ApiException(String key, Object... args) {
        super(key);
        this.key = key;
        this.args = args;
    }

    public ApiException(String key, Throwable cause, Object... args) {
        super(key, cause);
        this.key = key;
        this.args = args;
    }

    public String getKey() {
        return key;
    }

    public Object[] getArgs() {
        return args;
    }
}