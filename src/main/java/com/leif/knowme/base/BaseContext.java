package com.leif.knowme.base;

import com.leif.knowme.po.SchedulePo;

public class BaseContext {
    String accountId;



    public BaseContext(KmRequest<SchedulePo> kmRequest) {
        this.accountId = kmRequest.getHeader().getAccountId();
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }
}
