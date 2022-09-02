package com.seamfix.java_assesment.constant;

import java.util.Objects;
import java.util.Optional;

public enum ResponseCodes {

    INVALID_BVN_LENGTH("The searched BVN is invalid.", "02"),
    EMPTY_BVN("One or more of your request parameters failed validation. please retry.", "400");

    private String code;
    private String message;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    ResponseCodes(String message,String code) {
        this.code = code;
        this.message = message;
    }

    public static Optional<ResponseCodes> resolveForResponseCode(String message) {
        for (ResponseCodes value : ResponseCodes.values()) {
            System.out.println("First :::" + message);
            String newString = value.getMessage().trim();
            String secondString = message.replace(";","").trim();
            if (secondString.equals(newString)) {
                return Optional.of(value);
            }
        }
        return Optional.empty();
    }
}
