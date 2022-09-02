package com.seamfix.java_assesment.model.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.wordnik.swagger.annotations.ApiModelProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Response {

    @ApiModelProperty(
            value = "",
            required = true
    )
    private String code;
    @ApiModelProperty(
            value = "",
            required = true
    )
    private String message;

    private Object data;

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

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
