package com.leif.knowme.controller;

import com.leif.knowme.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController()
@RequestMapping("wxapp")
public class WxController {
    @Autowired
    AccountService accountService;

    @PostMapping(value = "/register", headers = "Accept=application/json")
    public void register(@RequestBody Map<String,String> authInfo){
        authInfo.forEach((key, value) -> System.out.println(key + ":" + value));
    }
}
