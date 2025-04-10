package com.eshop.util.platform.call.order.temu.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class TemuFullGoodsLabelV2ReqDTO {
    /**
     * 页码，限制 page×pageSize 要小于10000
     */
    private Long page;

    /**
     * 页面大小，限制 page×pageSize 要小于10000
     */
    private Long pageSize;

    /**
     * 货品SKU ID列表（非必须）
     */
    private List<Long> productSkuIdList;

    /**
     * SKC货号（非必须）
     */
    private String skcExtCode;

    /**
     * 货品SKC ID列表（非必须）
     */
    private List<Long> productSkcIdList;

    /**
     * SKU货号（非必须）
     */
    private String skuExtCode;

    /**
     * 标签条码（非必须）
     */
    private Long labelCode;

    /**
     * 是否以打印页面URL返回（非必须）
     * 若值为'true'，则返回dataKey，通过拼接URL访问打印页面；
     * 其他情况返回参数信息，需自行组装条码
     */
    private String return_data_key;
}
