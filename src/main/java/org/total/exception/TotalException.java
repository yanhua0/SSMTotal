package org.total.exception;

public class TotalException extends RuntimeException {
    public TotalException() {
    }

    public TotalException(String message) {
        super(message);
    }

    public TotalException(String message, Throwable cause) {
        super(message, cause);
    }
}
