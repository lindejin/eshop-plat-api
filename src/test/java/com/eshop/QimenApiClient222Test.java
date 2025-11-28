package com.eshop;

import com.eshop.util.platform.api.client.jushuitan.QimenCustomApiClient;
import com.eshop.util.platform.api.client.jushuitan.request.QimenCustomAppClientDTO;
import com.eshop.util.platform.api.client.jushuitan.request.QimenCustomRequest;
import com.eshop.util.platform.api.client.jushuitan.response.QimenCustomResponse;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;
import java.util.Map;


@SpringBootTest
public class QimenApiClient222Test {

    @Autowired
    private QimenCustomApiClient qimenApiClient;


    @Test
    void getOrderDetailV2() throws Exception {
//        CombinationAnnotationElement
        String method = "jushuitan.order.list.query";
        /**
         * 返回内容响应格式。不传默认为xml格式，可选值：xml，json。
         */
         String format= "json";
        /**
         * API协议版本，可选值：2.0
         */
         String version= "2.0";
        /**
         * 签名的摘要算法，可选值为：hmac，md5，hmac-sha256。
         */
         String signMethod = "md5";

        Map<String, String> params = new HashMap<>();
        // 业务参数传参
        params.put("page_index", "1");
        params.put("page_size", "10");
        params.put("o_ids", "5459022");

        QimenCustomRequest jstRequest= new QimenCustomRequest();
        jstRequest.setMethod(method);
        jstRequest.setFormat(format);
        jstRequest.setVersion(version);
        jstRequest.setSignMethod(signMethod);

        jstRequest.setParams(params);
        /**
         * 可替换为您的应用的appKey
         * 聚水潭注释 奇门的appKey
         */
         String appKey = "23060081";
        /**
         * 可替换为您的应用的appSecret
         * 聚水潭注释 奇门的密钥
         */
         String appSecret= "";
        /**
         * 必须替换为授权得到的真实有效sessionKey
         * 聚水潭注释 非必填参数 可以不传
         */
         String sessionKey= "";
        /**
         * 用户需要透传的targetAppkey，主要用于安全验签，
         * 验签的目的是防止黑客恶意调用你的服务，确保服务发起来源来自奇门云网关。
         */
         String targetAppKey= "23060081";
        /**
         * 奇门调用地址
         * 聚水潭注释 请求容器URL
         */
         String apiUrl= "http://a1q40taq0j.api.taobao.com/router/qm";
        QimenCustomAppClientDTO appDTO = new QimenCustomAppClientDTO();
        appDTO.setAppKey(appKey);
        appDTO.setAppSecret(appSecret);
        appDTO.setSessionKey(sessionKey);
        appDTO.setTargetAppKey(targetAppKey);
        appDTO.setApiUrl(apiUrl);

        QimenCustomResponse respVO = qimenApiClient.execute(jstRequest, appDTO);
        System.out.println(respVO.getGopResponseBody());
//        System.out.println(JSON.toJSON(respVO));


        //{"response":{"flag":"failure","code":25,"message":"Invalid signature","request_id":"16kp0025x5z0p"}}
    }

}