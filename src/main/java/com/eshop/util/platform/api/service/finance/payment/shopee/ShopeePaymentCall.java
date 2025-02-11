package com.eshop.util.platform.api.service.finance.payment.shopee;

import com.alibaba.fastjson.JSONObject;
import com.eshop.util.platform.api.structure.shopee.dto.ShopeeAppClientDTO;

import java.util.Map;

/**
 * @author ldj
 * @date 2024/7/17 9:37
 * @Description: ...
 * @Version 1.0
 */
public interface ShopeePaymentCall {

    /**
     * 虾皮 使用此 API 获取订单的会计明细。
     */
    String getEscrowDetail(ShopeeAppClientDTO publicDto, Map<String, Object> businessDto) throws Exception;

    /**
     * 虾皮 使用此 API 批量获取订单的会计明细。
     */
    String getEscrowDetailBatch(ShopeeAppClientDTO publicDto, JSONObject businessDto) throws Exception;

}
