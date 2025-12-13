package com.eshop.xiaohongshu;

import com.alibaba.fastjson.JSON;
import com.eshop.util.platform.api.client.xiaohongshu.request.XiaohongshuAppClientDTO;
import com.eshop.util.platform.api.service.auth.xiaohongshu.XiaohongshuAuthCall;
import com.eshop.util.platform.api.service.auth.xiaohongshu.dto.XiaohongshuTokenCreateDTO;
import com.eshop.util.platform.api.service.auth.xiaohongshu.dto.XiaohongshuTokenRefreshDTO;
import com.eshop.util.platform.api.service.auth.xiaohongshu.vo.XiaohongshuTokenCreateVO;
import com.eshop.util.platform.api.service.auth.xiaohongshu.vo.XiaohongshuTokenRefreshVO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
public class TestXiaohongshuAuthCallService {

    @Autowired
    private XiaohongshuAuthCall xiaohongshuAuthCallService;


    @Test
    void tokenCreate() throws Exception {
        String apiUrl = "https://ark.xiaohongshu.com/ark/open_api/v3/common_controller";
        String appId = "698f0fae6fd04676aedd";
        String appSecret = "ea1ff5772da8a2d363976130c9199c62";
        XiaohongshuAppClientDTO appDTO = new XiaohongshuAppClientDTO();
        appDTO.setAppId(appId);
        appDTO.setAppSecret(appSecret);
        appDTO.setApiUrl(apiUrl);

        String code = "code-043b214cbe0043a7ad1d3d842a407724-8e859bb48f0744c78554de86898b04e7";
        XiaohongshuTokenCreateDTO reqDTO = new XiaohongshuTokenCreateDTO();
        reqDTO.setCode(code);

        XiaohongshuTokenCreateVO xiaohongshuTokenCreateVO = xiaohongshuAuthCallService.tokenCreate(appDTO, reqDTO);
        System.out.println(xiaohongshuTokenCreateVO.getRespBody());
        System.out.println(JSON.toJSONString(xiaohongshuTokenCreateVO));
    }


