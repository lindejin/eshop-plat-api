package com.eshop.util.platform.call.order.temu.vo;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class TemuFullOrderPurchaseOrderV2RespVO {

    //返回总数据Body
    private String respBody;

    /**
     * 说明:null
     * 是否必填:false
     * 类型标识:6，类型:object
     */
    private TemuPurchaseOrderV2Result result;

    /**
     * 说明:null
     * 是否必填:false
     * 类型标识:5，类型:boolean
     */
    private Boolean success;

    /**
     * 说明:null
     * 是否必填:false
     * 类型标识:1，类型:long
     */
    private Long errorCode;

    /**
     * 说明:null
     * 是否必填:false
     * 类型标识:4，类型:string
     */
    private String errorMsg;


    @Getter
    @Setter
    public static class TemuPurchaseOrderV2Result {
        /**
         * 说明:总数
         * 是否必填:false
         * 类型标识:1，类型:long
         */
        private Long total;

        /**
         * 说明:订单信息
         * 是否必填:false
         * 类型标识:8，类型:list
         */
        private List<SubOrderForSupplierListItem> subOrderForSupplierList;

    }

    @Getter
    @Setter
    public static class SubOrderForSupplierListItem {
        /**
         * 说明:母订单号（原始采购母单号）
         * 是否必填:false
         * 类型标识:4，类型:string
         */
        private String originalPurchaseOrderSn;

        /**
         * 说明:下单来源；0-运营，1-供应商，2-系统, 3-excel上传, 4-系统规则
         * 是否必填:false
         * 类型标识:1，类型:long
         */
        private Long source;

        /**
         * 说明:货品名称
         * 是否必填:false
         * 类型标识:4，类型:string
         */
        private String productName;

        /**
         * 说明:关联履约函状态，0-待确认，1-已确认，2-已拒绝，3-已取消
         * 是否必填:false
         * 类型标识:1，类型:long
         */
        private Long fulfilmentFormStatus;

        /**
         * 说明:是否首单
         * 是否必填:false
         * 类型标识:5，类型:boolean
         */
        private Boolean isFirst;

        /**
         * 说明:sku维度数量信息-非定制品
         * 是否必填:false
         * 类型标识:8，类型:list
         */
        private List<SkuQuantityDetailListItem> skuQuantityDetailList;

        /**
         * 说明:发货信息
         * 是否必填:false
         * 类型标识:6，类型:object
         */
        private TemuPurchaseOrderV2DeliverInfo deliverInfo;

        /**
         * 说明:skcId
         * 是否必填:false
         * 类型标识:1，类型:long
         */
        private Long productSkcId;

        /**
         * 说明:是否JIT转备货
         * 是否必填:false
         * 类型标识:5，类型:boolean
         */
        private Boolean isCloseJit;

        /**
         * 说明:备货仓组
         * 是否必填:false
         * 类型标识:1，类型:long
         */
        private Long warehouseGroupId;

        /**
         * 说明:productId
         * 是否必填:false
         * 类型标识:1，类型:long
         */
        private Long productId;

        /**
         * 说明:是否有质检报告，0-否，1-是
         * 是否必填:false
         * 类型标识:1，类型:long
         */
        private Long hasQcBill;

        /**
         * 说明:供应状态 0-正常供货 1-暂时无货 2-停产
         * 是否必填:false
         * 类型标识:1，类型:long
         */
        private Long supplyStatus;

        /**
         * 说明:申请作废状态 0-未申请作废，1-作废审核中，2-作废审核通过, 3-作废审核不通过
         * 是否必填:false
         * 类型标识:1，类型:long
         */
        private Long applyDeleteStatus;

        /**
         * 说明:sku维度数量汇总信息
         * 是否必填:false
         * 类型标识:6，类型:object
         */
        private TemuPurchaseOrderV2SkuQuantityTotalInfo skuQuantityTotalInfo;

        /**
         * 说明:是否可以加入发货台
         * 是否必填:false
         * 类型标识:5，类型:boolean
         */
        private Boolean isCanJoinDeliverPlatform;

        /**
         * 说明:类目类型, 0-未分类、1-服饰
         * 是否必填:false
         * 类型标识:1，类型:long
         */
        private Long categoryType;

        /**
         * 说明:采购子单号
         * 是否必填:false
         * 类型标识:4，类型:string
         */
        private String subPurchaseOrderSn;

        /**
         * 说明:状态
         * 是否必填:false
         * 类型标识:1，类型:long
         */
        private Long status;

        /**
         * 说明:卖家id
         * 是否必填:false
         * 类型标识:1，类型:long
         */
        private Long supplierId;

        /**
         * 说明:是否定制品，0-否，1-是
         * 是否必填:false
         * 类型标识:5，类型:boolean
         */
        private Boolean isCustomProduct;

        /**
         * 说明:申述状态，1000-审核中,1010-审核通过,1020-审核驳回
         * 是否必填:false
         * 类型标识:1，类型:long
         */
        private Long appealStatus;

        /**
         * 说明:关联履约函id
         * 是否必填:false
         * 类型标识:1，类型:long
         */
        private Long fulfilmentFormId;

        /**
         * 说明:货品图片
         * 是否必填:false
         * 类型标识:4，类型:string
         */
        private String productSkcPicture;

        /**
         * 说明:是否支持上浮
         * 是否必填:false
         * 类型标识:5，类型:boolean
         */
        private Boolean supportIncreaseNum;

        /**
         * 说明:是否含缺货或售罄sku
         * 是否必填:false
         * 类型标识:8，类型:list
         */
        private List<LackOrSoldOutTagListItem> lackOrSoldOutTagList;

        /**
         * 说明:创单时是否存在质检不合格sku，0-不存在 1-存在
         * 是否必填:false
         * 类型标识:1，类型:long
         */
        private Long qcReject;

        /**
         * 说明:是否是JIT备货， 0-普通，1-JIT备货
         * 是否必填:false
         * 类型标识:1，类型:long
         */
        private Long purchaseStockType;

        /**
         * 说明:缺货sku列表
         * 是否必填:false
         * 类型标识:8，类型:list
         */
        private List<SkuLackItemListItem> skuLackItemList;

        /**
         * 说明:发货单号
         * 是否必填:false
         * 类型标识:4，类型:string
         */
        private String deliveryOrderSn;

        /**
         * 说明:创单时是否存在缺货sku，0-不存在 1-存在
         * 是否必填:false
         * 类型标识:1，类型:long
         */
        private Long skuLackSnapshot;

        /**
         * 说明:卖家名称
         * 是否必填:false
         * 类型标识:4，类型:string
         */
        private String supplierName;

        /**
         * 说明:结算类型 0-非vmi(采购) 1-vmi(备货)
         * 是否必填:false
         * 类型标识:1，类型:long
         */
        private Long settlementType;

        /**
         * 说明:货号
         * 是否必填:false
         * 类型标识:4，类型:string
         */
        private String productSn;

        /**
         * 说明:是否紧急，0-否，1-是
         * 是否必填:false
         * 类型标识:1，类型:long
         */
        private Long urgencyType;

        /**
         * 说明:质量隐患sku列表
         * 是否必填:false
         * 类型标识:8，类型:list
         */
        private List<SkuQcRejectItemListItem> skuQcRejectItemList;

        /**
         * 说明:预计最晚送达间隔天数
         * 是否必填:false
         * 类型标识:1，类型:long
         */
        private Long expectLatestArrivalIntervalDays;

        /**
         * 说明:退货时间（时间戳 单位：毫秒）
         * 是否必填:false
         * 类型标识:1，类型:long
         */
        private Long defectiveTime;

        /**
         * 说明:是否今日可发货
         * 是否必填:false
         * 类型标识:5，类型:boolean
         */
        private Boolean todayCanDeliver;

        /**
         * 说明:下单时间（时间戳：毫秒）
         * 是否必填:false
         * 类型标识:1，类型:long
         */
        private Long purchaseTime;

        /**
         * 说明:申请变更供应状态的审批状态, 0-无需审核，1-审核中，2-审核通过，3-审核驳回，4-撤销
         * 是否必填:false
         * 类型标识:1，类型:long
         */
        private Long applyChangeSupplyStatus;

        /**
         * 说明:类目
         * 是否必填:false
         * 类型标识:4，类型:string
         */
        private String category;

    }

    @Getter
    @Setter
    public static class SkuQuantityDetailListItem {
        /**
         * 说明:货币类型(参考 ISO 4217)  CNY-人民币 USD-美元
         * 是否必填:false
         * 类型标识:4，类型:string
         */
        private String currencyType;

        /**
         * 说明:定制品工艺信息
         * 是否必填:false
         * 类型标识:6，类型:object
         */
        private TemuPurchaseOrderV2ProcessTypeVO processTypeVO;

        /**
         * 说明:尺码名称
         * 是否必填:false
         * 类型标识:4，类型:string
         */
        private String className;

        /**
         * 说明:是否支持上浮
         * 是否必填:false
         * 类型标识:5，类型:boolean
         */
        private Boolean supportIncreaseNum;

        /**
         * 说明:入库数量
         * 是否必填:false
         * 类型标识:1，类型:long
         */
        private Long realReceiveAuthenticQuantity;

        /**
         * 说明:履约货品skuId
         * 是否必填:false
         * 类型标识:1，类型:long
         */
        private Long fulfilmentProductSkuId;

        /**
         * 说明:定制类型,0-文字，1-图片
         * 是否必填:false
         * 类型标识:1，类型:long
         */
        private Long customizationType;

        /**
         * 说明:productSkuId
         * 是否必填:false
         * 类型标识:1，类型:long
         */
        private Long productSkuId;

        /**
         * 说明:已送货待收货数量
         * 是否必填:false
         * 类型标识:1，类型:long
         */
        private Long deliverQuantity;

        /**
         * 说明:sku缩略图列表
         * 是否必填:false
         * 类型标识:8，类型:list
         */
        private List<String> thumbUrlList;

        /**
         * 说明:质检结果，0-暂无结果，1-合格，2-不合格，3-无需质检，4-质检让步，5-重新上床视频，6-部分合格
         * 是否必填:false
         * 类型标识:1，类型:long
         */
        private Long qcResult;

        /**
         * 说明:sku货号
         * 是否必填:false
         * 类型标识:4，类型:string
         */
        private String extCode;

        /**
         * 说明:下单时建议量
         * 是否必填:false
         * 类型标识:1，类型:long
         */
        private Long adviceQuantity;

        /**
         * 说明:下单上限（系统自动下单时按照规则设置）
         * 是否必填:false
         * 类型标识:1，类型:long
         */
        private Long purchaseUpLimit;

        /**
         * 说明:下单数量
         * 是否必填:false
         * 类型标识:1，类型:long
         */
        private Long purchaseQuantity;

    }

    @Getter
    @Setter
    public static class TemuPurchaseOrderV2ProcessTypeVO {
        /**
         * 说明:工艺类型名称
         * 是否必填:false
         * 类型标识:4，类型:string
         */
        private String processTypeDesc;

        /**
         * 说明:一级工艺名称
         * 是否必填:false
         * 类型标识:4，类型:string
         */
        private String firstProcessTypeDesc;

        /**
         * 说明:二级工艺
         * 是否必填:false
         * 类型标识:8，类型:list
         */
        private List<String> secondProcessTypeDesc;

    }

    @Getter
    @Setter
    public static class TemuPurchaseOrderV2DeliverInfo {
        /**
         * 说明:收货时间（单位：毫秒）
         * 是否必填:false
         * 类型标识:1，类型:long
         */
        private Long receiveTime;

        /**
         * 说明:发货时间（单位：毫秒）
         * 是否必填:false
         * 类型标识:1，类型:long
         */
        private Long deliverTime;

        /**
         * 说明:实际收货仓库Id
         * 是否必填:false
         * 类型标识:1，类型:long
         */
        private Long receiveWarehouseId;

        /**
         * 说明:实际收货仓库名称
         * 是否必填:false
         * 类型标识:4，类型:string
         */
        private String receiveWarehouseName;

        /**
         * 说明:要求最晚发货时间带默认值（时间戳 单位：毫秒）
         * 是否必填:false
         * 类型标识:1，类型:long
         */
        private Long expectLatestDeliverTimeOrDefault;

        /**
         * 说明:要求最晚到达时间带默认值（时间戳 单位：毫秒）
         * 是否必填:false
         * 类型标识:1，类型:long
         */
        private Long expectLatestArrivalTimeOrDefault;

        /**
         * 说明:发货单号
         * 是否必填:false
         * 类型标识:4，类型:string
         */
        private String deliveryOrderSn;

    }

    @Getter
    @Setter
    public static class TemuPurchaseOrderV2SkuQuantityTotalInfo {
        /**
         * 说明:货币类型(参考 ISO 4217)  CNY-人民币 USD-美元
         * 是否必填:false
         * 类型标识:4，类型:string
         */
        private String currencyType;

        /**
         * 说明:定制品工艺信息
         * 是否必填:false
         * 类型标识:6，类型:object
         */
        private TemuPurchaseOrderV2SkuQuantityTotalInfoProcessTypeVO processTypeVO;

        /**
         * 说明:尺码名称
         * 是否必填:false
         * 类型标识:4，类型:string
         */
        private String className;

        /**
         * 说明:是否支持上浮
         * 是否必填:false
         * 类型标识:5，类型:boolean
         */
        private Boolean supportIncreaseNum;

        /**
         * 说明:入库数量
         * 是否必填:false
         * 类型标识:1，类型:long
         */
        private Long realReceiveAuthenticQuantity;

        /**
         * 说明:定制类型,0-文字，1-图片
         * 是否必填:false
         * 类型标识:1，类型:long
         */
        private Long customizationType;

        /**
         * 说明:productSkuId
         * 是否必填:false
         * 类型标识:1，类型:long
         */
        private Long productSkuId;

        /**
         * 说明:已送货待收货数量
         * 是否必填:false
         * 类型标识:1，类型:long
         */
        private Long deliverQuantity;

        /**
         * 说明:sku货号
         * 是否必填:false
         * 类型标识:4，类型:string
         */
        private String extCode;

        /**
         * 说明:下单时建议量
         * 是否必填:false
         * 类型标识:1，类型:long
         */
        private Long adviceQuantity;

        /**
         * 说明:下单数量
         * 是否必填:false
         * 类型标识:1，类型:long
         */
        private Long purchaseQuantity;

    }

    @Getter
    @Setter
    public static class TemuPurchaseOrderV2SkuQuantityTotalInfoProcessTypeVO {
        /**
         * 说明:工艺类型名称
         * 是否必填:false
         * 类型标识:4，类型:string
         */
        private String processTypeDesc;

        /**
         * 说明:一级工艺名称
         * 是否必填:false
         * 类型标识:4，类型:string
         */
        private String firstProcessTypeDesc;

        /**
         * 说明:二级工艺
         * 是否必填:false
         * 类型标识:8，类型:list
         */
        private List<String> secondProcessTypeDesc;

    }

    @Getter
    @Setter
    public static class LackOrSoldOutTagListItem {
        /**
         * 说明:是否缺货
         * 是否必填:false
         * 类型标识:5，类型:boolean
         */
        private Boolean isLack;

        /**
         * 说明:属性
         * 是否必填:false
         * 类型标识:4，类型:string
         */
        private String skuDisplay;

        /**
         * 说明:售罄状态
         * 是否必填:false
         * 类型标识:1，类型:long
         */
        private Long soldOut;

    }

    @Getter
    @Setter
    public static class SkuLackItemListItem {
        /**
         * 说明:null
         * 是否必填:false
         * 类型标识:4，类型:string
         */
        private String skuDisplay;

    }

    @Getter
    @Setter
    public static class SkuQcRejectItemListItem {
        /**
         * 说明:null
         * 是否必填:false
         * 类型标识:4，类型:string
         */
        private String skuDisplay;

    }
}
