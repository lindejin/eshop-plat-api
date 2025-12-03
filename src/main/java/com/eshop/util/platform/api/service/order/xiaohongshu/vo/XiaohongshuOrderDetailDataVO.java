package com.eshop.util.platform.api.service.order.xiaohongshu.vo;

import java.util.List;

@lombok.Getter
@lombok.Setter
public class XiaohongshuOrderDetailDataVO {
    //  参数名称	参数类型	参数描述
    //	orderId	string	订单号
    //	orderType	integer	订单类型，1现货 2定金预售 3全款预售(废弃) 4全款预售(新) 5补发
    //	orderStatus	integer	订单状态，1已下单待付款 2已支付处理中 3清关中 4待发货 5部分发货 6待收货 7已完成 8已关闭 9已取消 10换货申请中
    //	orderAfterSalesStatus	integer	售后状态，1无售后 2售后处理中 3售后完成 4售后拒绝 5售后关闭 6平台介入中 7售后取消
    //	cancelStatus	integer	申请取消状态，0未申请取消 1取消处理中
    //	createdTime	integer	创建时间 单位ms
    //	paidTime	integer	支付时间 单位ms
    //	updateTime	integer	更新时间 单位ms
    //	deliveryTime	integer	订单发货时间 单位ms
    //	cancelTime	integer	订单取消时间 单位ms
    //	finishTime	integer	订单完成时间 单位ms
    //	promiseLastDeliveryTime	integer	承诺最晚发货时间 单位ms
    //	planInfoId	string	物流方案id
    //	planInfoName	string	物流方案名称
    //	receiverCountryId	string	收件人国家id
    //	receiverCountryName	string	目前仅 中国
    //	receiverProvinceId	string	收件人省份id
    //	receiverProvinceName	string	收件人省份
    //	receiverCityId	string	收件人城市id
    //	receiverCityName	string	收件人城市
    //	receiverDistrictId	string	收件人区县id
    //	receiverDistrictName	string	收件人区县名称
    //	customerRemark	string	用户备注
    //	sellerRemark	string	商家标记备注
    //	sellerRemarkFlag	integer	商家标记优先级，ark订单列表展示旗子颜色 1灰旗 2红旗 3黄旗 4绿旗 5蓝旗 6紫旗
    //	presaleDeliveryStartTime	integer	预售最早发货时间 单位ms
    //	presaleDeliveryEndTime	integer	预售最晚发货时间 单位ms
    //	skuList	array	sku列表 相同sku聚合 金额为价格总和 单位 分
    //	originalOrderId	string	原始关联订单号(退换订单的原订单)
    //	totalNetWeightAmount	integer	订单商品总净重 单位g
    //	totalPayAmount	integer	订单实付金额(包含运费和定金) 单位分
    //	totalShippingFree	integer	订单实付运费 单位分
    //	unpack	boolean	是否拆包 true已拆包 false未拆包
    //	expressTrackingNo	string	快递单号
    //	expressCompanyCode	string	快递公司编码
    //	receiverName	string	收件人姓名 暂不返回 详情通过getOrderReceiverInfo获取
    //	receiverPhone	string	收件人手机 暂不返回 详情通过getOrderReceiverInfo获取
    //	receiverAddress	string	收件人地址 暂不返回 详情通过getOrderReceiverInfo获取
    //	boundExtendInfo	object	三方保税节点 金额单位 分
    //	transferExtendInfo	object	小包转运节点
    //	openAddressId	string	收件人姓名+手机+地址等计算得出，用来查询收件人详情
    //	simpleDeliveryOrderList	array	拆包信息节点
    //	logistics	string	物流模式red_express三方备货直邮(备货海外仓),red_domestic_trade(三方备货内贸),red_standard(三方备货保税仓),red_auto(三方自主发货),red_box(三方小包),red_bonded(三方保税)
    //	totalDepositAmount	integer	订单定金 单位分
    //	totalMerchantDiscount	integer	商家承担总优惠金额 单位分
    //	totalRedDiscount	integer	平台承担总优惠金额 单位分
    //	merchantActualReceiveAmount	integer	商家实收(=用户支付金额+定金+平台优惠) 单位分
    //	totalChangePriceAmount	integer	改价总金额 单位分
    //	paymentType	integer	支付方式 1：支付宝 2：微信 3：apple 内购 4：apple pay 5：花呗分期 7：支付宝免密支付 8：云闪付 -1：其他
    //	shopId	string	店铺id
    //	shopName	string	店铺名称
    //	whcode	string	仓code
    //	userId	string	用户id
    //	orderTagList	array<string>	订单标签列表 NEW_YEAR 新年礼 PLATFORM_DECLARE 平台报备 SELLER_DECLARE 商家报备 CONSULT 协商发货 MODIFIED_ADDR 已改地址 MODIFIED_PRICE 已改价 NO_LOGISTICS_SHIP 无物流发货 PRINTED 部分打单/已打单 URGENT_SHIP 催发货 QIC QIC质检 SAMPLE 拿样 HOME_DELIVERY 送货上门 LACK_GOOD 缺货 EXPLODE 发生现货爆单的订单 EXEMPT 发生现货爆单享受豁免 CERTIFICATION_WAREHOUSE 认证仓 COUNTRY_SUBSIDY: 国家补贴 CITY_SUBSIDY:城市补贴 COUNTRY_SUBSIDY_SUPPLY_SALE:国补供销 BUY_AGENT:代购 RDS:跨境出海订单
    //	logisticsMode	integer	物流模式 1: 普通内贸 2：保税bbc 3: 直邮bc 4:行邮cc
    //	customsCode	string	口岸code
    //	outPromotionAmount	integer	支付渠道优惠金额 单位分 举例:支付宝/微信/云闪付等的单号 和paymentType对应
    //	outTradeNo	string	三方支付渠道单号 举例:支付宝/微信/云闪付等单号 和paymentType对应
    //	subsidySupplierId	string	国补供应商id
    //	subsidySupplierName	string	国补供应商名称
    //	subsidyWpServiceCode	string	国补顺丰微派任务编码
    //	subsidySkuIdentifyCodeRequiredInfo	object	国补商品标识信息发货必传条件


