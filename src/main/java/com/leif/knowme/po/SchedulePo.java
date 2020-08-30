package com.leif.knowme.po;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class SchedulePo {
    private String scheduleId;
    private String accountId;
    private String scheduleName;
    private String scheduleNote;
    private String summaryId;
    private Integer status;
    private Date planStartTime;
    private Date planEndTime;
    private Date realStartTime;
    private Date realEndTime;
    private Date created;
    private List<ScheduleItemPo> scheduleItemPos;

    public SchedulePo() {
    }

    public SchedulePo(String accountId, String scheduleName, String scheduleNote, Date planStartTime,
                      Date planEndTime) {
        this.accountId = accountId;
        this.scheduleName = scheduleName;
        this.scheduleNote = scheduleNote;
        this.planStartTime = planStartTime;
        this.planEndTime = planEndTime;
    }

    public List<ScheduleItemPo> getScheduleItemPos() {
        return scheduleItemPos;
    }

    public void setScheduleItemPos(List<ScheduleItemPo> scheduleItemPos) {
        this.scheduleItemPos = scheduleItemPos;
    }

    public String getScheduleNote() {
        return scheduleNote;
    }

    public void setScheduleNote(String scheduleNote) {
        this.scheduleNote = scheduleNote;
    }

    public String getScheduleId() {
        return scheduleId;
    }

    public void setScheduleId(String scheduleId) {
        this.scheduleId = scheduleId;
    }

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

    public String getSummaryId() {
        return summaryId;
    }

    public void setSummaryId(String summaryId) {
        this.summaryId = summaryId;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
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

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    @Override
    public String toString() {
        return "SchedulePo{" +
                "scheduleId='" + scheduleId + '\'' +
                ", accountId='" + accountId + '\'' +
                ", scheduleName='" + scheduleName + '\'' +
                ", scheduleNote='" + scheduleNote + '\'' +
                ", summaryId='" + summaryId + '\'' +
                ", status=" + status +
                ", planStartTime=" + planStartTime +
                ", planEndTime=" + planEndTime +
                ", realStartTime=" + realStartTime +
                ", realEndTime=" + realEndTime +
                ", created=" + created +
                ", scheduleItemPos=\n" + scheduleItemPos.stream().map(ScheduleItemPo::toString).collect(Collectors.joining("\n")) +
                '}';
    }
}
