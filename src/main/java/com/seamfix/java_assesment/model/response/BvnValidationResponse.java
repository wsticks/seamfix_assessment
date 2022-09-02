package com.seamfix.java_assesment.model.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BvnValidationResponse {

    private String message;
    private String code;
    private String bvn;
    private String imageDetail;
    private String basicDetail;



}
