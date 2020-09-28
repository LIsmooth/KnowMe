package com.leif.knowme.api;


import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class KmResponse {

    public static final int KM_RESPONSE_CODE_SUCC = 0;
    public static final int KM_RESPONSE_CODE_ERR_SYSTEM = 100;
    public static final int KM_RESPONSE_CODE_ERR_TRANSFER = 1000;
    public static final int KM_RESPONSE_CODE_ERR_AUTH_EXPIRED = 2000;


    private int code;
    private Object data;
    private String errorMsg;
    private long timestamp;

    public KmResponse(Object body) {
        this.code = KM_RESPONSE_CODE_SUCC;
        this.data = body;
        this.timestamp = System.currentTimeMillis();
    }

    public KmResponse(int code, String errorMsg) {
        this.code = code;
        this.errorMsg = errorMsg;
        this.timestamp = System.currentTimeMillis();
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public String err2Json() {
        return String.format("{code:%d,errorMsg:'%s',timestamp:%d}", code, errorMsg, System.currentTimeMillis());
    }
}
