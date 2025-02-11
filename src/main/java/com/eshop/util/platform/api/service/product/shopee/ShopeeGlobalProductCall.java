package com.eshop.util.platform.api.service.product.shopee;

import com.alibaba.fastjson.JSONObject;
import com.eshop.util.platform.api.structure.shopee.dto.ShopeeAppClientDTO;

import java.util.Map;

/**
 * @author ldj
 * @date 2024/1/22 14:05
 * @Description: ...
 * @Version 1.0
 */
public interface ShopeeGlobalProductCall {

    /**
     * 虾皮全球 获取产品列表
     */
    String getGlobalItemList(ShopeeAppClientDTO acDTO, Map<String, Object> businessDto) throws Exception;

    /**
     * 虾皮全球 获取项目的基础信息
     */
    String getGlobalItemBaseInfo(ShopeeAppClientDTO acDTO, Map<String, Object> businessDto) throws Exception;

    /**
     * 虾皮全球 获取产品model列表
     */
    String getGlobalModelList(ShopeeAppClientDTO acDTO, Map<String, Object> businessDto) throws Exception;

    /**
     * 虾皮全球 通过item_id获取get_global_item_id。仅适用于中国大陆卖家和韩国卖家。
     */
    String getGlobalItemId(ShopeeAppClientDTO acDTO, Map<String, Object> businessDto) throws Exception;

    /**
     *  创建全球商品
     *
     */
    String addGlobalItem(ShopeeAppClientDTO acDTO, JSONObject businessDto) throws Exception;
    /**
     * 创建全球商品变体
     *
     */
    String initTierVariation(ShopeeAppClientDTO acDTO, JSONObject paramsJson) throws Exception;

    /**
     * 获取推荐类目
     *
     */
    String getCategoryRecommend(ShopeeAppClientDTO acDTO, Map<String, Object> paramsMap) throws Exception;

    /**
     * 获取全球商品推荐属性
     *
     */
    String getRecommendAttribute(ShopeeAppClientDTO acDTO, Map<String, Object> paramsMap) throws Exception;

    /**
     * 获取类目属性
     *
     */
    String getAttributes(ShopeeAppClientDTO acDTO, Map<String, Object> paramsMap) throws Exception;
    /**
     * 获取品牌信息
     *
     */
    String getBrandList(ShopeeAppClientDTO acDTO, Map<String, Object> paramsMap) throws Exception;

    /**
     * 获取全球商品发货天数
     */
    String getDtsLimit(ShopeeAppClientDTO acDTO, Map<String, Object> paramsMap) throws Exception;

    /**
     * 全球商品类目是否支持尺寸表数据
     */
    String supportSizeChart(ShopeeAppClientDTO acDTO, Map<String, Object> paramsMap) throws Exception;

    /**
     * 更新商品的尺码表
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

    /**
     * 获取全球商品数据限制
     */
    String getGlobalItemLimit(ShopeeAppClientDTO acDTO, Map<String, Object> paramsMap) throws Exception;

    /**
     *   获取可发布店铺列表
     *
     */
    String getPublishableShop(ShopeeAppClientDTO acDTO, Map<String, Object> paramsMap) throws Exception;

    /**
     *   发布全球商品任务
     *
     */
    String createPublishTask(ShopeeAppClientDTO acDTO, JSONObject paramsJson) throws Exception;

    /**
     *   返回发布任务成功与否
     *   如果成功，将会返回发布成功的item_id、shop_id和region信息，如果失败将会返回具体的失败原因。请注意：如果发布的店铺是SIP主店铺，则发布成功之后，Shopee会自动发布此全球商品到这个主店铺下的附属店铺。
     *
     */
    String getPublishTaskResult(ShopeeAppClientDTO acDTO, Map<String, Object> businessDto) throws Exception;

    /**
     * 虾皮全球商品
     * 获取已发布店铺商品列表
     */
    String getPublishedList(ShopeeAppClientDTO acDTO, Map<String, Object> businessDto) throws Exception;

    /**
     * 删除全球商品
     *
     */
    String deleteGlobalProduct(ShopeeAppClientDTO acDTO, Long globalItemId) throws Exception;

    /**
     *  获取店铺商户仓库位置列表
     *
     */
    String getMerchantWarehouseLocationList(ShopeeAppClientDTO acDTO) throws Exception;

    /**
     * 获取全球类目
     */
    String getGlobalCategoryList(ShopeeAppClientDTO acDTO, Map<String, Object> businessDto) throws Exception;
}
