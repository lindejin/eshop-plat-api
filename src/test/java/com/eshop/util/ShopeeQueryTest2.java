package com.eshop.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.eshop.entity.config.TbShop;
import com.eshop.service.config.ITbShopService;
import com.eshop.util.platform.api.service.order.shopee.ShopeeOrderCall;
import com.eshop.util.platform.api.structure.shopee.dto.ShopeeAppClientDTO;
import com.eshop.util.shop.PlatformAppClientUtils;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.List;

@SpringBootTest
public class ShopeeQueryTest2 {

    @Resource
    private ShopeeQueryTest shopeeQueryTest;

    @Resource
    private PlatformAppClientUtils platformAppClientUtils;

    @Resource
    private ITbShopService iTbShopService;

    @Test
    void contextLoads() throws Exception {
        TbShop shopDO = iTbShopService.getById()

        ShopeeAppClientDTO publicDTO = platformAppClientUtils.getShopeeAppClientDTO(shopDO);
        String orderNo = "250208MXFF5MHP";

        ShopeeOrderDetailRespVO respVO = shopeeQueryTest.getOrderDetail(publicDTO, orderNo);
        System.out.println(respVO.getRespBody());
    }
}
