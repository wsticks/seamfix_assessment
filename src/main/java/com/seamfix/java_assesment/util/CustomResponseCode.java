package com.seamfix.java_assesment.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

public class CustomResponseCode {


    public static final String BAD_REQUEST = "400";
    public static final String SUCCESS = "00";
    public static final String INVALID_DATA = "01";
    public static final String INVALID_DATA_LENGTH = "02";
    private static final Logger logger = LoggerFactory.getLogger(CustomResponseCode.class);
    private static final Map<String, String> httpCodes = new HashMap();

    public CustomResponseCode() {
    }

    public static String getMessage(String code) {
        String message = "Undefined";

        try {
            message = (String)httpCodes.get(code);
        } catch (Exception var3) {
            logger.error("Error in getMessage {} :", "cannot get message from code", var3);
        }

        return message;
    }

    @PostConstruct
    public void init() {

        httpCodes.put("400", "Bad Request");
        httpCodes.put("00", "Successful");
    }
}
