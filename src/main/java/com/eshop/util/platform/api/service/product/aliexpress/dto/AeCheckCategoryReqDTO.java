package com.eshop.util.platform.api.service.product.aliexpress.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author rch
 * @date 2024/6/21
 * @Description: 获取指定类目下的子类目信息（可校验卖家权限）
 * @Version 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AeCheckCategoryReqDTO {

    // 不传默认查询对应的AE的普通账号数据，渠道seller id （可以在这个API中查询：global.seller.relation.query）， 请使用 business_type = ONE_STOP_SERVICE 的全托管店铺 channel_seller_id
    private Long channelSellerId;

    // 是否只查询有权限的类目
    private Boolean onlyWithPermission;

    // 渠道（可以在这个API中查询：global.seller.relation.query）
    private String channel;

    // 类目id
    private Long categoryId;
}
