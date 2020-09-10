package com.leif.knowme.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "km")
public class KmProperties {
    private String wxAppId;
    private String wxSecret;

    public String getWxAppId() {
        return wxAppId;
    }

    public void setWxAppId(String wxAppId) {
        this.wxAppId = wxAppId;
    }

    public String getWxSecret() {
        return wxSecret;
    }

    public void setWxSecret(String wxSecret) {
        this.wxSecret = wxSecret;
    }
}
