package com.leif.knowme.model;


import java.util.Date;

public class TodoDo {

    private long todoId;
    private int timeConsumed;
    private Date todoTime;
    private String eventMsg;
    private String userId;
    private Date created;


    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public long getTodoId() {
        return todoId;
    }

    public void setTodoId(long todoId) {
        this.todoId = todoId;
    }

    public int getTimeConsumed() {
        return timeConsumed;
    }

    public void setTimeConsumed(int timeConsumed) {
        this.timeConsumed = timeConsumed;
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

    @Override
    public String toString() {
        return "Todo{" +
                "todoId=" + todoId +
                ", timeConsumed=" + timeConsumed +
                ", todoTime=" + todoTime +
                ", eventMsg='" + eventMsg + '\'' +
                ", userId='" + userId + '\'' +
                ", created=" + created +
                '}';
    }
}
