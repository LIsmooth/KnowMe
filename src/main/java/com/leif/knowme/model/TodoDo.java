package com.leif.knowme.model;


import java.util.Date;

public class TodoDo {

    private Long todoId;
    private Integer planConsumed;
    private Integer realConsumed;
    private Integer type;
    private Date todoTime;
    private String eventMsg;
    private String userId;
    private Date created;

    public Long getTodoId() {
        return todoId;
    }

    public void setTodoId(Long todoId) {
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

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Date getTodoTime() {
        return todoTime;
    }

    public void setTodoTime(Date todoTime) {
        this.todoTime = todoTime;
    }

    public String getEventMsg() {
        return eventMsg;
    }

    public void setEventMsg(String eventMsg) {
        this.eventMsg = eventMsg;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    @Override
    public String toString() {
        return "Todo{" +
                "todoId=" + todoId +
                ", planConsumed=" + planConsumed +
                ", todoTime=" + todoTime +
                ", eventMsg='" + eventMsg + '\'' +
                ", userId='" + userId + '\'' +
                ", created=" + created +
                '}';
    }
}
