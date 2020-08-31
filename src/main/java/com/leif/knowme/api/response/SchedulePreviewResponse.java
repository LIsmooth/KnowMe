package com.leif.knowme.api.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.leif.knowme.dto.ScheduleItemDto;
import com.leif.knowme.dto.ScheduleDto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author HelloLeif
 * @date 2020/8/30
 */
public class SchedulePreviewResponse {
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date planStartTime;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date planEndTime;

    private List<PreviewTodo> todos;

    public SchedulePreviewResponse(ScheduleDto scheduleDto) {
        this.setPlanStartTime(scheduleDto.getPlanStartTime());
        this.setPlanEndTime(scheduleDto.getPlanEndTime());
        List<SchedulePreviewResponse.PreviewTodo> todos = new ArrayList<>(scheduleDto.getScheduleItemDtos().size());
        for (ScheduleItemDto itemPo : scheduleDto.getScheduleItemDtos()) {
            SchedulePreviewResponse.PreviewTodo todo = new SchedulePreviewResponse.PreviewTodo();
            todo.setEventMsg(itemPo.getTodoDto().getEventMsg());
            todo.setOrderNo(itemPo.getOrderNo());
            todo.setPlanConsumed(itemPo.getTodoDto().getPlanConsumed());
            todo.setPlanStartTime(itemPo.getPlanStartTime());
            todo.setPlanEndTime(itemPo.getPlanEndTime());
            todo.setTodoId(itemPo.getTodoDto().getTodoId());
            todos.add(todo);
        }
        this.setTodos(todos);
    }

    public static class PreviewTodo {
        String todoId;
        String eventMsg;
        Integer planConsumed;
        Integer orderNo;
        @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
        Date planStartTime;
        @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
        Date planEndTime;

        public String getTodoId() {
            return todoId;
        }

        public void setTodoId(String todoId) {
            this.todoId = todoId;
        }

        public String getEventMsg() {
            return eventMsg;
        }

        public void setEventMsg(String eventMsg) {
            this.eventMsg = eventMsg;
        }

        public Integer getPlanConsumed() {
            return planConsumed;
        }

        public void setPlanConsumed(Integer planConsumed) {
            this.planConsumed = planConsumed;
        }

        public Integer getOrderNo() {
            return orderNo;
        }

        public void setOrderNo(Integer orderNo) {
            this.orderNo = orderNo;
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

    public List<PreviewTodo> getTodos() {
        return todos;
    }

    public void setTodos(List<PreviewTodo> todos) {
        this.todos = todos;
    }
}
