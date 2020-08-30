package com.leif.knowme.service;

import com.leif.knowme.po.AccountPo;
import com.leif.knowme.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author HelloLeif
 * @date 2020/8/24
 */
@Service
public class AccountService {
    @Autowired
    AccountRepository accountRepo;

    public String createAccount(AccountPo accountPo) {
        return accountRepo.createAccount(accountPo);
    }

    public boolean checkIsAccountNoExist(String accountNo) {
        return accountRepo.checkIsAccountNoExist(accountNo);
    }
}
