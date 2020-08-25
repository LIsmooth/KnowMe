package com.leif.knowme.base;

public class BaseContext {
    String accountId;

    public BaseContext() {
    }

    public BaseContext(KmRequest<?> kmRequest) {
        this.accountId = kmRequest.getHeader().getAccountId();
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }
}
