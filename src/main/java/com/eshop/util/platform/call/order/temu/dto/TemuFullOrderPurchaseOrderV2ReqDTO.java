package com.eshop.util.platform.call.order.temu.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class TemuFullOrderPurchaseOrderV2ReqDTO {
    /**
     * 说明:下单时间-结束：毫秒
     * 是否必填:false
     * 类型标识:1，类型:long
     */
    private Long purchaseTimeTo;

    /**
     * 说明:skc列表
     * 是否必填:false
     * 类型标识:8，类型:list
     */
    private List<Long> productSkcIdList;

    /**
     * 说明:要求最晚到达时间-开始（时间戳 单位：毫秒）
     * 是否必填:false
     * 类型标识:1，类型:long
     */
    private Long expectLatestArrivalTimeFrom;

    /**
     * 说明:母订单号列表
     * 是否必填:false
     * 类型标识:8，类型:list
     */
    private List<String> originalPurchaseOrderSnList;

    /**
     * 说明:发货或者到货逾期状态 101-发货即将逾期，102-发货已逾期，201-到货即将逾期，202-到货已逾期
     * 是否必填:false
     * 类型标识:8，类型:list
     */
    private List<Long> deliverOrArrivalDelayStatusList;

    /**
     * 说明:每页记录数,范围[1,500]
     * 是否必填:true
     * 类型标识:1，类型:long
     */
    private Long pageSize;

    /**
     * 说明:是否延迟到货
     * 是否必填:false
     * 类型标识:5，类型:boolean
     */
    private Boolean isDelayArrival;

    /**
     * 说明:标签：1-含缺货SKU；2-含售罄SKU
     * 是否必填:false
     * 类型标识:8，类型:list
     */
    private List<Long> lackOrSoldOutTagList;

    /**
     * 说明:创单时是否存在质检不合格sku，0-不存在 1-存在
     * 是否必填:false
     * 类型标识:1，类型:long
     */
    private Long qcReject;

    /**
     * 说明:是否系统下单 是-系统自动下单 否-其他
     * 是否必填:false
     * 类型标识:5，类型:boolean
     */
    private Boolean isSystemAutoPurchaseSource;

    /**
     * 说明:是否首单 0-否 1-是
     * 是否必填:false
     * 类型标识:5，类型:boolean
     */
    private Boolean isFirst;

    /**
     * 说明:是否是JIT备货， 0-普通，1-JIT备货
     * 是否必填:false
     * 类型标识:1，类型:long
     */
    private Long purchaseStockType;

    /**
     * 说明:页号， 从1开始
     * 是否必填:true
     * 类型标识:1，类型:long
     */
    private Long pageNo;

    /**
     * 说明:是否延迟发货
     * 是否必填:false
     * 类型标识:5，类型:boolean
     */
    private Boolean isDelayDeliver;

    /**
     * 说明:备货仓组列表
     * 是否必填:false
     * 类型标识:8，类型:list
     */
    private List<Long> warehouseGroupIdList;

    /**
     * 说明:订单号（采购子单号）
     * 是否必填:false
     * 类型标识:8，类型:list
     */
    private List<String> subPurchaseOrderSnList;

    /**
     * 说明:定制类型,0-文字，1-图片. 可选值含义说明:[0:文字;1:图片;]
     * 是否必填:false
     * 类型标识:1，类型:long
     */
    private Long customizationType;

    /**
     * 说明:筛选的商品条码样式，0-全选，1-旧样式，2-新样式
     * 是否必填:false
     * 类型标识:1，类型:long
     */
    private Long productLabelCodeStyle;

    /**
     * 说明:是否JIT转备货
     * 是否必填:false
     * 类型标识:5，类型:boolean
     */
    private Boolean isCloseJit;

    /**
     * 说明:创单时是否存在缺货sku，0-不存在 1-存在
     * 是否必填:false
     * 类型标识:1，类型:long
     */
    private Long skuLackSnapshot;

    /**
     * 说明:结算类型 0-非vmi(采购) 1-vmi(备货)
     * 是否必填:false
     * 类型标识:1，类型:long
     */
    private Long settlementType;

    /**
     * 说明:店铺名称
     * 是否必填:false
     * 类型标识:4，类型:string
     */
    private String supplierName;

    /**
     * 说明:货号列表
     * 是否必填:false
     * 类型标识:8，类型:list
     */
    private List<String> productSnList;

    /**
     * 说明:下单时间-开始：毫秒
     * 是否必填:false
     * 类型标识:1，类型:long
     */
    private Long purchaseTimeFrom;

    /**
     * 说明:是否紧急 0-否 1-是
     * 是否必填:false
     * 类型标识:1，类型:long
     */
    private Long urgencyType;

    /**
     * 说明:下单来源，0-运营下单，1-卖家下单，9999-平台下单
     * 是否必填:false
     * 类型标识:8，类型:list
     */
    private List<Long> sourceList;

    /**
     * 说明:发货单号列表
     * 是否必填:false
     * 类型标识:8，类型:list
     */
    private List<String> deliverOrderSnList;

    /**
     * 说明:要求最晚发货时间-结束（时间戳 单位：毫秒）
     * 是否必填:false
     * 类型标识:1，类型:long
     */
    private Long expectLatestDeliverTimeTo;

    /**
     * 说明:要求最晚发货时间-开始（时间戳 单位：毫秒）
     * 是否必填:false
     * 类型标识:1，类型:long
     */
    private Long expectLatestDeliverTimeFrom;

    /**
     * 说明:店铺id列表
     * 是否必填:false
     * 类型标识:8，类型:list
     */
    private List<Long> supplierIdList;

    /**
     * 说明:是否今日可发货
     * 是否必填:false
     * 类型标识:5，类型:boolean
     */
    private Boolean todayCanDeliver;

    /**
     * 说明:要求最晚到达时间-结束（时间戳 单位：毫秒）
     * 是否必填:false
     * 类型标识:1，类型:long
     */
    private Long expectLatestArrivalTimeTo;

    /**
     * 说明:订单状态 0-待接单；1-已接单，待发货；2-已送货；3-已收货；4-已拒收；5-已验收，全部退回；6-已验收；7-已入库；8-作废；9-已超时
     * 是否必填:false
     * 类型标识:8，类型:list
     */
    private List<Long> statusList;

    /**
     * 说明:是否为定制品
     * 是否必填:false
     * 类型标识:5，类型:boolean
     */
    private Boolean isCustomGoods;

    /**
     * 说明:是否存在质检不合格的sku，10-是，20-否
     * 是否必填:false
     * 类型标识:1，类型:long
     */
    private Long qcOption;
}
