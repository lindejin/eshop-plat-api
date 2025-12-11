package com.eshop.jd;

import com.alibaba.fastjson.JSON;
import com.eshop.util.platform.api.client.jd.request.JdLogisticsAppClientDTO;
import com.eshop.util.platform.api.service.auth.jdl.JdlAuthCall;
import com.eshop.util.platform.api.service.auth.jdl.dto.JdLogisticsTokenCreateDTO;
import com.eshop.util.platform.api.service.auth.jdl.dto.JdLogisticsTokenRefreshDTO;
import com.eshop.util.platform.api.service.auth.jdl.vo.JdLogisticsTokenCreateVO;
import com.eshop.util.platform.api.service.auth.jdl.vo.JdLogisticsTokenRefreshVO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class JdlAuthCallTest {

    @Autowired
    private JdlAuthCall jdlAuthCall;

    @Test
    void tokenCreate() throws Exception {
//        String refreshToken = "e5bfa497680e46d39bd7";
        String oauthUrl = "https://oauth.jdl.com";


        String baseUri = "https://api.jdl.com";

        String appKey = "ea2331f2018e4682a58c74e02cfd2788";
        String appSecret = "a0400547d20f472a9af39c5134ac122e";

        String code = "5f21274c4d8b45f78ea233b83c1d2cd0";

        JdLogisticsAppClientDTO acDTO = new JdLogisticsAppClientDTO();
        acDTO.setAppKey(appKey);
        acDTO.setAppSecret(appSecret);
        acDTO.setApiUrl(baseUri);

        JdLogisticsTokenCreateDTO reqDTO = new JdLogisticsTokenCreateDTO();
        reqDTO.setCode(code);

        JdLogisticsTokenCreateVO respVO = jdlAuthCall.tokenCreate(oauthUrl, acDTO, reqDTO);
        System.out.println(respVO.getRespBody());
        System.out.println(JSON.toJSON(respVO));

        //"{\"accessExpire\":\"2026-12-05 11:56:17\",\"accessToken\":\"ddf0a1d62d794b5d836b4d69202a695f\",\"clientId\":\"ea2331f2018e4682a58c74e02cfd2788\",\"code\":\"5f21274c4d8b45f78ea233b83c1d2cd0\",\"refreshExpire\":\"2027-01-05 11:56:17\",\"refreshToken\":\"e5bfa497680e46d39bd7709579137264\",\"sellerId\":\"BAGSMART\"}"
        //{"respBody":"\"{\\\"accessExpire\\\":\\\"2026-12-05 11:56:17\\\",\\\"accessToken\\\":\\\"ddf0a1d62d794b5d836b4d69202a695f\\\",\\\"clientId\\\":\\\"ea2331f2018e4682a58c74e02cfd2788\\\",\\\"code\\\":\\\"5f21274c4d8b45f78ea233b83c1d2cd0\\\",\\\"refreshExpire\\\":\\\"2027-01-05 11:56:17\\\",\\\"refreshToken\\\":\\\"e5bfa497680e46d39bd7709579137264\\\",\\\"sellerId\\\":\\\"BAGSMART\\\"}\"","clientId":"ea2331f2018e4682a58c74e02cfd2788","sellerId":"BAGSMART","refreshExpire":"2027-01-05 11:56:17","accessExpire":"2026-12-05 11:56:17","accessToken":"ddf0a1d62d794b5d836b4d69202a695f","refreshToken":"e5bfa497680e46d39bd7709579137264"}
    }


    @Test
    void tokenRefresh() throws Exception {
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

        //{"code":1000,"message":"success","enMessage":null,"data":{"accessExpire":"2026-12-05 11:56:17","accessToken":"ddf0a1d62d794b5d836b4d69202a695f","clientId":"ea2331f2018e4682a58c74e02cfd2788","refreshExpire":"2027-01-05 11:56:17","refreshToken":"e5bfa497680e46d39bd7709579137264","sellerId":"BAGSMART"}}
        //{"respBody":"{\"code\":1000,\"message\":\"success\",\"enMessage\":null,\"data\":{\"accessExpire\":\"2026-12-05 11:56:17\",\"accessToken\":\"ddf0a1d62d794b5d836b4d69202a695f\",\"clientId\":\"ea2331f2018e4682a58c74e02cfd2788\",\"refreshExpire\":\"2027-01-05 11:56:17\",\"refreshToken\":\"e5bfa497680e46d39bd7709579137264\",\"sellerId\":\"BAGSMART\"}}","clientId":"ea2331f2018e4682a58c74e02cfd2788","code":1000,"sellerId":"BAGSMART","data":{"clientId":"ea2331f2018e4682a58c74e02cfd2788","sellerId":"BAGSMART","refreshExpire":1799121377000,"accessExpire":1796442977000,"accessToken":"ddf0a1d62d794b5d836b4d69202a695f","refreshToken":"e5bfa497680e46d39bd7709579137264"},"refreshExpire":1799121377000,"accessExpire":1796442977000,"accessToken":"ddf0a1d62d794b5d836b4d69202a695f","message":"success","refreshToken":"e5bfa497680e46d39bd7709579137264"}
        }

}
