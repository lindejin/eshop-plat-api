package com.eshop;

import com.alibaba.fastjson.JSON;
import com.eshop.util.platform.api.client.jushuitan.request.JushuitanAppClientDTO;
import com.eshop.util.platform.api.service.order.jushuitan.JushuitanOrderCall;
import com.eshop.util.platform.api.service.order.jushuitan.dto.JushuitanOrderListReqDTO;
import com.eshop.util.platform.api.service.order.jushuitan.dto.JushuitanSaleOrderListReqDTO;
import com.eshop.util.platform.api.service.order.jushuitan.vo.JushuitanOrderListRespVO;
import com.eshop.util.platform.api.service.order.jushuitan.vo.JushuitanSaleOrderListRespVO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class JushuitanOrderCallTets {

    @Autowired
    private JushuitanOrderCall jushuitanOrderCall;


    @Test
    void getOrderDetailV2() throws Exception {
        /**
        * app_key 已创建成功的应用标志app_key，联系对接运营颁发
        */
        String appKey = "2f411678338d4ef9ab102fbe7c549da3";

        /**
         * app_secret 已创建成功的应用标志app_secret，联系对接运营颁发
         */
        String appSecret= "a765af900ce74ebe975b2416fcbeaecb";

        /**
         * 用户授权令牌access_token，卖家中心—授权管理获取即可，运营会颁发对应线上测试店铺token
         */
        String accessToken= "b2968310b7b4451c969013c5067f952d";


//        String apiUrl= "https://openapi.jushuitan.com";
        String apiUrl= "https://dev-api.jushuitan.com";
        JushuitanAppClientDTO temuAcDTO = new JushuitanAppClientDTO();
        temuAcDTO.setAppKey(appKey);
        temuAcDTO.setAppSecret(appSecret);
        temuAcDTO.setAccessToken(accessToken);
        temuAcDTO.setApiUrl(apiUrl);

        //与时间条件，内部单号不能同时为空，最大限制20条
        //modified_begin	string	否	2021-12-02 10:26:25	起始时间，和结束时间必须同时存在，时间间隔不能超过七天，与线上单号，内部单号不能同时为空;tips:用时间条件查询由于查询中数据存在变动的可能会由于排序问题引发分页查询漏单的问题，建议使用ts时间戳增量查询的方式
         String modified_begin = "2021-12-02 10:26:25";

        //modified_end	string	否	2021-12-09 10:26:25	结束时间，和起始时间必须同时存在，时间间隔不能超过七天，与线上单号，内部单号不能同时为空
         String modified_end = "2021-12-09 10:26:25";
        JushuitanOrderListReqDTO reqDTO = new JushuitanOrderListReqDTO();
        reqDTO.setModified_begin(modified_begin);
        reqDTO.setModified_end(modified_end);

        JushuitanOrderListRespVO respVO = jushuitanOrderCall.getOrderList(temuAcDTO, reqDTO);
        System.out.println(respVO.getRespBody());
        System.out.println(JSON.toJSON(respVO));
    }



    @Test
    void getSaleOrderList() throws Exception {
        String appKey = "ba0c1a5cd17a4d41a1e8d48e3c867419";
        String appSecret = "3381fe28080a469ab684f4e291d4f823";
        String accessToken = "9a5a8b4dfa8e46bfbb7c9b01612aa711";

        String apiUrl= "https://openapi.jushuitan.com";
        JushuitanAppClientDTO temuAcDTO = new JushuitanAppClientDTO();
        temuAcDTO.setAppKey(appKey);
        temuAcDTO.setAppSecret(appSecret);
        temuAcDTO.setAccessToken(accessToken);
        temuAcDTO.setApiUrl(apiUrl);

        //与时间条件，内部单号不能同时为空，最大限制20条
        //modified_begin	string	否	2021-12-02 10:26:25	起始时间，和结束时间必须同时存在，时间间隔不能超过七天，与线上单号，内部单号不能同时为空;tips:用时间条件查询由于查询中数据存在变动的可能会由于排序问题引发分页查询漏单的问题，建议使用ts时间戳增量查询的方式
        String modified_begin = "2025-11-20 10:26:25";

        //modified_end	string	否	2021-12-09 10:26:25	结束时间，和起始时间必须同时存在，时间间隔不能超过七天，与线上单号，内部单号不能同时为空
        String modified_end = "2025-11-24 10:26:25";
        JushuitanSaleOrderListReqDTO reqDTO = new JushuitanSaleOrderListReqDTO();
        reqDTO.setModified_begin(modified_begin);
        reqDTO.setModified_end(modified_end);

        JushuitanSaleOrderListRespVO respVO = jushuitanOrderCall.getSaleOrderList(temuAcDTO, reqDTO);
        System.out.println(respVO.getRespBody());
        System.out.println(JSON.toJSON(respVO));
    }




}
