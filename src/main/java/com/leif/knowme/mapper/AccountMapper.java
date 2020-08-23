package com.leif.knowme.mapper;

import com.leif.knowme.model.AccountDo;

public interface AccountMapper {
    int createAccount(AccountDo account);
    AccountDo getAccountById(String accountId);
}
