package com.leif.knowme.api.response;


import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;
import java.util.List;

/**
 * @author HelloLeif
 * @date 2020/9/7
 */
public class ScheduleResponse {
    private String scheduleId;
    private String scheduleName;
    private String scheduleNote;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:00")
    private Date planStartTime;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:00")
    private Date planEndTime;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:00")
    private Date realStartTime;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:00")
    private Date realEndTime;
    private List<ScheduleItemVo> items;

    public ScheduleResponse() {
    }


    public static class ScheduleItemVo {
        private String itemId;
        private Date planStartTime;
        private Date planEndTime;
        private Date realStartTime;
        private Date realEndTime;
        private Integer orderNo;
        private Integer status;
        private Integer type;
        private Integer planConsumed;
        private Integer consumed;
        private String eventMsg;

        public String getItemId() {
            return itemId;
        }

        public void setItemId(String itemId) {
            this.itemId = itemId;
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

        public Integer getType() {
            return type;
        }

        public void setType(Integer type) {
            this.type = type;
        }

        public Integer getPlanConsumed() {
            return planConsumed;
        }

        public void setPlanConsumed(Integer planConsumed) {
            this.planConsumed = planConsumed;
        }

        public Integer getConsumed() {
            return consumed;
        }

        public void setConsumed(Integer consumed) {
            this.consumed = consumed;
        }

        public String getEventMsg() {
            return eventMsg;
        }

        public void setEventMsg(String eventMsg) {
            this.eventMsg = eventMsg;
        }
    }

    public String getScheduleId() {
        return scheduleId;
    }

    public void setScheduleId(String scheduleId) {
        this.scheduleId = scheduleId;
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

    public List<ScheduleItemVo> getItems() {
        return items;
    }

    public void setItems(List<ScheduleItemVo> items) {
        this.items = items;
    }
}
