package com.leif.knowme.repository;

import com.leif.knowme.dao.AccountMapper;
import com.leif.knowme.entity.Account;
import com.leif.knowme.dto.AccountDto;
import com.leif.knowme.util.CryptUtil;
import com.leif.knowme.util.UUIDUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * @author HelloLeif
 * @date 2020/8/24
 */
@Repository
public class AccountRepository {
    @Autowired
    AccountMapper accountMapper;

    public AccountDto createAccount(AccountDto accountDto) {
        Account account = extractAccount(accountDto);
        account.setAccountId(UUIDUtils.generateUUID());
        account.setPassword(CryptUtil.cryptByMD5(account.getPassword()));
        accountMapper.insertSelective(account);
        return convertToAccountDTO(account);
    }

    private AccountDto convertToAccountDTO(Account account) {
        AccountDto accountDto=new AccountDto();
        BeanUtils.copyProperties(account,accountDto,"created");
        return accountDto;
    }

    private Account extractAccount(AccountDto accountDto) {
        Account account = new Account();
        BeanUtils.copyProperties(accountDto, account);
        return account;
    }

    public boolean checkIsAccountNoExist(String accountNo) {
        return accountMapper.checkIsAccountNoExist(accountNo);
    }
}
