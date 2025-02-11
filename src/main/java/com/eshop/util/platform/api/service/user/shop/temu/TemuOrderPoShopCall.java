package com.eshop.util.platform.api.service.user.shop.temu;

import com.alibaba.fastjson.JSONObject;
import com.eshop.util.platform.api.structure.temu.dto.TemuAppClientDTO;

public interface TemuOrderPoShopCall {

    /**
     * 查询店铺权限
     * US/EU
     */
    String openAccessTokenInfoGet(TemuAppClientDTO publicDto, JSONObject businessDto) throws Exception;
}
