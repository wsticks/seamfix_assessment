package com.seamfix.java_assesment.service;

import com.seamfix.java_assesment.model.request.BvnValidationRequest;
import com.seamfix.java_assesment.model.response.BvnValidationResponse;
import com.seamfix.java_assesment.util.CustomResponseCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.apache.commons.codec.binary.Base64;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

@Service
@Slf4j
public class BvnValidationService {

    @Value("image")
    String imagePath;

  private static final Set<String> savedBin = new HashSet<>(Arrays.asList("12345678901","09876234512","23451890345"));

    public BvnValidationResponse validateBvn(BvnValidationRequest request){
        log.info("saved bin XXXXX :" + savedBin);
        System.out.println("saved bin XXXXX :" + savedBin);
        BvnValidationResponse response = new BvnValidationResponse();
        boolean validData = request.getBvn().matches("[0-9]+");
        if (request.getBvn() == "" || request.getBvn() == null){
            response.setMessage(
                    "One or more of your request parameter failed validation. Please retry");
            response.setCode(CustomResponseCode.BAD_REQUEST);
        }  else
        if(validData != true){
            response.setMessage("The searched BVN is invalid");
            response.setCode(CustomResponseCode.BAD_REQUEST);
            response.setBvn(request.getBvn());
        } else
         if(request.getBvn().length() < 11){
            response.setMessage("The searched BVN is invalid");
            response.setCode(CustomResponseCode.INVALID_DATA_LENGTH);
            response.setBvn(request.getBvn());
        }else
         if (!savedBin.contains(request.getBvn())){
             System.out.println("saved bin :" + savedBin);
             response.setMessage(
                     "The searched BVN does not exist");
             response.setCode(CustomResponseCode.INVALID_DATA);
         }
         else {
             String images = null;
             String basicDetails = null;

             File f1 = new File("/Users/olumuyiwa/IdeaProjects/java_assesment/src/main/java/com/seamfix/java_assesment/image/ales-nesetril-Im7lZjxeLhg-unsplash.jpg");
             File f2 = new File("/Users/olumuyiwa/IdeaProjects/java_assesment/src/main/java/com/seamfix/java_assesment/image/boitumelo-phetla-0lnx5Sc0_40-unsplash.jpg");
             String encodstring = encodeFileToBase64Binary(f1);
             String encodstring2 = encodeFileToBase64Binary(f2);
             String image = encodstring;
             String details = encodstring2;
             response.setImageDetail(image);
             response.setBasicDetail(details);
             response.setMessage("Success");
             response.setCode(CustomResponseCode.SUCCESS);
             response.setBvn(request.getBvn());
         }
        return  response;
    }

//    public String imageEncoder( String request){
//        System.out.println("request coming "+ request);
////        String  image = request.getBvn()+Math.random()+".jpeg";
//        String encodedString = Base64.getEncoder().encodeToString(request.getBytes());
//        return encodedString;
//    }

    private static String encodeFileToBase64Binary(File file) {
        String encodedfile = null;
        try {
            FileInputStream fileInputStreamReader = new FileInputStream(file);
            byte[] bytes = new byte[(int) file.length()];
            fileInputStreamReader.read(bytes);
            encodedfile = new String(Base64.encodeBase64(bytes), "UTF-8");
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return encodedfile;
    }
}
