package com.eshop.util.platform.api.service.order.shopee;

import com.alibaba.fastjson.JSONObject;
import com.eshop.util.platform.api.structure.shopee.dto.ShopeeAppClientDTO;

import java.util.Map;

/**
 * @author ldj
 * @date 2023/6/26 16:44
 * @Description: ...
 * @Version 1.0
 */
public interface ShopeeOrderCall {

    /**
     * 获取订单列表
     *
     * @param publicDto
     * @param businessDto
     * @return
     */
    String getOrderList(ShopeeAppClientDTO publicDto, Map<String, Object> businessDto) throws Exception;

    /**
     * 获取订单详情
     *
     * @param publicDto
     * @param businessDto
     * @return
     */
    String getOrderDetail(ShopeeAppClientDTO publicDto, Map<String, Object> businessDto) throws Exception;

    /**
     * 虾皮  用于卖家取消订单。
     */
    String cancelOrder(ShopeeAppClientDTO publicDto, JSONObject businessDto) throws Exception;

    /**
     * 虾皮 用于处理买家取消订单的申请。
     */
    String handleBuyerCancellation(ShopeeAppClientDTO publicDto, JSONObject businessDto) throws Exception;
}
