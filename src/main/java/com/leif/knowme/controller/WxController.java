package com.leif.knowme.controller;

import com.leif.knowme.exception.AppException;
import com.leif.knowme.pojo.WxUserInfo;
import com.leif.knowme.service.AccountService;
import com.leif.knowme.service.WxService;
import com.leif.knowme.util.CryptUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
    @Autowired
    WxService wxService;
    Logger logger = LoggerFactory.getLogger(getClass());

    @PostMapping(value = "/register", headers = "Accept=application/json")
    public void wxRegister(@RequestBody Map<String,String> params) throws AppException {
        String code = params.get("code");
        String encryptedData=params.get("encryptedData");
        String iv = params.get("iv");

        String sessionKey = wxService.wxLogin(code);
        WxUserInfo userInfo=CryptUtil.wxDecodeUserInfo(encryptedData,sessionKey,iv);
    }

    @GetMapping(value="/login/{code}")
    public void wxLogin(@PathVariable String code){
        logger.trace("trace log");
        logger.debug("debug log");
        logger.warn("warn log");
        logger.error("error",new AppException("this is an Exception"));
    }
}
