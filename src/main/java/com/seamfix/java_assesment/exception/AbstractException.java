package com.seamfix.java_assesment.exception;

public abstract class AbstractException extends RuntimeException{

    AbstractException(String message){
        super(message);
    }

    AbstractException(String message, Throwable cause){
        super(message, cause);
        if(this.getCause() == null && cause != null){
            this.initCause(cause);
        }
    }
}
