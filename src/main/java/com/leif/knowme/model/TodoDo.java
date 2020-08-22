package com.leif.knowme.model;


import java.util.Date;

public class TodoDo {

    private String todoId;
    private String userId;
    private Integer type;
    private Integer planConsumed;
    private Integer realConsumed;
    private String eventMsg;
    private Integer status;
    private Date created;

    public String getTodoId() {
        return todoId;
    }

    public void setTodoId(String todoId) {
        this.todoId = todoId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
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

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    @Override
    public String toString() {
        return "TodoDo{" +
                "todoId=" + todoId +
                ", userId='" + userId + '\'' +
                ", type=" + type +
                ", planConsumed=" + planConsumed +
                ", realConsumed=" + realConsumed +
                ", eventMsg='" + eventMsg + '\'' +
                ", status=" + status +
                ", created=" + created +
                '}';
    }
}
