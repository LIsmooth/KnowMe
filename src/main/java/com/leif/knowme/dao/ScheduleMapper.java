package com.leif.knowme.dao;

import com.leif.knowme.dto.ScheduleDto;
import com.leif.knowme.entity.Schedule;
import com.leif.knowme.entity.ScheduleExample;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface ScheduleMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_schedule
     *
     * @mbggenerated
     */
    int countByExample(ScheduleExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_schedule
     *
     * @mbggenerated
     */
    int deleteByExample(ScheduleExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_schedule
     *
     * @mbggenerated
     */
    @Delete({
        "delete from t_schedule",
        "where schedule_id = #{scheduleId,jdbcType=VARCHAR}"
    })
    int deleteByPrimaryKey(String scheduleId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_schedule
     *
     * @mbggenerated
     */
    @Insert({
        "insert into t_schedule (schedule_id, account_id, ",
        "schedule_name, schedule_note, ",
        "summary_id, status, ",
        "plan_start_time, real_start_time, ",
        "plan_end_time, real_end_time, ",
        "created)",
        "values (#{scheduleId,jdbcType=VARCHAR}, #{accountId,jdbcType=VARCHAR}, ",
        "#{scheduleName,jdbcType=VARCHAR}, #{scheduleNote,jdbcType=VARCHAR}, ",
        "#{summaryId,jdbcType=VARCHAR}, #{status,jdbcType=INTEGER}, ",
        "#{planStartTime,jdbcType=TIMESTAMP}, #{realStartTime,jdbcType=TIMESTAMP}, ",
        "#{planEndTime,jdbcType=TIMESTAMP}, #{realEndTime,jdbcType=TIMESTAMP}, ",
        "#{created,jdbcType=TIMESTAMP})"
    })
    int insert(Schedule record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_schedule
     *
     * @mbggenerated
     */
    int insertSelective(Schedule record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_schedule
     *
     * @mbggenerated
     */
    List<Schedule> selectByExample(ScheduleExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_schedule
     *
     * @mbggenerated
     */
    @Select({
        "select",
        "schedule_id, account_id, schedule_name, schedule_note, summary_id, status, plan_start_time, ",
        "real_start_time, plan_end_time, real_end_time, created",
        "from t_schedule",
        "where schedule_id = #{scheduleId,jdbcType=VARCHAR}"
    })
    @ResultMap("BaseResultMap")
    Schedule selectByPrimaryKey(String scheduleId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_schedule
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") Schedule record, @Param("example") ScheduleExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_schedule
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") Schedule record, @Param("example") ScheduleExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_schedule
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(Schedule record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_schedule
     *
     * @mbggenerated
     */
    @Update({
        "update t_schedule",
        "set account_id = #{accountId,jdbcType=VARCHAR},",
          "schedule_name = #{scheduleName,jdbcType=VARCHAR},",
          "schedule_note = #{scheduleNote,jdbcType=VARCHAR},",
          "summary_id = #{summaryId,jdbcType=VARCHAR},",
          "status = #{status,jdbcType=INTEGER},",
          "plan_start_time = #{planStartTime,jdbcType=TIMESTAMP},",
          "real_start_time = #{realStartTime,jdbcType=TIMESTAMP},",
          "plan_end_time = #{planEndTime,jdbcType=TIMESTAMP},",
          "real_end_time = #{realEndTime,jdbcType=TIMESTAMP},",
          "created = #{created,jdbcType=TIMESTAMP}",
        "where schedule_id = #{scheduleId,jdbcType=VARCHAR}"
    })
    int updateByPrimaryKey(Schedule record);

    ScheduleDto getLatestSchedule(String accountId);
}