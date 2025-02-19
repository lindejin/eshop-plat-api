package com.eshop.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.eshop.entity.config.TbShop;
import com.eshop.service.config.ITbShopService;
import com.eshop.util.platform.api.service.order.temu.TemuOrderPoCall;
import com.eshop.util.platform.api.structure.temu.dto.TemuAppClientDTO;
import com.eshop.util.platform.call.order.temu.TemuOrderPoCallService;
import com.eshop.util.platform.call.order.temu.dto.TemuOrderPoLogisticsCompaniesGetReqDTO;
import com.eshop.util.platform.call.order.temu.vo.TemuOrderPoLogisticsCompaniesGetRespVO;
import com.eshop.util.shop.PlatformAppClientUtils;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
public class TemuOrderPoCallTest {

    @Resource
    private TemuOrderPoCall temuOrderPoCall;

    @Resource
    private PlatformAppClientUtils platformAppClientUtils;

    @Resource
    private ITbShopService shopService;

    /**
     * 指定店铺id 获取temu店铺物流商
     */
    @Test
    void getModeList() throws Exception {
        TbShop shopDO = shopService.getById(1955L);
        TemuAppClientDTO us = platformAppClientUtils.getTemuAppClientDTO(shopDO, "US");
        JSONObject params = new JSONObject();
        params.put("regionId", 211);
        String respBody = temuOrderPoCall.logisticsCompaniesGet(us, params);
        System.out.println(respBody);
    }

    @Resource
    private TemuOrderPoCallService temuOrderPoCallService;

    @Test
    void logisticsCompaniesGet() throws Exception {
        TbShop shopDO = shopService.getById(1955L);
        TemuAppClientDTO us = platformAppClientUtils.getTemuAppClientDTO(shopDO, "US");
        TemuOrderPoLogisticsCompaniesGetReqDTO params = new TemuOrderPoLogisticsCompaniesGetReqDTO();
        params.setRegionId(211L);
        TemuOrderPoLogisticsCompaniesGetRespVO respVO = temuOrderPoCallService.logisticsCompaniesGet(us, params);
        System.out.println(JSON.toJSONString(respVO));
    }

    /**
     * 指定店铺id 获取temu店铺物流商
     */
    @Test
    void getOrderShippingInfo() throws Exception {
        TbShop shopDO = shopService.getById(1722L);
        TemuAppClientDTO us = platformAppClientUtils.getTemuAppClientDTO(shopDO, "GL");
        JSONObject params = new JSONObject();
        params.put("parentOrderSn", "PO-100-09998279782950932");
        String respBody = temuOrderPoCall.getOrderShippingInfo(us, params);
        System.out.println(respBody);
    }
}
