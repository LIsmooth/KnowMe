package com.leif.knowme.repository;

import com.leif.knowme.dao.WxUserInfoMapper;
import com.leif.knowme.entity.WxUserInfo;
import com.leif.knowme.outer.response.WxLoginRes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class WxRepository {
    @Autowired
    WxUserInfoMapper mapper;

    public void saveLogin(WxLoginRes wxLoginInfo) {
        WxUserInfo userInfo=new WxUserInfo();
        userInfo.setOpenId(wxLoginInfo.getOpenid());
        userInfo.setSessionKey(wxLoginInfo.getSessionKey());
        mapper.insertOrUpdateLogin(userInfo);
    }
}
