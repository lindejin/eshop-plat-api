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

import java.util.Collections;
import java.util.List;


@SpringBootTest
public class ProdJushuitanOrderCallTets {

    @Autowired
    private JushuitanOrderCall jushuitanOrderCall;


    @Test
    void getSaleOrderList() throws Exception {
        String appKey = "ba0c1a5cd17a4d41a1e8d48e3c867419";
        String appSecret = "3381fe28080a469ab684f4e291d4f823";
        String accessToken = "d494f28be7624f72be1df6c5fce55c87";

        String apiUrl= "https://openapi.jushuitan.com";
//        String apiUrl = "https://dev-api.jushuitan.com";
        JushuitanAppClientDTO temuAcDTO = new JushuitanAppClientDTO();
        temuAcDTO.setAppKey(appKey);
        temuAcDTO.setAppSecret(appSecret);
        temuAcDTO.setAccessToken(accessToken);
        temuAcDTO.setApiUrl(apiUrl);

        //与时间条件，内部单号不能同时为空，最大限制20条
        //modified_begin	string	否	2021-12-02 10:26:25	起始时间，和结束时间必须同时存在，时间间隔不能超过七天，与线上单号，内部单号不能同时为空;tips:用时间条件查询由于查询中数据存在变动的可能会由于排序问题引发分页查询漏单的问题，建议使用ts时间戳增量查询的方式
//        String modified_begin = "2025-11-20 10:26:25";

        //modified_end	string	否	2021-12-09 10:26:25	结束时间，和起始时间必须同时存在，时间间隔不能超过七天，与线上单号，内部单号不能同时为空
//        String modified_end = "2025-11-24 10:26:25";

//        List<String> so_ids = Collections.singletonList("3074543403833306664");
        List<String> so_ids = Collections.singletonList("P780067065214122851");

        JushuitanSaleOrderListReqDTO reqDTO = new JushuitanSaleOrderListReqDTO();
        reqDTO.setSo_ids(so_ids);
//        reqDTO.setModified_begin(modified_begin);
//        reqDTO.setModified_end(modified_end);

        JushuitanSaleOrderListRespVO respVO = jushuitanOrderCall.getSaleOrderList(temuAcDTO, reqDTO);
        System.out.println(respVO.getRespBody());
        System.out.println(JSON.toJSON(respVO));
    }

    @Test
    void getOrderDetailV2() throws Exception {
        String appKey = "ba0c1a5cd17a4d41a1e8d48e3c867419";
        String appSecret = "3381fe28080a469ab684f4e291d4f823";
        String accessToken = "d494f28be7624f72be1df6c5fce55c87";

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
        JushuitanOrderListReqDTO reqDTO = new JushuitanOrderListReqDTO();
        reqDTO.setModified_begin(modified_begin);
        reqDTO.setModified_end(modified_end);

        JushuitanOrderListRespVO respVO = jushuitanOrderCall.getOrderList(temuAcDTO, reqDTO);
        System.out.println(respVO.getRespBody());
        System.out.println(JSON.toJSON(respVO));
    }
}
