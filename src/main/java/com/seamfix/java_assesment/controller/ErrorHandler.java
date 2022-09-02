package com.seamfix.java_assesment.controller;

import com.seamfix.java_assesment.constant.ResponseCodes;
import com.seamfix.java_assesment.exception.BadRequestException;
import com.seamfix.java_assesment.model.response.ApiErrorResponse;
import com.seamfix.java_assesment.util.CustomResponseCode;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ErrorHandler {

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<ApiErrorResponse> handleBadRequest(HttpServletRequest request, Exception exception){
        System.out.println("Exceptio :::::" +exception.getMessage().replace("bvn",""));
        System.out.println("KKKKK "+ exception.getMessage());
        ApiErrorResponse response = ApiErrorResponse
                .builder()
                .message(exception.getMessage())
                .code(ResponseCodes.resolveForResponseCode(exception.getMessage().replace("bvn","")).get().getCode())
                .build();
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }
}
