package com.seamfix.java_assesment.model.request;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
public class BvnValidationRequest {

    @NotEmpty(message = "One or more of your request parameters failed validation. please retry.")
    //@NotNull(message = "One or more of your request parameters failed validation. please retry.")
    //@Size(min = 11, max = 11, message = "The searched BVN is invalid.")
    private String bvn;

}
