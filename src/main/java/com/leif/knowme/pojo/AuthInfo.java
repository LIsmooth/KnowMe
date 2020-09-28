package com.leif.knowme.pojo;

public class AuthInfo {
    private String token;
    private Long expiration;

    public AuthInfo(String token, Long expiration) {
        this.token = token;
        this.expiration = expiration;
    }

    public Long getExpiration() {
        return expiration;
    }

    public void setExpiration(Long expiration) {
        this.expiration = expiration;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
