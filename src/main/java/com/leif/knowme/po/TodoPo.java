package com.leif.knowme.po;

public class TodoPo {
    String todoId;
    String userId;
    Integer planConsumed;
    Integer realConsumed;
    String eventMsg;
    int status;

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
