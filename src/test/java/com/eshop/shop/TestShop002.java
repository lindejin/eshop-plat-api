package com.eshop.shop;

import com.eshop.entity.config.TbShop;
import com.eshop.service.config.ITbShopService;
import com.eshop.util.platform.api.service.user.shop.shopee.ShopeeShopCall;
import com.eshop.util.platform.api.structure.shopee.dto.ShopeeAppClientDTO;
import com.eshop.util.shop.PlatformAppClientUtils;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.HashMap;

@SpringBootTest
public class TestShop002 {

    @Resource
    private PlatformAppClientUtils platformAppClientUtils;

    @Resource
    private ShopeeShopCall shopeeShopCall;

    @Resource
    private ITbShopService iTbShopService;

    @Test
    void getAllCategoriesAsyncAndSaveToJsonAppend() throws Exception {
        TbShop shopDO = iTbShopService.getById(2680L);
        ShopeeAppClientDTO clientDTO = platformAppClientUtils.getShopeeAppClientDTO(shopDO);
        String shopInfo = shopeeShopCall.getShopInfo(clientDTO, new HashMap<>());
        System.out.println(shopInfo);
    }


}
