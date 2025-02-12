package com.eshop.util;

import com.alibaba.fastjson.JSON;
import com.eshop.entity.config.TbShop;
import com.eshop.service.config.ITbShopService;
import com.eshop.util.platform.api.service.order.temu.TemuOrderPoCall;
import com.eshop.util.platform.api.structure.temu.dto.TemuAppClientDTO;
import com.eshop.util.shop.PlatformAppClientUtils;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
public class PlatformAppClientUtilsTest {

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
        System.out.println(JSON.toJSONString(us));
    }
}