    @Test
    void tokenRefresh() throws Exception {
        String apiUrl = "https://ark.xiaohongshu.com/ark/open_api/v3/common_controller";
        String appId = "698f0fae6fd04676aedd";
        String appSecret = "ea1ff5772da8a2d363976130c9199c62";
        XiaohongshuAppClientDTO appDTO = new XiaohongshuAppClientDTO();
        appDTO.setAppId(appId);
        appDTO.setAppSecret(appSecret);
        appDTO.setApiUrl(apiUrl);

        String refreshToken = "refresh-7dce08b332794418b0dea60556d7f30b-67755d70491e435fb290d7724f43b6e3";
        XiaohongshuTokenRefreshDTO reqDTO = new XiaohongshuTokenRefreshDTO();
        reqDTO.setRefreshToken(refreshToken);

        XiaohongshuTokenRefreshVO xiaohongshuTokenCreateVO = xiaohongshuAuthCallService.tokenRefresh(appDTO, reqDTO);
        System.out.println(xiaohongshuTokenCreateVO.getRespBody());
        System.out.println(JSON.toJSONString(xiaohongshuTokenCreateVO));
        //{"error_code":0,"data":{"accessToken":"token-a67156322938498fbb24aba54d62069f-cc7df12b41c14602976fd45b130d2341","accessTokenExpiresAt":1765269761230,"refreshToken":"refresh-7dce08b332794418b0dea60556d7f30b-67755d70491e435fb290d7724f43b6e3","refreshTokenExpiresAt":1765874561336,"sellerId":"5f0d2c34cac48d0001a6ed62","sellerName":"BAGSMART旗舰店"},"success":true}
        //{"data":{"accessToken":"token-a67156322938498fbb24aba54d62069f-cc7df12b41c14602976fd45b130d2341","accessTokenExpiresAt":1765269761230,"refreshToken":"refresh-7dce08b332794418b0dea60556d7f30b-67755d70491e435fb290d7724f43b6e3","refreshTokenExpiresAt":1765874561336,"sellerId":"5f0d2c34cac48d0001a6ed62","sellerName":"BAGSMART旗舰店"},"error_code":0,"respBody":"{\"error_code\":0,\"data\":{\"accessToken\":\"token-a67156322938498fbb24aba54d62069f-cc7df12b41c14602976fd45b130d2341\",\"accessTokenExpiresAt\":1765269761230,\"refreshToken\":\"refresh-7dce08b332794418b0dea60556d7f30b-67755d70491e435fb290d7724f43b6e3\",\"refreshTokenExpiresAt\":1765874561336,\"sellerId\":\"5f0d2c34cac48d0001a6ed62\",\"sellerName\":\"BAGSMART旗舰店\"},\"success\":true}","success":true}
        /**
         *{
         *     "error_code": 0,
         *     "data": {
         *         "accessToken": "token-a67156322938498fbb24aba54d62069f-cc7df12b41c14602976fd45b130d2341",
         *         "accessTokenExpiresAt": 1765269761230,
         *         "refreshToken": "refresh-7dce08b332794418b0dea60556d7f30b-67755d70491e435fb290d7724f43b6e3",
         *         "refreshTokenExpiresAt": 1765874561336,
         *         "sellerId": "5f0d2c34cac48d0001a6ed62",
         *         "sellerName": "BAGSMART旗舰店"
         *     },
         *     "success": true
         * }
         */

        //{"error_code":0,"data":{"accessToken":"token-a67156322938498fbb24aba54d62069f-cc7df12b41c14602976fd45b130d2341","accessTokenExpiresAt":1765269761209,"refreshToken":"refresh-7dce08b332794418b0dea60556d7f30b-67755d70491e435fb290d7724f43b6e3","refreshTokenExpiresAt":1765874561311,"sellerId":"5f0d2c34cac48d0001a6ed62","sellerName":"BAGSMART旗舰店"},"success":true}
        //{"data":{"accessToken":"token-a67156322938498fbb24aba54d62069f-cc7df12b41c14602976fd45b130d2341","accessTokenExpiresAt":1765269761209,"refreshToken":"refresh-7dce08b332794418b0dea60556d7f30b-67755d70491e435fb290d7724f43b6e3","refreshTokenExpiresAt":1765874561311,"sellerId":"5f0d2c34cac48d0001a6ed62","sellerName":"BAGSMART旗舰店"},"error_code":0,"respBody":"{\"error_code\":0,\"data\":{\"accessToken\":\"token-a67156322938498fbb24aba54d62069f-cc7df12b41c14602976fd45b130d2341\",\"accessTokenExpiresAt\":1765269761209,\"refreshToken\":\"refresh-7dce08b332794418b0dea60556d7f30b-67755d70491e435fb290d7724f43b6e3\",\"refreshTokenExpiresAt\":1765874561311,\"sellerId\":\"5f0d2c34cac48d0001a6ed62\",\"sellerName\":\"BAGSMART旗舰店\"},\"success\":true}","success":true}

        //{"error_code":0,"data":{"accessToken":"token-1bb6e0aa005e46b6b6e1cdf7c734701b-7917010aef564b30b10f3ced7b5dd068","accessTokenExpiresAt":1766215131464,"refreshToken":"refresh-82e68466aa724113a71be7c9ffd4bc4a-77d17896ad804ef4ac7388d390a42a43","refreshTokenExpiresAt":1766819931470,"sellerId":"5f0d2c34cac48d0001a6ed62","sellerName":"BAGSMART旗舰店"},"success":true}
        //{"accessToken":"token-1bb6e0aa005e46b6b6e1cdf7c734701b-7917010aef564b30b10f3ced7b5dd068","accessTokenExpiresAt":1766215131464,"data":{"accessToken":"token-1bb6e0aa005e46b6b6e1cdf7c734701b-7917010aef564b30b10f3ced7b5dd068","accessTokenExpiresAt":1766215131464,"refreshToken":"refresh-82e68466aa724113a71be7c9ffd4bc4a-77d17896ad804ef4ac7388d390a42a43","refreshTokenExpiresAt":1766819931470,"sellerId":"5f0d2c34cac48d0001a6ed62","sellerName":"BAGSMART旗舰店"},"error_code":0,"refreshToken":"refresh-82e68466aa724113a71be7c9ffd4bc4a-77d17896ad804ef4ac7388d390a42a43","refreshTokenExpiresAt":1766819931470,"respBody":"{\"error_code\":0,\"data\":{\"accessToken\":\"token-1bb6e0aa005e46b6b6e1cdf7c734701b-7917010aef564b30b10f3ced7b5dd068\",\"accessTokenExpiresAt\":1766215131464,\"refreshToken\":\"refresh-82e68466aa724113a71be7c9ffd4bc4a-77d17896ad804ef4ac7388d390a42a43\",\"refreshTokenExpiresAt\":1766819931470,\"sellerId\":\"5f0d2c34cac48d0001a6ed62\",\"sellerName\":\"BAGSMART旗舰店\"},\"success\":true}","sellerId":"5f0d2c34cac48d0001a6ed62","sellerName":"BAGSMART旗舰店","success":true}
    }
}
