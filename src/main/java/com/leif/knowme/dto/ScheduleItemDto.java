package com.leif.knowme.dto;


import java.util.Date;

public class ScheduleItemDto {
    private Long itemId;
    private String scheduleId;
    private TodoDto todoDto;
    private Date planStartTime;
    private Date planEndTime;
    private Date realStartTime;
    private Date realEndTime;
    private Integer orderNo;
    private Integer status;

    public ScheduleItemDto() {
    }

    public ScheduleItemDto(TodoDto todoDto, Date planStartTime, Date planEndTime, int orderNo) {
        this.todoDto = todoDto;
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

    public TodoDto getTodoDto() {
        return todoDto;
    }

    public void setTodoDto(TodoDto todoDto) {
        this.todoDto = todoDto;
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

    @Override
    public String toString() {
        return planStartTime + "\t" + todoDto.getEventMsg() + "\t" + planEndTime;
    }
}
