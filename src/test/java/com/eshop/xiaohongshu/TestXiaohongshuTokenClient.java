package com.eshop.xiaohongshu;

import com.eshop.util.platform.api.client.xiaohongshu.XiaohongshuClient;
import com.eshop.util.platform.api.client.xiaohongshu.XiaohongshuTokenClient;
import com.eshop.util.platform.api.client.xiaohongshu.request.XiaohongshuAppClientDTO;
import com.eshop.util.platform.api.client.xiaohongshu.request.XiaohongshuRequest;
import com.eshop.util.platform.api.client.xiaohongshu.response.XiaohongshuResponse;
import com.eshop.util.platform.api.service.order.jushuitan.JushuitanOrderCall;
import io.lettuce.core.output.ScanOutput;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class TestXiaohongshuTokenClient {

    @Autowired
    private XiaohongshuClient xiaohongshuClient;

    @Autowired
    private XiaohongshuTokenClient xiaohongshuTokenClient;


    @Test
    void getOrderDetailV2() throws Exception {
        String code = "code-043b214cbe0043a7ad1d3d842a407724-8e859bb48f0744c78554de86898b04e7";

        String method = "oauth.getAccessToken";
        String version = "2.0";
        XiaohongshuRequest request = new XiaohongshuRequest();
        request.setMethod(method);
        request.setVersion(version);

        String apiUrl = "https://ark.xiaohongshu.com/ark/open_api/v3/common_controller";
        String appId = "698f0fae6fd04676aedd";
        String appSecret = "ea1ff5772da8a2d363976130c9199c62";
        XiaohongshuAppClientDTO appDTO = new XiaohongshuAppClientDTO();
        appDTO.setAppId(appId);
        appDTO.setAppSecret(appSecret);
        appDTO.setApiUrl(apiUrl);
        XiaohongshuResponse accessToken = xiaohongshuTokenClient.getAccessToken(code,request, appDTO);
        System.out.println(accessToken.getGopResponseBody());
        //{"error_code":0,"data":{"accessToken":"token-a67156322938498fbb24aba54d62069f-cc7df12b41c14602976fd45b130d2341","accessTokenExpiresAt":1765269760308,"refreshToken":"refresh-7dce08b332794418b0dea60556d7f30b-67755d70491e435fb290d7724f43b6e3","refreshTokenExpiresAt":1765874560309,"sellerId":"5f0d2c34cac48d0001a6ed62","sellerName":"BAGSMART旗舰店"},"success":true}

        /**
         * {
         *     "error_code": 0,
         *     "data": {
         *         "accessToken": "token-a67156322938498fbb24aba54d62069f-cc7df12b41c14602976fd45b130d2341",
         *         "accessTokenExpiresAt": 1765269760308,
         *         "refreshToken": "refresh-7dce08b332794418b0dea60556d7f30b-67755d70491e435fb290d7724f43b6e3",
         *         "refreshTokenExpiresAt": 1765874560309,
         *         "sellerId": "5f0d2c34cac48d0001a6ed62",
         *         "sellerName": "BAGSMART旗舰店"
         *     },
         *     "success": true
         * }
         */
        // 授权开始时间  2025-12-02 16:42:40
        // 授权到期时间  2025-12-16 16:42:41
        // 授权有效时间  16-2 = 14天

        //{"error_code":999,"error_msg":"code expired","success":false}
        /**
         *
         */
    }
}
