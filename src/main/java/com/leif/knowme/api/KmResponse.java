package com.leif.knowme.api;


import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class KmResponse {

    public static final int KM_RESPONSE_CODE_SUCC = 0;
    public static final int KM_RESPONSE_CODE_SYSTEM_ERR = 5000;
    public static final int KM_RESPONSE_CODE_TRANSFER_ERR = 10000;


    private int code;
    private Object data;
    private String errorMsg;
    private long timestamp;

    public KmResponse(Object body) {
        this.code = KM_RESPONSE_CODE_SUCC;
        this.data = body;
        this.timestamp = System.currentTimeMillis();
    }

    public static String buildErrorResponse(int code, String message) {
        return String.format("{code:%d,errorMsg:'%s',timestamp:%d}", code, message, System.currentTimeMillis());
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

    @Override
    public String toString() {
        return "KmResponse{" +
                "code=" + code +
                ", data=" + data +
                ", errorMsg='" + errorMsg + '\'' +
                ", timestamp=" + timestamp +
                '}';
    }
}
