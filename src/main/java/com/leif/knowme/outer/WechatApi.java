package com.leif.knowme.outer;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.leif.knowme.config.KmProperties;
import com.leif.knowme.exception.AppException;
import com.leif.knowme.outer.response.WxLoginResponse;
import com.leif.knowme.pojo.HttpClientResult;
import com.leif.knowme.util.HttpUtils;
import org.apache.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;

@Component
public class WechatApi {
    @Autowired
    KmProperties kmProperties;

    public WxLoginResponse login(String code) throws AppException {
        String requestUrl = "https://api.weixin.qq.com/sns/jscode2session";
        Map<String, String> params = new HashMap<>(4);
        params.put("appid", kmProperties.getWxAppId());
        params.put("secret", kmProperties.getWxSecret());
        params.put("js_code", code);
        params.put("grant_type", "authorization_code");

        HttpClientResult result;
        try {
            result = HttpUtils.doGet(requestUrl, params);
            return convertToWxLoginResponse(result);
        } catch (IOException | URISyntaxException e) {
            throw new AppException(e.getMessage());
        }
    }

    private WxLoginResponse convertToWxLoginResponse(HttpClientResult result) throws IOException, AppException {
        if (result.getCode() == HttpStatus.SC_OK) {
            ObjectMapper objectMapper = new ObjectMapper();
            return objectMapper.readValue(result.getContent(), WxLoginResponse.class);
        } else {
            throw new AppException(result.getContent());
        }
    }
}
