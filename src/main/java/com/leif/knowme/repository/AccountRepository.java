package com.leif.knowme.repository;

import com.leif.knowme.mapper.AccountMapper;
import com.leif.knowme.model.AccountDo;
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
        AccountDo accountDo = extractAccountDo(accountPo);
        accountDo.setAccountId(UUIDUtils.generateUUID());
        accountDo.setPassword(CryptUtil.cryptByMD5(accountDo.getPassword()));
        accountMapper.createAccount(accountDo);
        return accountDo.getAccountId();
    }

    public AccountPo queryAccount(AccountPo accountPo) {
        AccountDo accountDo = extractAccountDo(accountPo);
        accountDo=accountMapper.queryAccount(accountDo);
        BeanUtils.copyProperties(accountDo, accountPo);
        return accountPo;
    }

    private AccountDo extractAccountDo(AccountPo accountPo) {
        AccountDo accountDo = new AccountDo();
        BeanUtils.copyProperties(accountPo, accountDo);
        return accountDo;
    }

    public boolean checkIsAccountNoExist(String accountNo) {
        return accountMapper.checkIsAccountNoExist(accountNo);
    }
}
