package com.leif.knowme.service;

import com.leif.knowme.exception.AppException;
import com.leif.knowme.outer.WechatApi;
import com.leif.knowme.outer.response.WxLoginRes;
import com.leif.knowme.repository.WxRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WxService {
    @Autowired
    WechatApi wechatApi;
    @Autowired
    WxRepository wxRepository;

    public String wxLogin(String code) throws AppException {
        WxLoginRes response = wechatApi.login(code);
        if (response.getErrcode() != WxLoginRes.ERRCODE_SUCC) {
            throw new AppException("Wechat login error");
        }
        return response.getSessionKey();
    }
}
