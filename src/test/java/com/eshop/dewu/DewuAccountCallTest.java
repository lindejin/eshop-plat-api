package com.eshop.dewu;

import com.alibaba.fastjson.JSON;
import com.eshop.util.platform.api.client.dewu.request.DewuAppClientDTO;
import com.eshop.util.platform.api.service.account.dewu.DewuAccountCall;
import com.eshop.util.platform.api.service.account.dewu.dto.DewuMerchantBaseInfoReqDTO;
import com.eshop.util.platform.api.service.account.dewu.vo.DewuMerchantBaseInfoRespVO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class DewuAccountCallTest {

    @Autowired
    private DewuAccountCall dewuAccountCall;

    /**
     * 获取店铺信息
     */
    @Test
    public void getMerchantBaseInfo() throws Exception {
        String apiUrl = "https://openapi.dewu.com";
        String appKey = "75881da49c8b41caa2448c3fef771595";
        String appSecret = "5f44031fef3f41119f2324ac3fbeb9aaaf6a9d9fb4024455809bdaee3e30804c";
        String accessToken = "hbJQZKfBaIDeeHKuLHZkJ6OYUjfNI1jQ6oTfqcdeXX6Xpkd14s58RfOjrFt2ukX0";
        DewuAppClientDTO appDTO = new DewuAppClientDTO();
        appDTO.setAppKey(appKey);
        appDTO.setAppSecret(appSecret);
        appDTO.setApiUrl(apiUrl);
        appDTO.setAccessToken(accessToken);

        DewuMerchantBaseInfoReqDTO reqDTO = new DewuMerchantBaseInfoReqDTO();
        DewuMerchantBaseInfoRespVO respVO = dewuAccountCall.getMerchantBaseInfo(appDTO, reqDTO);
        System.out.println(respVO.getRespBody());
        System.out.println(JSON.toJSONString(respVO));

        //{"msg":"success","trace_id":"0aec379d69368f79b3e6cc038907883e","code":200,"data":{"type_id":2,"merchant_id":6816217},"status":"200"}
        //{"respBody":"{\"msg\":\"success\",\"trace_id\":\"0aec379d69368f79b3e6cc038907883e\",\"code\":200,\"data\":{\"type_id\":2,\"merchant_id\":6816217},\"status\":\"200\"}"}

    }
}
