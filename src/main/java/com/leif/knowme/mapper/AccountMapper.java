package com.leif.knowme.mapper;

import com.leif.knowme.model.AccountDo;
import org.apache.ibatis.annotations.Select;

public interface AccountMapper {
    int createAccount(AccountDo account);

    AccountDo getAccountById(String accountId);

    AccountDo queryAccount(AccountDo accountDo);

    @Select("select 1 from t_account where account_no=#{accountNo}")
    boolean checkIsAccountNoExist(String accountNo);
}
