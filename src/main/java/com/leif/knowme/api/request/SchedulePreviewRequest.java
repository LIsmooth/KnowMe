package com.leif.knowme.api.request;

import java.util.Date;
import java.util.List;

/**
 * @author HelloLeif
 * @date 2020/8/30
 */
public class SchedulePreviewRequest {
    private Date planStartTime;
    private List<String> todoIds;

    public Date getPlanStartTime() {
        return planStartTime;
    }

    public void setPlanStartTime(Date planStartTime) {
        this.planStartTime = planStartTime;
    }

    public List<String> getTodoIds() {
        return todoIds;
    }

    public void setTodoIds(List<String> todoIds) {
        this.todoIds = todoIds;
    }
}
