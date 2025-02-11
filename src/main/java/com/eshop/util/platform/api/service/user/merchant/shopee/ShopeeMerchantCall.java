package com.eshop.util.platform.api.service.user.merchant.shopee;

import com.eshop.util.platform.api.structure.shopee.dto.ShopeeAppClientDTO;

import java.util.Map;

/**
 * @author ldj
 * @date 2024/1/24 14:45
 * @Description: ...
 * @Version 1.0
 */
public interface ShopeeMerchantCall {
    /**
     * 虾皮 按商家获取店铺清单
     */
    String getShopListByMerchant(ShopeeAppClientDTO publicDto, Map<String, Object> businessDto) throws Exception;
}
