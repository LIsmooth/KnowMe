package com.leif.knowme.api.request;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;
import java.util.List;

public class CreateScheduleRequest {
    private String accountId;
    private String scheduleName;
    private String scheduleNote;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date planStartTime;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date planEndTime;
    private List<String> todoIds;

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public String getScheduleName() {
        return scheduleName;
    }

    public void setScheduleName(String scheduleName) {
        this.scheduleName = scheduleName;
    }

    public String getScheduleNote() {
        return scheduleNote;
    }

    public void setScheduleNote(String scheduleNote) {
        this.scheduleNote = scheduleNote;
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

    public List<String> getTodoIds() {
        return todoIds;
    }

    public void setTodoIds(List<String> todoIds) {
        this.todoIds = todoIds;
    }
}
