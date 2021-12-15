package org.stephane.in.config;

import lombok.Builder;
import lombok.Getter;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;


public class MsgError {
    private int statusCode;
    private Date timestamp;
    private String message;
    @Getter
    private Map<String,String> descriptions = new HashMap<>();

    @Builder
    private static MsgError of(int statusCode, Date timestamp, String message) {
        MsgError msgError =new MsgError();
        msgError.statusCode = statusCode;
        msgError.timestamp = timestamp;
        msgError.message = message;
        return msgError;
    }
}
