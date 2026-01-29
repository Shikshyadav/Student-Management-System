package com.shi.studentmanagement.exception;

public class CsrfException extends RuntimeException {
    public CsrfException(String message) {
        super(message);
    }

    public CsrfException() {
        super("CSRF token validation failed");
    }
}
