package com.leif.knowme.dto;

public class TodoDto {

    public static final int STATUS_DELETED = -10;
    public static final int STATUS_CREATE = 0;
    public static final int STATUS_QUOTED = 20;
    public static final int STATUS_COMPLETE = 50;

    String todoId;
    String accountId;
    Integer planConsumed;
    Integer realConsumed;
    String eventMsg;
    Integer status;

    public TodoDto() {
    }

    public TodoDto(String accountId, Integer planConsumed, String eventMsg, int status) {
        this.accountId = accountId;
        this.planConsumed = planConsumed;
        this.eventMsg = eventMsg;
        this.status = status;
    }

    public String getTodoId() {
        return todoId;
    }

    public void setTodoId(String todoId) {
        this.todoId = todoId;
    }

    public Integer getPlanConsumed() {
        return planConsumed;
    }

    public void setPlanConsumed(Integer planConsumed) {
        this.planConsumed = planConsumed;
    }

    public Integer getRealConsumed() {
        return realConsumed;
    }

    public void setRealConsumed(Integer realConsumed) {
        this.realConsumed = realConsumed;
    }

    public String getEventMsg() {
        return eventMsg;
    }

    public void setEventMsg(String eventMsg) {
        this.eventMsg = eventMsg;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }
}
