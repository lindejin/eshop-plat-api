package com.eshop.order;

import com.eshop.service.config.ITbShopService;
import com.eshop.util.platform.api.service.logistics.shopee.ShopeeLogisticsCall;
import com.eshop.util.shop.PlatformAppClientUtils;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
public class ApiShopeeLogisticsSyncServiceTest3 {

    @Resource
    private PlatformAppClientUtils platformAppClientUtils;

//    @Resource
//    private ITbOrderBillPlatformService iTbOrderBillPlatformService;

    @Resource
    private ITbShopService iTbShopService;

    @Test
    void contextLoads() throws Exception {

    }
}
