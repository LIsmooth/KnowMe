package com.leif.knowme.util;

import com.leif.knowme.pojo.HttpClientResult;
import com.leif.knowme.pojo.WxUserInfo;
import org.junit.Test;

import java.util.Map;

public class UtilsTest {

    @Test
    public void generateUUIDTest() {
        System.out.println(UUIDUtils.generateUUID());
    }

    @Test
    public void testWxGetUserInfoDecode(){
        String appId = "wx4f4bc4dec97d474b";
        String sessionKey = "tiihtNczf5v6AKRyjwEUhQ==";
        String encryptedData = "CiyLU1Aw2KjvrjMdj8YKliAjtP4gsMZMQmRzooG2xrDcvSnxIMXFufNstNGTyaGS9uT5geRa0W4oTOb1WT7fJlAC+oNPdbB+3hVbJSRgv+4lGOETKUQz6OYStslQ142dNCuabNPGBzlooOmB231qMM85d2/fV6ChevvXvQP8Hkue1poOFtnEtpyxVLW1zAo6/1Xx1COxFvrc2d7UL/lmHInNlxuacJXwu0fjpXfz/YqYzBIBzD6WUfTIF9GRHpOn/Hz7saL8xz+W//FRAUid1OksQaQx4CMs8LOddcQhULW4ucetDf96JcR3g0gfRK4PC7E/r7Z6xNrXd2UIeorGj5Ef7b1pJAYB6Y5anaHqZ9J6nKEBvB4DnNLIVWSgARns/8wR2SiRS7MNACwTyrGvt9ts8p12PKFdlqYTopNHR1Vf7XjfhQlVsAJdNiKdYmYVoKlaRv85IfVunYzO0IKXsyl7JCUjCpoG20f0a04COwfneQAGGwd5oa+T8yO5hzuyDb/XcxxmK01EpqOyuxINew==";
        String iv = "r7BXXKkLb8qrSNn05n0qiA==";
        WxUserInfo s=CryptUtil.wxDecodeUserInfo(encryptedData,sessionKey,iv);
        assert s != null;
        assert s.getWaterMark().getAppid().equals(appId);
    }

    @Test
    public void testHttpUtilsGetMethod() throws Exception {
        HttpClientResult result= HttpUtils.doGet("https://www.baidu.com/",null);
        assert result.getCode()==200;
    }
}