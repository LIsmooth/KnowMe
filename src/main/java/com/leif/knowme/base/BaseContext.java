package com.leif.knowme.base;

import com.leif.knowme.api.KmRequest;

public class BaseContext {
    String accountId;

    public BaseContext() {
    }

    public BaseContext(KmRequest<?> kmRequest) {
        this.accountId = kmRequest.getHeader().getAccountId();
    }

    public BaseContext(String accountId) {
        this.accountId = accountId;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }
}
