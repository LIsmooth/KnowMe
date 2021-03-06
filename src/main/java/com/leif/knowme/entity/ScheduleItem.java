package com.leif.knowme.entity;

import java.util.Date;

public class ScheduleItem {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_schedule_item.item_id
     *
     * @mbg.generated
     */
    private Long itemId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_schedule_item.schedule_id
     *
     * @mbg.generated
     */
    private String scheduleId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_schedule_item.todo_id
     *
     * @mbg.generated
     */
    private String todoId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_schedule_item.plan_start_time
     *
     * @mbg.generated
     */
    private Date planStartTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_schedule_item.real_start_time
     *
     * @mbg.generated
     */
    private Date realStartTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_schedule_item.plan_end_time
     *
     * @mbg.generated
     */
    private Date planEndTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_schedule_item.real_end_time
     *
     * @mbg.generated
     */
    private Date realEndTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_schedule_item.consumed
     *
     * @mbg.generated
     */
    private Integer consumed;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_schedule_item.order_no
     *
     * @mbg.generated
     */
    private Integer orderNo;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_schedule_item.status
     *
     * @mbg.generated
     */
    private Integer status;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_schedule_item.item_id
     *
     * @return the value of t_schedule_item.item_id
     *
     * @mbg.generated
     */
    public Long getItemId() {
        return itemId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_schedule_item.item_id
     *
     * @param itemId the value for t_schedule_item.item_id
     *
     * @mbg.generated
     */
    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_schedule_item.schedule_id
     *
     * @return the value of t_schedule_item.schedule_id
     *
     * @mbg.generated
     */
    public String getScheduleId() {
        return scheduleId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_schedule_item.schedule_id
     *
     * @param scheduleId the value for t_schedule_item.schedule_id
     *
     * @mbg.generated
     */
    public void setScheduleId(String scheduleId) {
        this.scheduleId = scheduleId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_schedule_item.todo_id
     *
     * @return the value of t_schedule_item.todo_id
     *
     * @mbg.generated
     */
    public String getTodoId() {
        return todoId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_schedule_item.todo_id
     *
     * @param todoId the value for t_schedule_item.todo_id
     *
     * @mbg.generated
     */
    public void setTodoId(String todoId) {
        this.todoId = todoId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_schedule_item.plan_start_time
     *
     * @return the value of t_schedule_item.plan_start_time
     *
     * @mbg.generated
     */
    public Date getPlanStartTime() {
        return planStartTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_schedule_item.plan_start_time
     *
     * @param planStartTime the value for t_schedule_item.plan_start_time
     *
     * @mbg.generated
     */
    public void setPlanStartTime(Date planStartTime) {
        this.planStartTime = planStartTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_schedule_item.real_start_time
     *
     * @return the value of t_schedule_item.real_start_time
     *
     * @mbg.generated
     */
    public Date getRealStartTime() {
        return realStartTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_schedule_item.real_start_time
     *
     * @param realStartTime the value for t_schedule_item.real_start_time
     *
     * @mbg.generated
     */
    public void setRealStartTime(Date realStartTime) {
        this.realStartTime = realStartTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_schedule_item.plan_end_time
     *
     * @return the value of t_schedule_item.plan_end_time
     *
     * @mbg.generated
     */
    public Date getPlanEndTime() {
        return planEndTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_schedule_item.plan_end_time
     *
     * @param planEndTime the value for t_schedule_item.plan_end_time
     *
     * @mbg.generated
     */
    public void setPlanEndTime(Date planEndTime) {
        this.planEndTime = planEndTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_schedule_item.real_end_time
     *
     * @return the value of t_schedule_item.real_end_time
     *
     * @mbg.generated
     */
    public Date getRealEndTime() {
        return realEndTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_schedule_item.real_end_time
     *
     * @param realEndTime the value for t_schedule_item.real_end_time
     *
     * @mbg.generated
     */
    public void setRealEndTime(Date realEndTime) {
        this.realEndTime = realEndTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_schedule_item.consumed
     *
     * @return the value of t_schedule_item.consumed
     *
     * @mbg.generated
     */
    public Integer getConsumed() {
        return consumed;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_schedule_item.consumed
     *
     * @param consumed the value for t_schedule_item.consumed
     *
     * @mbg.generated
     */
    public void setConsumed(Integer consumed) {
        this.consumed = consumed;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_schedule_item.order_no
     *
     * @return the value of t_schedule_item.order_no
     *
     * @mbg.generated
     */
    public Integer getOrderNo() {
        return orderNo;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_schedule_item.order_no
     *
     * @param orderNo the value for t_schedule_item.order_no
     *
     * @mbg.generated
     */
    public void setOrderNo(Integer orderNo) {
        this.orderNo = orderNo;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_schedule_item.status
     *
     * @return the value of t_schedule_item.status
     *
     * @mbg.generated
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_schedule_item.status
     *
     * @param status the value for t_schedule_item.status
     *
     * @mbg.generated
     */
    public void setStatus(Integer status) {
        this.status = status;
    }
}