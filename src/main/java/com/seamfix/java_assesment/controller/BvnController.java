package com.seamfix.java_assesment.controller;

import com.seamfix.java_assesment.model.request.BvnValidationRequest;
import com.seamfix.java_assesment.model.response.BvnValidationResponse;
import com.seamfix.java_assesment.service.BvnValidationService;
import com.seamfix.java_assesment.util.Constants;
import com.seamfix.java_assesment.util.InputValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping(Constants.APP_CONTENT+"svalidate")
public class BvnController {

    @Autowired
    private BvnValidationService service;

    @PostMapping("/wrapper")
    public BvnValidationResponse createProduct(
            @Valid @RequestBody BvnValidationRequest request,
            BindingResult bindingResult) throws Exception{
        InputValidator.validate(bindingResult);
        BvnValidationResponse response = service.validateBvn(request);
        return  response;
    }
}
