package com.eshop.jushuitan;

import com.alibaba.fastjson.JSON;
import com.eshop.util.platform.api.client.douyin.request.DouyinAppClientDTO;
import com.eshop.util.platform.api.client.jushuitan.request.JushuitanAppClientDTO;
import com.eshop.util.platform.api.service.auth.douyin.dto.DouyinTokenCreateDTO;
import com.eshop.util.platform.api.service.auth.douyin.vo.DouyinTokenCreateVO;
import com.eshop.util.platform.api.service.order.jushuitan.dto.JushuitanOrderListReqDTO;
import com.eshop.util.platform.api.service.order.jushuitan.vo.JushuitanOrderListRespVO;
import com.eshop.util.platform.api.service.user.shop.jushuitan.JushuitanShopCall;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @program: eshop-plat-api
 * @description:
 * @author: lindz
 * @create: 2026-01-05 15:31
 **/
@SpringBootTest
public class JushuitanShopCallTest {

    @Autowired
    private JushuitanShopCall jushuitanShopCall;


    @Test
    void getShopList() throws Exception {
        String appKey = "ba0c1a5cd17a4d41a1e8d48e3c867419";
        String appSecret = "3381fe28080a469ab684f4e291d4f823";
        String accessToken = "9a5a8b4dfa8e46bfbb7c9b01612aa711";

        String apiUrl= "https://openapi.jushuitan.com";
//        String apiUrl = "https://dev-api.jushuitan.com";
        JushuitanAppClientDTO acDTO = new JushuitanAppClientDTO();
        acDTO.setAppKey(appKey);
        acDTO.setAppSecret(appSecret);
        acDTO.setAccessToken(accessToken);
        acDTO.setApiUrl(apiUrl);

        JushuitanOrderListReqDTO reqDTO = new JushuitanOrderListReqDTO();
        reqDTO.setPage_index(1);
        reqDTO.setPage_size(50);

        JushuitanOrderListRespVO respVO = jushuitanShopCall.getShopList(acDTO, reqDTO);

        System.out.println(respVO.getRespBody());
        System.out.println(JSON.toJSON(respVO));

        //{"code":10000,"msg":"success","sub_code":"","sub_msg":"","data":{"token_type":0,"access_token":"hfd86q0wc81lgwk7oxkf6er00001ri95-11","scope":"SCOPE","shop_name":"BAGSMART官方旗舰店","toutiao_id":"676919174504088","authority_id":null,"expires_in":604800,"shop_biz_type":0,"auth_subject_type":null,"encrypt_operator":"","operator_name":"","shop_id":2962985,"refresh_token":"2lrj1rges01lgwk7oxkf6er00001ri95-12"},"log_id":"202512041756193F188E2A6C7F76DAC003"}
        //{"respBody":"{\"code\":10000,\"msg\":\"success\",\"sub_code\":\"\",\"sub_msg\":\"\",\"data\":{\"token_type\":0,\"access_token\":\"hfd86q0wc81lgwk7oxkf6er00001ri95-11\",\"scope\":\"SCOPE\",\"shop_name\":\"BAGSMART官方旗舰店\",\"toutiao_id\":\"676919174504088\",\"authority_id\":null,\"expires_in\":604800,\"shop_biz_type\":0,\"auth_subject_type\":null,\"encrypt_operator\":\"\",\"operator_name\":\"\",\"shop_id\":2962985,\"refresh_token\":\"2lrj1rges01lgwk7oxkf6er00001ri95-12\"},\"log_id\":\"202512041756193F188E2A6C7F76DAC003\"}"}
    }
}
