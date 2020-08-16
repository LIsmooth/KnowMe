package com.leif.knowme.mapper;

import com.leif.knowme.model.AccountDo;

public interface AccountMapper {
    AccountDo getAccountById(String accountId);
}
