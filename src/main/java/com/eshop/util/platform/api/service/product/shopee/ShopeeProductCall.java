package com.eshop.util.platform.api.service.product.shopee;

import com.alibaba.fastjson.JSONObject;
import com.eshop.util.platform.api.structure.shopee.dto.ShopeeAppClientDTO;

import java.util.Map;

/**
 * @author ldj
 * @date 2023/3/24 14:01
 * @Description: 虾皮产品 调用服务
 * @Version 1.0
 */
public interface ShopeeProductCall {

    /**
     * 虾皮 产品刊登（基础部分）
     * @param publicDto
     * @param businessDto
     * @return
     */
    String postProduct(ShopeeAppClientDTO publicDto, JSONObject businessDto) throws Exception;

    /**
     * 虾皮 产品刊登 更新
     * @param publicDto
     * @param businessDto
     * @return
     */
    String updateProduct(ShopeeAppClientDTO publicDto, JSONObject businessDto) throws Exception;

    /**
     * 虾皮 产品刊登（变体部分）
     * @param publicDto
     * @param businessDto
     * @return
     */
    String postProductSku(ShopeeAppClientDTO publicDto, JSONObject businessDto) throws Exception;

    /**
     * 虾皮 产品model刊登 更新
     * @param publicDto
     * @param businessDto
     * @return
     */
    String updateProductSku(ShopeeAppClientDTO publicDto, JSONObject businessDto) throws Exception;

    /**
     * 虾皮 获取产品列表
     * @param publicDto
     * @param businessDto
     * @return
     */
    String getProductList(ShopeeAppClientDTO publicDto, Map<String, Object> businessDto) throws Exception;

    /**
     * 虾皮 获取项目的基础信息
     * @param publicDto
     * @param businessDto
     * @return
     */
    String getProductDetail(ShopeeAppClientDTO publicDto, Map<String, Object> businessDto) throws Exception;

    /**
     * 虾皮 获取产品model列表
     * @param publicDto
     * @param businessDto
     * @return
     */
    String getProductSkuList(ShopeeAppClientDTO publicDto, Map<String, Object> businessDto) throws Exception;


    /**
     * 虾皮 获取项目的额外信息
     * @param publicDto
     * @param businessDto
     * @return
     */
    String getProductExtraInfo(ShopeeAppClientDTO publicDto, Map<String, Object> businessDto) throws Exception;

    /**
     * 虾皮 删除产品
     * @param publicDto
     * @param businessDto
     * @return
     */
    String deleteProduct(ShopeeAppClientDTO publicDto, JSONObject businessDto) throws Exception;

    /**
     * 虾皮 产品刊登 更新变体价格
     * @param publicDto
     * @param businessDto
     * @return
     */
    String updateProductSkuPrice(ShopeeAppClientDTO publicDto, JSONObject businessDto) throws Exception;

    /**
     * 根据类目id获取产品属性
     *
     * @param publicDto
     * @param businessDto
     * @return
     */
    String getCategoryAttributes(ShopeeAppClientDTO publicDto, Map<String, Object> businessDto) throws Exception;

    /**
     * 根据店铺id获取 物流渠道
     *
     * @param publicDto
     * @param businessDto
     * @return
     */
    String getChannelList(ShopeeAppClientDTO publicDto, Map<String, Object> businessDto) throws Exception;

    /**
     * 根据店铺id获取 品牌
     *
     * @param publicDto
     * @param businessDto
     * @return
     */
    String getBrandList(ShopeeAppClientDTO publicDto, Map<String, Object> businessDto) throws Exception;

    /**
     * 根据店铺id获取 产品上传限制。
     *
     * @param publicDto
     * @param businessDto
     * @return
     */
    String getItemLimit(ShopeeAppClientDTO publicDto, Map<String, Object> businessDto) throws Exception;

    /**
     * 根据店铺id获取 获取类别是否支持尺寸表
     *
     * @param publicDto
     * @param businessDto
     * @return
     */
    String getSupportSizeChart(ShopeeAppClientDTO publicDto, Map<String, Object> businessDto) throws Exception;

    /**
     * 更新商品的尺码表。
     * API 将于 2024.12.27 停用，请尽快改用 v2.product.add_item 和 v2.product.update_item 设置和更新产品的尺码表。
     */
    String updateSizeChart(ShopeeAppClientDTO publicDto, JSONObject businessDto) throws Exception;

    /**
     * 获取新大小的尺码列表。现在只支持本地商店使用新尺码表。
     */
    String getSizeChartList(ShopeeAppClientDTO publicDto, Map<String, Object> businessDto) throws Exception;

    /**
     * 获取新的尺码表详细信息。现在只有本地商店支持使用此 api 获取新的尺码表详细信息。
     */
    String getSizeChartDetail(ShopeeAppClientDTO publicDto, Map<String, Object> businessDto) throws Exception;
}
