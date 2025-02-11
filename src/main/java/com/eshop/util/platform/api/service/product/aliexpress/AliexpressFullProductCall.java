package com.eshop.util.platform.api.service.product.aliexpress;


import com.eshop.util.platform.api.service.product.aliexpress.dto.*;
import com.eshop.util.platform.api.structure.aliexpress.dto.AeAppClientDTO;

/**
 * @author ldj
 * @date 2024/3/6 17:14
 * @Description: ...
 * @Version 1.0
 */
public interface AliexpressFullProductCall {

    // 1.查询全托管店铺channelSellerld     global.seller.relation.query
    String channelSellerld(AeAppClientDTO acDTO) throws Exception;

    // 2.通过channelSellerld查询有权限类目aliexpress.category.tree.list
    String categoryTreeList(AeAppClientDTO acDTO, AeCheckCategoryReqDTO reqDto) throws Exception;

    // 3.通过channelSellerld查询类目下属性和品牌信息
    String channelSellerld(AeAppClientDTO acDTO, AeProductCategoryPostReqDTO reqDto) throws Exception;

    // 4.调用统一商品发布接口                   aliexpress.choice.product.post
    String productPost(AeAppClientDTO acDTO, AeProductChoicePostReqDTO reqDto) throws Exception;

    // 5.查询全托管商品列表                       aliexpress.choice.products.list

    // 6.查询全托管商品仓库编码                aliexpress.choice.product.stocks.query

    // 全托管店铺-查询单个商品详情                aliexpress.choice.product.post
    String choiceProductQuery(AeAppClientDTO acDTO, AeProductChoiceQueryReqDTO reqDto) throws Exception;
}
