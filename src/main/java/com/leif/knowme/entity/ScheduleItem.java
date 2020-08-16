package com.leif.knowme.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.leif.knowme.model.TodoDo;

import java.util.Calendar;
import java.util.Date;

public class ScheduleItem {
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    private Date beginTime;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    private Date endTime;
    private String itemNote;
    private int timeConsumed;

    public ScheduleItem(TodoDo todo, Calendar calendar) {
        this.beginTime=calendar.getTime();
        calendar.add(Calendar.MINUTE, todo.getTimeConsumed());
        this.endTime=calendar.getTime();
        this.itemNote=todo.getEventMsg();
        this.timeConsumed=todo.getTimeConsumed();
    }

    public int getTimeConsumed() {
        return timeConsumed;
    }

    public void setTimeConsumed(int timeConsumed) {
        this.timeConsumed = timeConsumed;
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
}
