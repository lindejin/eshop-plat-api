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
public class AeChoiceProductPostReqDTO {
    // 渠道seller id （可以在这个API中查询：global.seller.relation.query）， 请使用 business_type = ONE_STOP_SERVICE 的全托管店铺 channel_seller_id
    private String channel_seller_id;

    private Object one_stop_service_product_dto;

    // 获取属性值文本对应的多语言信息
    private String channel;

    // 全托管商品备仓类型，channel_seller_id传全托管店铺id时生效，枚举： 0（国内备仓），1（JIT类型），2（海外备仓）。目前的区别是 0和1 查询没有发货地属性，2查询有发货地属性，并且海外仓发货地必填
    private String version;
}