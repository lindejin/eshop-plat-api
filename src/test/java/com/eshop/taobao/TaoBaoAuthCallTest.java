package com.eshop.taobao;

import com.alibaba.fastjson.JSON;
import com.eshop.util.platform.api.client.taobao.request.TaoBaoAppClientDTO;
import com.eshop.util.platform.api.service.auth.taobao.TaoBaoAuthCall;
import com.eshop.util.platform.api.service.auth.taobao.dto.TaoBaoTokenCreateDTO;
import com.eshop.util.platform.api.service.auth.taobao.dto.TaoBaoTokenRefreshDTO;
import com.eshop.util.platform.api.service.auth.taobao.vo.TaoBaoTokenCreateVO;
import com.eshop.util.platform.api.service.auth.taobao.vo.TaoBaoTokenRefreshVO;
import com.eshop.util.platform.api.service.logistics.taobao.TaoBaoLogisticsCall;
import com.eshop.util.platform.api.service.logistics.taobao.dto.TaoBaoEbillTemplatesReqDTO;
import com.eshop.util.platform.api.service.logistics.taobao.vo.TaoBaoEbillTemplatesRespVO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @program: eshop-plat-api
 * @description:
 * @author: lindz
 * @create: 2026-01-08 12:01
 **/

@SpringBootTest
public class TaoBaoAuthCallTest {

    @Autowired
    private TaoBaoAuthCall taoBaoAuthCall;


    //--ok
    @Test
    void tokenCreate() throws Exception {
        String apiUrl = "https://gw.api.taobao.com/router/rest";
        String appKey = "34124006";
        String appSecret = "4a921fb19d69fca3db1becf7d96c00ca";
        String sessionKey = "";
        TaoBaoAppClientDTO appDTO = new TaoBaoAppClientDTO();
        appDTO.setAppKey(appKey);
        appDTO.setAppSecret(appSecret);
        appDTO.setSessionKey(sessionKey);
//        appDTO.setTargetAppKey(targetAppKey);
        appDTO.setApiUrl(apiUrl);

        TaoBaoTokenCreateDTO reqDTO = new TaoBaoTokenCreateDTO();
        reqDTO.setCode("fLcPnldpFBsvavd1rTulyHOF17226346");
        TaoBaoTokenCreateVO vo = taoBaoAuthCall.tokenCreate(appDTO, reqDTO);
        System.out.println(vo.getRespBody());
        System.out.println(JSON.toJSONString(vo));
        //{
        //    "request_id": "15qtv8mgtv8b3",
        //    "respBody": "{\"top_auth_token_create_response\":{\"token_result\":\"{\\\"w1_expires_in\\\":31523977,\\\"refresh_token_valid_time\\\":1767841169000,\\\"taobao_user_nick\\\":\\\"bagsmart%E6%97%97%E8%88%B0%E5%BA%97\\\",\\\"re_expires_in\\\":0,\\\"expire_time\\\":1799377170000,\\\"token_type\\\":\\\"Bearer\\\",\\\"access_token\\\":\\\"6200529c11ee15b9d649f6aa2e5ba207a1360ZZ5740d5ac2206890150985\\\",\\\"taobao_open_uid\\\":\\\"AAGyYCniAOGL3SARbugzJ7Gs\\\",\\\"w1_valid\\\":1799377170468,\\\"refresh_token\\\":\\\"6201229c55e905f4b06251a838e80f6df9c60ZZ8261d7b22206890150985\\\",\\\"w2_expires_in\\\":31523977,\\\"w2_valid\\\":1799377170468,\\\"r1_expires_in\\\":31523977,\\\"r2_expires_in\\\":31523977,\\\"r2_valid\\\":1799377170468,\\\"r1_valid\\\":1799377170468,\\\"taobao_user_id\\\":\\\"2206890150985\\\",\\\"expires_in\\\":31523977}\",\"request_id\":\"15qtv8mgtv8b3\"}}",
        //    "token_vo": {
        //        "access_token": "6200529c11ee15b9d649f6aa2e5ba207a1360ZZ5740d5ac2206890150985",
        //        "expire_time": 1799377170000,
        //        "expires_in": 31523977,
        //        "r1_expires_in": 31523977,
        //        "r1_valid": 1799377170468,
        //        "r2_expires_in": 31523977,
        //        "r2_valid": 1799377170468,
        //        "re_expires_in": 0,
        //        "refresh_token": "6201229c55e905f4b06251a838e80f6df9c60ZZ8261d7b22206890150985",
        //        "refresh_token_valid_time": 1767841169000,
        //        "taobao_open_uid": "AAGyYCniAOGL3SARbugzJ7Gs",
        //        "taobao_user_id": "2206890150985",
        //        "taobao_user_nick": "bagsmart旗舰店",
        //        "token_type": "Bearer",
        //        "w1_expires_in": 31523977,
        //        "w1_valid": 1799377170468,
        //        "w2_expires_in": 31523977,
        //        "w2_valid": 1799377170468
        //    },
        //    "top_auth_token_create_response": {
        //        "request_id": "15qtv8mgtv8b3",
        //        "token_result": "{\"w1_expires_in\":31523977,\"refresh_token_valid_time\":1767841169000,\"taobao_user_nick\":\"bagsmart%E6%97%97%E8%88%B0%E5%BA%97\",\"re_expires_in\":0,\"expire_time\":1799377170000,\"token_type\":\"Bearer\",\"access_token\":\"6200529c11ee15b9d649f6aa2e5ba207a1360ZZ5740d5ac2206890150985\",\"taobao_open_uid\":\"AAGyYCniAOGL3SARbugzJ7Gs\",\"w1_valid\":1799377170468,\"refresh_token\":\"6201229c55e905f4b06251a838e80f6df9c60ZZ8261d7b22206890150985\",\"w2_expires_in\":31523977,\"w2_valid\":1799377170468,\"r1_expires_in\":31523977,\"r2_expires_in\":31523977,\"r2_valid\":1799377170468,\"r1_valid\":1799377170468,\"taobao_user_id\":\"2206890150985\",\"expires_in\":31523977}"
        //    }
        //}
    }

    //--ok
    @Test
    void tokenRefresh() throws Exception {
        String apiUrl = "https://gw.api.taobao.com/router/rest";
        String appKey = "34124006";
        String appSecret = "4a921fb19d69fca3db1becf7d96c00ca";
        String sessionKey = "";
        TaoBaoAppClientDTO appDTO = new TaoBaoAppClientDTO();
        appDTO.setAppKey(appKey);
        appDTO.setAppSecret(appSecret);
        appDTO.setSessionKey(sessionKey);
//        appDTO.setTargetAppKey(targetAppKey);
        appDTO.setApiUrl(apiUrl);

        TaoBaoTokenRefreshDTO reqDTO = new TaoBaoTokenRefreshDTO();
        reqDTO.setRefresh_token("6201229c55e905f4b06251a838e80f6df9c60ZZ8261d7b22206890150985");
        TaoBaoTokenRefreshVO vo = taoBaoAuthCall.tokenRefresh(appDTO, reqDTO);
        System.out.println(vo.getRespBody());
        System.out.println(JSON.toJSONString(vo));
    }
}