package com.leif.knowme.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

public class Schedule {
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    Date beginTime;
    List<ScheduleItem> scheduleItems;

    @Override
    public String toString() {
        SimpleDateFormat format = new SimpleDateFormat("HH:mm");
        StringBuilder sb=new StringBuilder();
        sb.append("Begin at ").append(format.format(beginTime)).append("\n");
        for (ScheduleItem scheduleItem : scheduleItems) {
            sb.append("\t").append(format.format(scheduleItem.getBeginTime()))
                    .append("\t").append(scheduleItem.getItemNote()).append("\n");
        }
        return sb.append("Have a nice day!").toString();
    }

    public Date getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(Date beginTime) {
        this.beginTime = beginTime;
    }

    public List<ScheduleItem> getScheduleItems() {
        return scheduleItems;
    }

    public void setScheduleItems(List<ScheduleItem> scheduleItems) {
        this.scheduleItems = scheduleItems;
    }
}
