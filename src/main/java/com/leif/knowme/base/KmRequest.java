package com.leif.knowme.base;

/**
 * @author HelloLeif
 * @date 2020-08-23
 */
public class KmRequest<T> {
    private KmHeader header;
    private T data;

    public KmHeader getHeader() {
        return header;
    }

    public void setHeader(KmHeader header) {
        this.header = header;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
