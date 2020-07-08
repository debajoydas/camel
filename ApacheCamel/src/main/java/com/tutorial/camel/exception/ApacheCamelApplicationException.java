package com.tutorial.camel.exception;

public class ApacheCamelApplicationException extends Exception {
    String message;
    public ApacheCamelApplicationException(String message) {
        this.message=message;
    }
    @Override
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
}
