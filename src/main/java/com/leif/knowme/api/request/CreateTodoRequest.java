package com.leif.knowme.api.request;

/**
 * @author HelloLeif
 * @date 2020/8/30
 */
public class CreateTodoRequest {

    String accountId;
    Integer planConsumed;
    String eventMsg;

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public Integer getPlanConsumed() {
        return planConsumed;
    }

    public void setPlanConsumed(Integer planConsumed) {
        this.planConsumed = planConsumed;
    }

    public String getEventMsg() {
        return eventMsg;
    }

    public void setEventMsg(String eventMsg) {
        this.eventMsg = eventMsg;
    }
}
