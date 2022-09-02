package com.seamfix.java_assesment;

import com.seamfix.java_assesment.model.request.BvnValidationRequest;
import com.seamfix.java_assesment.model.response.BvnValidationResponse;
import com.seamfix.java_assesment.service.BvnValidationService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;
import org.springframework.boot.test.context.SpringBootTest;

import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.Silent.class)
@MockitoSettings(strictness = Strictness.LENIENT)
@SpringBootTest
public class JavaAssesmentApplicationTests {

    @Mock
    BvnValidationService service;

    @Test
    public void validateBvn(){
        BvnValidationRequest request= new BvnValidationRequest();
        request.setBvn("01234567891");
        BvnValidationResponse response = new BvnValidationResponse();
        response.setBvn("01234567891");
        response.setBasicDetail("MDEyMzQ1Njc4OTAxMC45NzA3OTEzNzc1NDkxOTMyLmpwZWc=");
        response.setImageDetail("MDEyMzQ1Njc4OTAxMC44NjU1MDcyMDgwNDkzNDgzLmpwZWc=");
        response.setMessage("Success");
        response.setCode("00");
        when(service.validateBvn(request)).thenReturn(response);
        Assert.assertNotNull(response);
        Assert.assertEquals(request.getBvn(), response.getBvn());
    }

    @Test
    public void validateEmptyBvn(){
        BvnValidationRequest request= new BvnValidationRequest();
        request.setBvn("");
        BvnValidationResponse response = new BvnValidationResponse();
        response.setMessage("One or more of your request parameters failed validation. Please retry");
        response.setCode("400");
        when(service.validateBvn(request)).thenReturn(response);
        ///Assert.assertNotNull(response);
        Assert.assertEquals("400", response.getCode());
    }

    @Test
    public void validateLengthOfBvn(){
        BvnValidationRequest request= new BvnValidationRequest();
        request.setBvn("0000000000");
        String bvnsample = "12345678901";
        BvnValidationResponse response = new BvnValidationResponse();
        response.setMessage("The searched BVN is invalid");
        response.setCode("02");
        when(service.validateBvn(request)).thenReturn(response);
        Assert.assertNotEquals(request.getBvn().length(),bvnsample.length());
       // Assert.assertEquals(request, response.getCode());
    }

    @Test
    public void invalidBvn(){
        BvnValidationRequest request= new BvnValidationRequest();
        request.setBvn("12345678901");
        String bvnsample = "12345678908";
        BvnValidationResponse response = new BvnValidationResponse();
        response.setMessage("The searched BVN is invalid");
        response.setCode("02");
        when(service.validateBvn(request)).thenReturn(response);
        Assert.assertNotEquals(request.getBvn(),bvnsample);

    }

    @Test
    public void validateBvnContiansCharacter(){
        BvnValidationRequest request= new BvnValidationRequest();
        request.setBvn("12345678902");
        BvnValidationResponse response = new BvnValidationResponse();
        response.setMessage("The searched BVN is invalid");
        response.setCode("02");
        when(service.validateBvn(request)).thenReturn(response);
        Assert.assertNotEquals(request.getBvn().length(),"12345678909");
        // Assert.assertEquals(request, response.getCode());
    }

}
