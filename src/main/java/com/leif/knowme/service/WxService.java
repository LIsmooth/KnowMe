package com.leif.knowme.service;

import com.leif.knowme.exception.AppException;
import com.leif.knowme.outer.WechatApi;
import com.leif.knowme.outer.response.WxLoginResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WxService {
    @Autowired
    WechatApi wechatApi;

    public String wxLogin(String code) throws AppException {
        WxLoginResponse response = wechatApi.login(code);
        if (response.getErrcode() != WxLoginResponse.ERRCODE_SUCC) {
            throw new AppException("Wechat login error");
        }
        return response.getSessionKey();
    }
}
