package com.leif.knowme.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.leif.knowme.model.TodoDo;

import java.util.Calendar;
import java.util.Date;

public class ScheduleItem {
    String todoId;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    private Date beginTime;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    private Date endTime;
    private String itemNote;
    private Integer planConsumed;

    public ScheduleItem(TodoDo todo, Calendar calendar) {
        this.todoId = todo.getTodoId();
        this.beginTime = calendar.getTime();
        calendar.add(Calendar.MINUTE, todo.getPlanConsumed());
        this.endTime = calendar.getTime();
        this.itemNote = todo.getEventMsg();
        this.planConsumed = todo.getPlanConsumed();
    }

    @Override
    public String toString() {
        return "SecheduleItem{" +
                "beginTime=" + beginTime +
                ", endTime=" + endTime +
                ", itemNote='" + itemNote + '\'' +
                '}';
    }

    public Date getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(Date beginTime) {
        this.beginTime = beginTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public String getItemNote() {
        return itemNote;
    }

    public void setItemNote(String itemNote) {
        this.itemNote = itemNote;
    }

    public Integer getPlanConsumed() {
        return planConsumed;
    }

    public void setPlanConsumed(Integer planConsumed) {
        this.planConsumed = planConsumed;
    }

    public String getTodoId() {
        return todoId;
    }

    public void setTodoId(String todoId) {
        this.todoId = todoId;
    }
}
