package com.eshop.douyin;

import com.alibaba.fastjson.JSON;
import com.eshop.util.platform.api.client.douyin.request.DouyinAppClientDTO;
import com.eshop.util.platform.api.service.auth.douyin.DouyinAuthCall;
import com.eshop.util.platform.api.service.auth.douyin.dto.DouyinTokenCreateDTO;
import com.eshop.util.platform.api.service.auth.douyin.dto.DouyinTokenRefreshDTO;
import com.eshop.util.platform.api.service.auth.douyin.vo.DouyinTokenCreateVO;
import com.eshop.util.platform.api.service.auth.douyin.vo.DouyinTokenRefreshVO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
public class TestDouyinAuthCallService {

    @Autowired
    private DouyinAuthCall douyinAuthCallService;


    @Test
    void tokenCreate() throws Exception {
        String apiUrl = "https://openapi-fxg.jinritemai.com";
        String appKey = "7564242597683381811";
        String appSecret = "00c66ba7-ea59-42ad-9b34-b105483151b3";
        DouyinAppClientDTO acDTO = new DouyinAppClientDTO();
        acDTO.setAppKey(appKey);
        acDTO.setAppSecret(appSecret);
        acDTO.setApiUrl(apiUrl);


        //grant_type	String	是	authorization_code	授权类型 ；【工具型应用:authorization_code 自用型应用:authorization_self】，如果自用型应用有授权code，传authorization_code
        String grant_type = "authorization_self";
        //test_shop	String	否	2	判断测试店铺标识 ，非必传，若新增测试店铺传1，若不是则不必传
//        private String test_shop;
        //shop_id	String	否	17239	店铺ID，抖店自研应用使用。当auth_subject_type不为空时，该字段请勿传值，请将值传入到auth_id字段中
        String shop_id = "2962985";
//        //auth_id	String	否	112334	授权id，配合auth_subject_type字段使用。当auth_subject_type不为空时，请使用auth_id字段传值，shop_id请勿使用。
//        private String auth_id;
//        //auth_subject_type	String	否	WuLiuShang	授权主体类型，配合auth_id字段使用，YunCang -云仓；WuLiuShang -物流商；WLGongYingShang -物流供应商；MiniApp -小程序；MCN-联盟MCN机构；DouKe-联盟抖客 ；Colonel-联盟团长
//        private String auth_subject_type;
        DouyinTokenCreateDTO reqDTO = new DouyinTokenCreateDTO();
        reqDTO.setGrant_type(grant_type);
        reqDTO.setShop_id(shop_id);

        DouyinTokenCreateVO respVO = douyinAuthCallService.tokenCreate(acDTO, reqDTO);

        System.out.println(respVO.getRespBody());
        System.out.println(JSON.toJSON(respVO));

        //{"code":10000,"msg":"success","sub_code":"","sub_msg":"","data":{"token_type":0,"access_token":"hfd86q0wc81lgwk7oxkf6er00001ri95-11","scope":"SCOPE","shop_name":"BAGSMART官方旗舰店","toutiao_id":"676919174504088","authority_id":null,"expires_in":604800,"shop_biz_type":0,"auth_subject_type":null,"encrypt_operator":"","operator_name":"","shop_id":2962985,"refresh_token":"2lrj1rges01lgwk7oxkf6er00001ri95-12"},"log_id":"202512041756193F188E2A6C7F76DAC003"}
        //{"respBody":"{\"code\":10000,\"msg\":\"success\",\"sub_code\":\"\",\"sub_msg\":\"\",\"data\":{\"token_type\":0,\"access_token\":\"hfd86q0wc81lgwk7oxkf6er00001ri95-11\",\"scope\":\"SCOPE\",\"shop_name\":\"BAGSMART官方旗舰店\",\"toutiao_id\":\"676919174504088\",\"authority_id\":null,\"expires_in\":604800,\"shop_biz_type\":0,\"auth_subject_type\":null,\"encrypt_operator\":\"\",\"operator_name\":\"\",\"shop_id\":2962985,\"refresh_token\":\"2lrj1rges01lgwk7oxkf6er00001ri95-12\"},\"log_id\":\"202512041756193F188E2A6C7F76DAC003\"}"}
    }

    @Test
    void tokenRefresh() throws Exception {
        String apiUrl = "https://openapi-fxg.jinritemai.com";
        String appKey = "7564242597683381811";
        String appSecret = "00c66ba7-ea59-42ad-9b34-b105483151b3";
        DouyinAppClientDTO acDTO = new DouyinAppClientDTO();
        acDTO.setAppKey(appKey);
        acDTO.setAppSecret(appSecret);
        acDTO.setApiUrl(apiUrl);


        String grant_type = "refresh_token";
        String refresh_token = "2lrj1rges01lgwk7oxkf6er00001ri95-12";
        DouyinTokenRefreshDTO reqDTO = new DouyinTokenRefreshDTO();
        reqDTO.setGrant_type(grant_type);
        reqDTO.setRefresh_token(refresh_token);

        DouyinTokenRefreshVO respVO = douyinAuthCallService.tokenRefresh(acDTO, reqDTO);

        System.out.println(respVO.getRespBody());
        System.out.println(JSON.toJSON(respVO));

        //{"code":10000,"msg":"success","sub_code":"","sub_msg":"","data":{"auth_subject_type":null,"shop_id":2962985,"shop_biz_type":0,"access_token":"hfd86q0wc81lgwk7oxkf6er00001ri95-11","scope":"SCOPE","shop_name":"BAGSMART官方旗舰店","expires_in":286546,"refresh_token":"2lrj1rges01lgwk7oxkf6er00001ri95-12","authority_id":null},"log_id":"20251208102034DCFF3ABA2142CC634C13"}
        //{"msg":"success","respBody":"{\"code\":10000,\"msg\":\"success\",\"sub_code\":\"\",\"sub_msg\":\"\",\"data\":{\"auth_subject_type\":null,\"shop_id\":2962985,\"shop_biz_type\":0,\"access_token\":\"hfd86q0wc81lgwk7oxkf6er00001ri95-11\",\"scope\":\"SCOPE\",\"shop_name\":\"BAGSMART官方旗舰店\",\"expires_in\":286546,\"refresh_token\":\"2lrj1rges01lgwk7oxkf6er00001ri95-12\",\"authority_id\":null},\"log_id\":\"20251208102034DCFF3ABA2142CC634C13\"}","log_id":"20251208102034DCFF3ABA2142CC634C13","code":10000,"data":{"shop_name":"BAGSMART官方旗舰店","access_token":"hfd86q0wc81lgwk7oxkf6er00001ri95-11","refresh_token":"2lrj1rges01lgwk7oxkf6er00001ri95-12","shop_id":2962985,"shop_biz_type":0,"scope":"SCOPE","expires_in":286546},"sub_msg":"","sub_code":""}
    }
}
