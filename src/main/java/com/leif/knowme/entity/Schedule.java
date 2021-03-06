package com.leif.knowme.entity;

import java.util.Date;

public class Schedule {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_schedule.schedule_id
     *
     * @mbggenerated
     */
    private String scheduleId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_schedule.account_id
     *
     * @mbggenerated
     */
    private String accountId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_schedule.schedule_name
     *
     * @mbggenerated
     */
    private String scheduleName;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_schedule.schedule_note
     *
     * @mbggenerated
     */
    private String scheduleNote;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_schedule.summary_id
     *
     * @mbggenerated
     */
    private String summaryId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_schedule.status
     *
     * @mbggenerated
     */
    private Integer status;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_schedule.plan_start_time
     *
     * @mbggenerated
     */
    private Date planStartTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_schedule.real_start_time
     *
     * @mbggenerated
     */
    private Date realStartTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_schedule.plan_end_time
     *
     * @mbggenerated
     */
    private Date planEndTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_schedule.real_end_time
     *
     * @mbggenerated
     */
    private Date realEndTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_schedule.created
     *
     * @mbggenerated
     */
    private Date created;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_schedule.schedule_id
     *
     * @return the value of t_schedule.schedule_id
     *
     * @mbggenerated
     */
    public String getScheduleId() {
        return scheduleId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_schedule.schedule_id
     *
     * @param scheduleId the value for t_schedule.schedule_id
     *
     * @mbggenerated
     */
    public void setScheduleId(String scheduleId) {
        this.scheduleId = scheduleId == null ? null : scheduleId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_schedule.account_id
     *
     * @return the value of t_schedule.account_id
     *
     * @mbggenerated
     */
    public String getAccountId() {
        return accountId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_schedule.account_id
     *
     * @param accountId the value for t_schedule.account_id
     *
     * @mbggenerated
     */
    public void setAccountId(String accountId) {
        this.accountId = accountId == null ? null : accountId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_schedule.schedule_name
     *
     * @return the value of t_schedule.schedule_name
     *
     * @mbggenerated
     */
    public String getScheduleName() {
        return scheduleName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_schedule.schedule_name
     *
     * @param scheduleName the value for t_schedule.schedule_name
     *
     * @mbggenerated
     */
    public void setScheduleName(String scheduleName) {
        this.scheduleName = scheduleName == null ? null : scheduleName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_schedule.schedule_note
     *
     * @return the value of t_schedule.schedule_note
     *
     * @mbggenerated
     */
    public String getScheduleNote() {
        return scheduleNote;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_schedule.schedule_note
     *
     * @param scheduleNote the value for t_schedule.schedule_note
     *
     * @mbggenerated
     */
    public void setScheduleNote(String scheduleNote) {
        this.scheduleNote = scheduleNote == null ? null : scheduleNote.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_schedule.summary_id
     *
     * @return the value of t_schedule.summary_id
     *
     * @mbggenerated
     */
    public String getSummaryId() {
        return summaryId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_schedule.summary_id
     *
     * @param summaryId the value for t_schedule.summary_id
     *
     * @mbggenerated
     */
    public void setSummaryId(String summaryId) {
        this.summaryId = summaryId == null ? null : summaryId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_schedule.status
     *
     * @return the value of t_schedule.status
     *
     * @mbggenerated
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_schedule.status
     *
     * @param status the value for t_schedule.status
     *
     * @mbggenerated
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_schedule.plan_start_time
     *
     * @return the value of t_schedule.plan_start_time
     *
     * @mbggenerated
     */
    public Date getPlanStartTime() {
        return planStartTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_schedule.plan_start_time
     *
     * @param planStartTime the value for t_schedule.plan_start_time
     *
     * @mbggenerated
     */
    public void setPlanStartTime(Date planStartTime) {
        this.planStartTime = planStartTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_schedule.real_start_time
     *
     * @return the value of t_schedule.real_start_time
     *
     * @mbggenerated
     */
    public Date getRealStartTime() {
        return realStartTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_schedule.real_start_time
     *
     * @param realStartTime the value for t_schedule.real_start_time
     *
     * @mbggenerated
     */
    public void setRealStartTime(Date realStartTime) {
        this.realStartTime = realStartTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_schedule.plan_end_time
     *
     * @return the value of t_schedule.plan_end_time
     *
     * @mbggenerated
     */
    public Date getPlanEndTime() {
        return planEndTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_schedule.plan_end_time
     *
     * @param planEndTime the value for t_schedule.plan_end_time
     *
     * @mbggenerated
     */
    public void setPlanEndTime(Date planEndTime) {
        this.planEndTime = planEndTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_schedule.real_end_time
     *
     * @return the value of t_schedule.real_end_time
     *
     * @mbggenerated
     */
    public Date getRealEndTime() {
        return realEndTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_schedule.real_end_time
     *
     * @param realEndTime the value for t_schedule.real_end_time
     *
     * @mbggenerated
     */
    public void setRealEndTime(Date realEndTime) {
        this.realEndTime = realEndTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_schedule.created
     *
     * @return the value of t_schedule.created
     *
     * @mbggenerated
     */
    public Date getCreated() {
        return created;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_schedule.created
     *
     * @param created the value for t_schedule.created
     *
     * @mbggenerated
     */
    public void setCreated(Date created) {
        this.created = created;
    }
}