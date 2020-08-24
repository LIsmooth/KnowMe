package com.leif.knowme.po;

import com.leif.knowme.model.TodoDo;

import java.util.Calendar;
import java.util.Date;

public class ScheduleItemPo {
    private Long itemId;
    private String scheduleId;
    private String todoId;
    private Date planStartTime;
    private Date planEndTime;
    private Date realStartTime;
    private Date realEndTime;
    private Integer orderNo;
    private Integer status;

    public ScheduleItemPo() {
    }

    public ScheduleItemPo(String todoId, Date planStartTime, Date planEndTime, int orderNo) {
        this.todoId = todoId;
        this.planStartTime = planStartTime;
        this.planEndTime = planEndTime;
        this.orderNo = orderNo;
    }

    public Long getItemId() {
        return itemId;
    }

    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }

    public String getScheduleId() {
        return scheduleId;
    }

    public void setScheduleId(String scheduleId) {
        this.scheduleId = scheduleId;
    }

    public String getTodoId() {
        return todoId;
    }

    public void setTodoId(String todoId) {
        this.todoId = todoId;
    }

    public Date getPlanStartTime() {
        return planStartTime;
    }

    public void setPlanStartTime(Date planStartTime) {
        this.planStartTime = planStartTime;
    }

    public Date getPlanEndTime() {
        return planEndTime;
    }

    public void setPlanEndTime(Date planEndTime) {
        this.planEndTime = planEndTime;
    }

    public Date getRealStartTime() {
        return realStartTime;
    }

    public void setRealStartTime(Date realStartTime) {
        this.realStartTime = realStartTime;
    }

    public Date getRealEndTime() {
        return realEndTime;
    }

    public void setRealEndTime(Date realEndTime) {
        this.realEndTime = realEndTime;
    }

    public Integer getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(Integer orderNo) {
        this.orderNo = orderNo;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
