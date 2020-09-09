package com.leif.knowme.controller;

import com.leif.knowme.api.request.CreateAccountRequest;
import com.leif.knowme.base.KmRequest;
import com.leif.knowme.dto.AccountDto;
import com.leif.knowme.service.AccountService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author HelloLeif
 * @date 2020/8/24
 */
@RestController()
@RequestMapping("account")
public class AccountController {

    @Autowired
    AccountService accountService;

    @PostMapping(headers = "Accept=application/json")
    public String createAccount(@RequestBody KmRequest<CreateAccountRequest> request) {
        AccountDto accountDto = new AccountDto();
        BeanUtils.copyProperties(request.getData(), accountDto);
        return accountService.createAccount(accountDto);
    }

    @GetMapping(value = "/{accountNo}")
    public boolean checkIsAccountNoExist(@PathVariable String accountNo) {
        return accountService.checkIsAccountNoExist(accountNo);
    }
}
