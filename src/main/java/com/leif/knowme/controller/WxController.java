package com.leif.knowme.controller;

import com.leif.knowme.exception.AppException;
import com.leif.knowme.pojo.WxUserAccount;
import com.leif.knowme.pojo.WxUserInfo;
import com.leif.knowme.service.AccountService;
import com.leif.knowme.service.WxService;
import com.leif.knowme.util.CryptUtil;
import com.leif.knowme.util.JwtUtils;
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
    @Autowired
    JwtUtils jwtUtils;

    Logger logger = LoggerFactory.getLogger(getClass());

    @PostMapping(value = "/register", headers = "Accept=application/json")
    public void wxRegister(@RequestBody Map<String, String> params) throws AppException {
        String code = params.get("code");
        String encryptedData = params.get("encryptedData");
        String iv = params.get("iv");

        WxUserAccount wxUserAccount = wxService.wxLogin(code);
        WxUserInfo userInfo = CryptUtil.wxDecodeUserInfo(encryptedData, wxUserAccount.getSessionKey(), iv);
    }

    @GetMapping(value = "/login/{code}")
    public String wxLogin(@PathVariable String code) throws AppException {
        WxUserAccount wxUserAccount = wxService.wxLogin(code);
        return jwtUtils.doGenerateToken(wxUserAccount.getAccountId());
    }
}
