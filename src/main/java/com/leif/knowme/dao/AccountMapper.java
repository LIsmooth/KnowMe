package com.leif.knowme.dao;

import com.leif.knowme.entity.Account;
import com.leif.knowme.entity.AccountExample;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface AccountMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_account
     *
     * @mbggenerated
     */
    int countByExample(AccountExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_account
     *
     * @mbggenerated
     */
    int deleteByExample(AccountExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_account
     *
     * @mbggenerated
     */
    @Delete({
            "delete from t_account",
            "where account_id = #{accountId,jdbcType=VARCHAR}"
    })
    int deleteByPrimaryKey(String accountId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_account
     *
     * @mbggenerated
     */
    @Insert({
            "insert into t_account (account_id, account_no, ",
            "account_name, `password`, ",
            "user_id, wx_open_id, ",
            "`status`, created)",
            "values (#{accountId,jdbcType=VARCHAR}, #{accountNo,jdbcType=VARCHAR}, ",
            "#{accountName,jdbcType=VARCHAR}, #{password,jdbcType=VARCHAR}, ",
            "#{userId,jdbcType=VARCHAR}, #{wxOpenId,jdbcType=VARCHAR}, ",
            "#{status,jdbcType=INTEGER}, #{created,jdbcType=TIMESTAMP})"
    })
    int insert(Account record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_account
     *
     * @mbggenerated
     */
    int insertSelective(Account record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_account
     *
     * @mbggenerated
     */
    List<Account> selectByExample(AccountExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_account
     *
     * @mbggenerated
     */
    @Select({
            "select",
            "account_id, account_no, account_name, `password`, user_id, wx_open_id, `status`, ",
            "created",
            "from t_account",
            "where account_id = #{accountId,jdbcType=VARCHAR}"
    })
    @ResultMap("BaseResultMap")
    Account selectByPrimaryKey(String accountId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_account
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") Account record, @Param("example") AccountExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_account
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") Account record, @Param("example") AccountExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_account
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(Account record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_account
     *
     * @mbggenerated
     */
    @Update({
            "update t_account",
            "set account_no = #{accountNo,jdbcType=VARCHAR},",
            "account_name = #{accountName,jdbcType=VARCHAR},",
            "`password` = #{password,jdbcType=VARCHAR},",
            "user_id = #{userId,jdbcType=VARCHAR},",
            "wx_open_id = #{wxOpenId,jdbcType=VARCHAR},",
            "`status` = #{status,jdbcType=INTEGER},",
            "created = #{created,jdbcType=TIMESTAMP}",
            "where account_id = #{accountId,jdbcType=VARCHAR}"
    })
    int updateByPrimaryKey(Account record);

    @Select("select account_id from t_account where account_no = #{accountNo}")
    String getAccountIdByAccountNo(String accountNo);
}