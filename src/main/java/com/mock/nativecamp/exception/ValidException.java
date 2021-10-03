package com.mock.nativecamp.exception;

import org.springframework.validation.Errors;

public class ValidException extends RuntimeException {

    private Errors errors;

    public ValidException(String message, Errors errors) {
        super(message);
        this.errors = errors;
    }

}
