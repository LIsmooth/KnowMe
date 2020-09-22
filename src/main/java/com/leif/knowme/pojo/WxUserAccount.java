package com.leif.knowme.pojo;

/**
 * @author HelloLeif
 * @date 2020/9/22
 */
public class WxUserAccount {
    String openid;
    String sessionKey;
    String accountId;

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    public String getSessionKey() {
        return sessionKey;
    }

    public void setSessionKey(String sessionKey) {
        this.sessionKey = sessionKey;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public WxUserAccount() {
    }

    public WxUserAccount(String openid, String sessionKey, String accountId) {
        this.openid = openid;
        this.sessionKey = sessionKey;
        this.accountId = accountId;
    }
}
