package com.leif.knowme.controller;

import com.leif.knowme.base.KmRequest;
import com.leif.knowme.po.AccountPo;
import com.leif.knowme.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author HelloLeif
 * @date 2020/8/24
 */
@RestController("/account")
public class AccountController {

    @Autowired
    AccountService accountService;

    @PostMapping(headers = "Accept=application/json")
    public String createAccount(@RequestBody KmRequest<AccountPo> request) {
        return accountService.createAccount(request.getData());
    }

    @GetMapping(value = "/{accountNo}")
    public boolean checkIsAccountNoExist(@PathVariable String accountNo) {
        return accountService.checkIsAccountNoExist(accountNo);
    }
}
