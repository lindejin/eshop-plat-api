package com.eshop.jd;

import com.alibaba.fastjson.JSON;
import com.eshop.util.platform.api.client.jd.request.JdLogisticsAppClientDTO;
import com.eshop.util.platform.api.service.auth.jdl.JdlAuthCall;
import com.eshop.util.platform.api.service.auth.jdl.dto.JdLogisticsTokenRefreshDTO;
import com.eshop.util.platform.api.service.auth.jdl.vo.JdLogisticsTokenRefreshVO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class JdlAuthCallTest {

    @Autowired
    private JdlAuthCall jdlAuthCall;


    @Test
    void getTemplates() throws Exception {
//        String refreshToken = "e5bfa497680e46d39bd7";
        String refreshToken =  "e5bfa497680e46d39bd7709579137264";
        String oauthUrl = "https://oauth.jdl.com";


        String baseUri = "https://api.jdl.com";

        String appKey = "ea2331f2018e4682a58c74e02cfd2788";
        String appSecret = "a0400547d20f472a9af39c5134ac122e";
        String accessToken = "ddf0a1d62d794b5d836b4d69202a695f";

        JdLogisticsAppClientDTO acDTO = new JdLogisticsAppClientDTO();
        acDTO.setAppKey(appKey);
        acDTO.setAppSecret(appSecret);
        acDTO.setApiUrl(baseUri);
        acDTO.setAccessToken(accessToken);

        JdLogisticsTokenRefreshDTO reqDTO = new JdLogisticsTokenRefreshDTO();
        reqDTO.setRefreshToken(refreshToken);

        JdLogisticsTokenRefreshVO respVO = jdlAuthCall.tokenRefresh(oauthUrl, acDTO, reqDTO);
        System.out.println(respVO.getRespBody());
        System.out.println(JSON.toJSON(respVO));
    }

}
