package com.example.Allermi.global.exception;

public class EmailNotAuthenticatedException extends RuntimeException {
    public EmailNotAuthenticatedException() {
    }

    public EmailNotAuthenticatedException(String message) {
        super(message);
    }

    public EmailNotAuthenticatedException(String message, Throwable cause) {
        super(message, cause);
    }
}