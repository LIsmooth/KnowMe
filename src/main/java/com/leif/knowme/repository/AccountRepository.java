package com.leif.knowme.repository;

import com.leif.knowme.dao.AccountMapper;
import com.leif.knowme.entity.Account;
import com.leif.knowme.po.AccountPo;
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

    public String createAccount(AccountPo accountPo) {
        Account account = extractAccount(accountPo);
        account.setAccountId(UUIDUtils.generateUUID());
        account.setPassword(CryptUtil.cryptByMD5(account.getPassword()));
        accountMapper.insertSelective(account);
        return account.getAccountId();
    }

    private Account extractAccount(AccountPo accountPo) {
        Account account = new Account();
        BeanUtils.copyProperties(accountPo, account);
        return account;
    }

    public boolean checkIsAccountNoExist(String accountNo) {
        return accountMapper.checkIsAccountNoExist(accountNo);
    }
}
