package com.eshop.order;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ShopeeDownloadShippingDocumentDTO {

    /**
     * Shopee 的订单唯一标识符。
     */
    private String orderSn;

    /**
     * Shopee对订单下包裹的唯一标识符。
     * 如果没有包裹编号，则不应使用空字符串填充该字段。
     */
    private String packageNumber;

    /**
     * 装运单据的类型。
     * 面单格式类型
     * NORMAL_AIR_WAYBILL：普通
     * THERMAL_AIR_WAYBILL：热敏
     * NORMAL_JOB_AIR_WAYBILL：普通，仅针对某些特殊渠道
     * THERMAL_JOB_AIR_WAYBILL：热敏，仅针对某些特殊渠道
     */
    private String shippingDocumentType;
}

