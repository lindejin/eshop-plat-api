package com.eshop.util.platform.api.service.product.aliexpress.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * @author rch
 * @date 2024/6/21 14:57
 * @desc 商品模型
 * @Version 1.0
 */
@Getter
@Setter
public class AeOneStopServiceProductPostReqDTO {
    // 媒体信息
    private AeMultimediaProductPostReqDTO multimedia;

    // sku列表  product_sku_list
    private List<AeProductSkuPostReqDTO> product_sku_list;

    // 包裹信息 package_dto
    private AePackagePostReqDTO package_dto;

    // 商品基本信息  product_info_dto
    private AeProductInfoPostReqDTO product_info_dto;

    // 扩展信息 product_ext_dto
    private AeProductExtPostReqDTO product_ext_dto;

    // 商品属性列表   product_property_list
    private List<AeProductPropertyPostReqDTO> product_property_list;

    // 详描列表 detail_source_list
    private List<AeDetailSourcePostReqDTO> detail_source_list;
}