package com.leif.knowme.service;

import com.leif.knowme.dto.AccountDto;
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

    public String createAccount(AccountDto accountDto) {
        return accountRepo.createAccount(accountDto);
    }

    public boolean checkIsAccountNoExist(String accountNo) {
        return accountRepo.checkIsAccountNoExist(accountNo);
    }
}
