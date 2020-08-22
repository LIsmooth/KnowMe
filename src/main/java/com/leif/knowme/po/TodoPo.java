package com.leif.knowme.po;

public class TodoPo {

    public static final int STATUS_CREATE = 0;
    public static final int STATUS_QUOTED = 20;
    public static final int STATUS_COMPLETE = 30;

    String todoId;
    String userId;
    Integer planConsumed;
    Integer realConsumed;
    String eventMsg;
    int status;

    public TodoPo() {
    }

    public TodoPo(String userId, Integer planConsumed, String eventMsg, int status) {
        this.userId = userId;
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

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
