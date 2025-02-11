package com.eshop.util.platform.api.service.user.shop.shopee;

import com.eshop.util.platform.api.structure.shopee.dto.ShopeeAppClientDTO;

import java.util.Map;

/**
 * @author ldj
 * @date 2023/7/13 15:41
 * @Description: ...
 * @Version 1.0
 */
public interface ShopeeShopCall {

    /**
     * 虾皮 获取店铺信息
     *
     * @param publicDto
     * @param businessDto
     * @return
     */
    String getShopInfo(ShopeeAppClientDTO publicDto, Map<String, Object> businessDto) throws Exception;
}
