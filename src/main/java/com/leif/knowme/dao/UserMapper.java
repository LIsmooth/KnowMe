package com.leif.knowme.dao;

import com.leif.knowme.entity.User;
import com.leif.knowme.entity.UserExample;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface UserMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_user
     *
     * @mbggenerated
     */
    int countByExample(UserExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_user
     *
     * @mbggenerated
     */
    int deleteByExample(UserExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_user
     *
     * @mbggenerated
     */
    @Delete({
        "delete from t_user",
        "where user_id = #{userId,jdbcType=VARCHAR}"
    })
    int deleteByPrimaryKey(String userId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_user
     *
     * @mbggenerated
     */
    @Insert({
        "insert into t_user (user_id, name, ",
        "birthday, gender)",
        "values (#{userId,jdbcType=VARCHAR}, #{name,jdbcType=VARCHAR}, ",
        "#{birthday,jdbcType=DATE}, #{gender,jdbcType=TINYINT})"
    })
    int insert(User record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_user
     *
     * @mbggenerated
     */
    int insertSelective(User record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_user
     *
     * @mbggenerated
     */
    List<User> selectByExample(UserExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_user
     *
     * @mbggenerated
     */
    @Select({
        "select",
        "user_id, name, birthday, gender",
        "from t_user",
        "where user_id = #{userId,jdbcType=VARCHAR}"
    })
    @ResultMap("BaseResultMap")
    User selectByPrimaryKey(String userId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_user
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") User record, @Param("example") UserExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_user
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") User record, @Param("example") UserExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_user
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(User record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_user
     *
     * @mbggenerated
     */
    @Update({
        "update t_user",
        "set name = #{name,jdbcType=VARCHAR},",
          "birthday = #{birthday,jdbcType=DATE},",
          "gender = #{gender,jdbcType=TINYINT}",
        "where user_id = #{userId,jdbcType=VARCHAR}"
    })
    int updateByPrimaryKey(User record);
}