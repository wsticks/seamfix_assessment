package com.seamfix.java_assesment.exception;

public class BadRequestException extends AbstractException{

    public BadRequestException(String message){
        super(message);
    }

    public BadRequestException(String message, Throwable cause){
        super(message, cause);
    }
}
