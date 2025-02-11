package com.eshop.util.platform.api.service.marketing.shopee;

import com.alibaba.fastjson.JSONObject;
import com.eshop.util.platform.api.structure.shopee.dto.ShopeeAppClientDTO;

/**
 * @author ldj
 * @date 2023/3/23 9:54
 * @Description: 虾皮折扣活动 调用服务
 * @Version 1.0
 */
public interface ShopeeDiscountCall {

    /**
     * 创建折扣活动
     *
     * @param publicDto
     * @param businessDto
     * @return
     */
    String createDiscount(ShopeeAppClientDTO publicDto, JSONObject businessDto) throws Exception;

    /**
     * 商品绑定折扣活动
     *
     * @param publicDto
     * @param businessDto
     * @return
     */
    String createDiscountItem(ShopeeAppClientDTO publicDto, JSONObject businessDto) throws Exception;

    /**
     * 删除折扣活动
     *
     * @param publicDto
     * @param businessDto
     * @return
     */
    String removeDiscount(ShopeeAppClientDTO publicDto, JSONObject businessDto) throws Exception;

    /**
     * 商品删除折扣活动
     *
     * @param publicDto
     * @param businessDto
     * @return
     */
    String removeDiscountItem(ShopeeAppClientDTO publicDto, JSONObject businessDto) throws Exception;
}
