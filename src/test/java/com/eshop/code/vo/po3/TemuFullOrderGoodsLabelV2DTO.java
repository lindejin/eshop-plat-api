package com.eshop.code.vo.po3;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class TemuFullOrderGoodsLabelV2DTO {

    /**
     * 说明:货品sku id列表
     * 是否必填:false
     * 类型标识:8，类型:list
     */
    private List<Long> productSkuIdList;

    /**
     * 说明:skc货号
     * 是否必填:false
     * 类型标识:4，类型:string
     */
    private String skcExtCode;

    /**
     * 说明:货品skc id列表
     * 是否必填:false
     * 类型标识:8，类型:list
     */
    private List<Long> productSkcIdList;

    /**
     * 说明:页面大小
     * 是否必填:false
     * 类型标识:1，类型:long
     */
    private Long pageSize;

    /**
     * 说明:sku货号
     * 是否必填:false
     * 类型标识:4，类型:string
     */
    private String skuExtCode;

    /**
     * 说明:页码
     * 是否必填:false
     * 类型标识:1，类型:long
     */
    private Long page;

    /**
     * 说明:标签条码
     * 是否必填:false
     * 类型标识:1，类型:long
     */
    private Long labelCode;


}