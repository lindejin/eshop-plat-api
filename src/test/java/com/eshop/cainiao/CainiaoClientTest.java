package com.eshop.cainiao;

import com.alibaba.fastjson.JSONObject;
import com.eshop.util.platform.api.client.cainiao.CainiaoClient;
import com.eshop.util.platform.api.client.cainiao.request.CainiaoAppClientDTO;
import com.eshop.util.platform.api.client.cainiao.request.CainiaoRequest;
import com.eshop.util.platform.api.client.cainiao.response.CainiaoResponse;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
public class CainiaoClientTest {

    @Autowired
    private CainiaoClient cainiaoClient;

    /**
     * 获取店铺信息
     */
    @Test
    public void getMerchantBaseInfo() throws Exception {
        String msgType = "CLOUDPRINT_STANDARD_TEMPLATES";
        JSONObject obj = new JSONObject();
        String requestContent = obj.toJSONString();
        CainiaoRequest request = new CainiaoRequest();
        request.setMsgType(msgType);
        request.setRequestContent(requestContent);

        //6. APPKEY：942402；   appSecret：fSZUeG13056KO8My1m461Y91FUEzP47I
        String apiUrl = "https://link.cainiao.com/gateway/link.do";
        String appId = "942402";
        String appSecret = "fSZUeG13056KO8My1m461Y91FUEzP47I";
        String accessToken = "ZGx5Y2QzNk95UHlnc1pMT0JOU3ZSOGgreitIT0I4eGdRMHRXYkFzd2VZNlZ2Y2NQY1NTT09FUVN4cGRMb3UvYw==";

        CainiaoAppClientDTO appDTO = new CainiaoAppClientDTO();
        appDTO.setAppKey(appId);
        appDTO.setAppSecret(appSecret);
        appDTO.setApiUrl(apiUrl);
        appDTO.setAccessToken(accessToken);
        CainiaoResponse execute = cainiaoClient.execute(request, appDTO);
        System.out.println(execute.getGopResponseBody());
    }
}