    private String orderId;
    private Integer orderType;
    private Integer orderStatus;
    private Integer orderAfterSalesStatus;
    private Integer cancelStatus;
    private Long createdTime;
    private Long paidTime;
    private Long updateTime;
    private Long deliveryTime;
    private Long cancelTime;
    private Long finishTime;
    private Long promiseLastDeliveryTime;
    private String planInfoId;
    private String planInfoName;
    private String receiverCountryId;
    private String receiverCountryName;
    private String receiverProvinceId;
    private String receiverProvinceName;
    private String receiverCityId;
    private String receiverCityName;
    private String receiverDistrictId;
    private String receiverDistrictName;
    private String customerRemark;
    private String sellerRemark;
    private Integer sellerRemarkFlag;
    private Long presaleDeliveryStartTime;
    private Long presaleDeliveryEndTime;
    private String originalOrderId;
    private Integer totalNetWeightAmount;
    private Integer totalPayAmount;
    private Integer totalShippingFree;
    private Boolean unpack;
    private String expressTrackingNo;
    private String expressCompanyCode;
    private String receiverName;
    private String receiverPhone;
    private String receiverAddress;
    private String openAddressId;
    private String logistics;
    private Integer totalDepositAmount;
    private Integer totalMerchantDiscount;
    private Integer totalRedDiscount;
    private Integer merchantActualReceiveAmount;
    private Integer totalChangePriceAmount;
    private Integer paymentType;
    private String shopId;
    private String shopName;
    private String whcode;
    private String userId;
    private List<String> orderTagList;
    private Integer logisticsMode;
    private String customsCode;
    private String outPromotionAmount;
    private String outTradeNo;
    private String subsidySupplierId;
    private String subsidySupplierName;
    private String subsidyWpServiceCode;

    /**
     * subsidySkuIdentifyCodeRequiredInfo	object	国补商品标识信息发货必传条件
     */
    private XiaohongshuOrderSubsidySkuIdentifyCodeRequiredInfo subsidySkuIdentifyCodeRequiredInfo;

    /**
     * skuList	array	sku列表 相同sku聚合 金额为价格总和 单位 分
     */
    private List<XiaohongshuOrderSkuDTOV3> skuList;

    /**
     * boundExtendInfo	object	三方保税节点 金额单位 分
     */
    private XiaohongshuOrderBoundExtendInfoDTO boundExtendInfo;

    /**
     * transferExtendInfo	object	小包转运节点
     */
    private XiaohongshuOrderTransferExtendInfoDTO transferExtendInfo;

    /**
     * simpleDeliveryOrderList	array	拆包信息节点
     */
    private List<XiaohongshuOrderSimpleDeliveryOrder> simpleDeliveryOrderList;
}
