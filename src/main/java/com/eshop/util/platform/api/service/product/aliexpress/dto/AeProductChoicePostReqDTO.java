package com.eshop.util.platform.api.service.product.aliexpress.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * @author rch
 * @date 2024/6/21 14:57
 * @Version 1.0
 */
@Getter
@Setter
public class AeProductChoicePostReqDTO {
    // 渠道seller id （可以在这个API中查询：global.seller.relation.query）， 请使用 business_type = ONE_STOP_SERVICE 的全托管店铺 channel_seller_id
    private String channel_seller_id;
    // 商品模型
    private AeOneStopServiceProductPostReqDTO one_stop_service_product_dto;

    // 渠道（可以在这个API中查询：global.seller.relation.query）
    private String channel;

    // version 版本号。不传默认是1。 1代表商货融合之前的版本，不能自动创建货品； 2 代表商货融合的版本，需要做货品信息的参数校验，发品成功自动商货绑定。
    private String version;
}