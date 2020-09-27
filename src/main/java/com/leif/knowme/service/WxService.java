package com.leif.knowme.service;

import com.leif.knowme.dto.AccountDto;
import com.leif.knowme.exception.AppException;
import com.leif.knowme.outer.WechatApi;
import com.leif.knowme.outer.response.WxLoginRes;
import com.leif.knowme.pojo.WxUserAccount;
import com.leif.knowme.repository.AccountRepository;
import com.leif.knowme.repository.WxRepository;
import com.leif.knowme.util.UUIDUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class WxService {
    @Autowired
    WechatApi wechatApi;
    @Autowired
    WxRepository wxRepository;
    @Autowired
    AccountRepository accountRepository;

    @Transactional(rollbackFor = Exception.class)
    public WxUserAccount wxLogin(String code) throws AppException {
        WxLoginRes wxLoginInfo = wechatApi.login(code);
        String accountId = accountRepository.getAccountIdByAccountNo(wxLoginInfo.getOpenid());
        if(accountId==null) {
            wxRepository.saveLogin(wxLoginInfo);
            accountId = createAccountByWxLogin(wxLoginInfo);
        }
        return new WxUserAccount(wxLoginInfo.getOpenid(), wxLoginInfo.getSessionKey(), accountId);
    }

    private String createAccountByWxLogin(WxLoginRes wxLoginInfo) {
        AccountDto accountDto = new AccountDto();
        accountDto.setAccountName(UUIDUtils.generateUUID().substring(5));
        accountDto.setAccountNo(wxLoginInfo.getOpenid());
        return accountRepository.createAccount(accountDto).getAccountId();
    }
}
