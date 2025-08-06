package com.eshop.util.platform.call.order.temu.ship.vo;

import java.util.List;

@lombok.Getter
@lombok.Setter
@lombok.ToString
public class TemuOrderShipV2GetVO {

    //receiveSkcNum	INTEGER	实收skc数目
    private Integer receiveSkcNum;
    //expressPackageNum	INTEGER	交接给快递公司的包裹数量
    private Integer expressPackageNum;
    //latestFeedbackStatus	INTEGER	物流异常反馈最新反馈状态
    private Integer latestFeedbackStatus;
    //expectLatestPickTime	INTEGER	要求最晚揽收时间
    private Long expectLatestPickTime;
    //expressDeliverySn	STRING	快递单号
    private String expressDeliverySn;
    //deliveryOrderCancelLeftTime	INTEGER	发货单超时取消剩余时间,单位毫秒. 只针对非加急发货单,加急发货单(urgencyType=1)该字段为null
    private Long deliveryOrderCancelLeftTime;
    //deliveryAddressId	INTEGER	发货地址id
    private Long deliveryAddressId;
    //expressWeightFeedbackStatus	INTEGER	运单计费重量异常状态. 可选值含义说明:[0:未定义（数据库默认值）或无异常;1:异常待确认;2:已提交异常反馈，待物流商处理;3:物流商处理完成;4:平台介入处理中;5:平台处理完成;6:卖家已确认;7:卖家超期自动确认;8:物流商介入处理，卖家确认或超时自动确认;9:结算消息驱动卖家确认;10:无需公示;11:结算物流单计算重量查询失败;12:结算理论计费重拦截;13:SKU重量体积拦截;]
    private Integer expressWeightFeedbackStatus;
    //expressRejectStatus	INTEGER	物流单拒收状态 0-无拒收信息 1-存在拒收，待物流商处理 2-存在拒收，物流商已处理. 可选值含义说明:[0:无拒收信息;1:存在拒收，待物流商处理;2:存在拒收，物流商已处理;]
    private Integer expressRejectStatus;
    //packageReceiveInfoVOList	LIST	包裹收货信息（包裹收货时间）
    private List<TemuOrderShipV2GetPackageReceiveInfoVO> packageReceiveInfoVOList;
    //taxWarehouseApplyOperateType	INTEGER	入保税仓申请操作类型 0-不可操作 1-可申请 2-可查看
    private Integer taxWarehouseApplyOperateType;
    //productSkcId	INTEGER	skcId
    private Long productSkcId;
    //skcExtCode	STRING	skc货号信息
    private String skcExtCode;
    //inboundTime	INTEGER	发货单入库时间
    private Long inboundTime;
    //subWarehouseId	INTEGER	子仓id
    private Long subWarehouseId;
    //packageList	LIST	包裹列表
    private List<TemuOrderShipV2GetPackageVO> packageList;
    //inventoryRegion	INTEGER	备货类型
    private Integer inventoryRegion;
    //deliverPackageNum	INTEGER	实发包裹数
    private Integer deliverPackageNum;
    //subPurchaseOrderSn	STRING	采购子单号
    private String subPurchaseOrderSn;
    //driverName	STRING	司机姓名
    private String driverName;
    //expressCompanyId	INTEGER	快递公司id
    private Long expressCompanyId;
    //defectiveSkcNum	INTEGER	次品skc数目
    private Integer defectiveSkcNum;
    //status	INTEGER	状态
    private Integer status;
    //expectPickUpGoodsTime	INTEGER	预约取货时间
    private Long expectPickUpGoodsTime;
    //predictTotalPackageWeight	INTEGER	预估总包裹重量，单位g
    private Long predictTotalPackageWeight;
    //supplierId	INTEGER	供应商id
    private Long supplierId;
    //isDisplayCourier	BOOLEAN	是否可以展示快递小哥联系方式，部分快递未接入
    private Boolean isDisplayCourier;
    //deliveryMethod	INTEGER	发货方式. 可选值含义说明:[0:无;1:自送;2:公司指定物流;3:第三方物流;]
    private Integer deliveryMethod;
    //isCustomProduct	BOOLEAN	是否为定制品 false-非定制品 true-定制品
    private Boolean isCustomProduct;
    //expressWeightFeedbackTip	STRING	运单计费重量异常提示文案 运单重量异常，待确认 || 物流商已回复重量异常，待确认. 可选值含义说明:[0:未定义（数据库默认值）或无异常;1:异常待确认;2:已提交异常反馈，待物流商处理;3:物流商处理完成;4:平台介入处理中;5:平台处理完成;6:卖家已确认;7:卖家超期自动确认;8:物流商介入处理，卖家确认或超时自动确认;9:结算消息驱动卖家确认;10:无需公示;11:结算物流单计算重量查询失败;12:结算理论计费重拦截;13:SKU重量体积拦截;]
    private String expressWeightFeedbackTip;
    //exceptionFeedBackTotalCount	INTEGER	异常反馈总记录数
    private Integer exceptionFeedBackTotalCount;
    //otherDeliveryPackageNum	INTEGER	其他发货单的包裹数目
    private Integer otherDeliveryPackageNum;
    //purchaseStockType	INTEGER	备货类型 0-普通备货 1-jit备货
    private Integer purchaseStockType;
    //ifCanOperateDeliver	BOOLEAN	是否可以操作发货
    private Boolean ifCanOperateDeliver;
    //receivePackageNum	INTEGER	实收包裹数
    private Integer receivePackageNum;
    //isPrintBoxMark	BOOLEAN	是否打印箱唛
    private Boolean isPrintBoxMark;
    //expressCompany	STRING	快递公司名称
    private String expressCompany;
    //isClothCategory	BOOLEAN	是否服饰类目
    private Boolean isClothCategory;
    //deliveryOrderSn	STRING	发货单号
    private String deliveryOrderSn;
    //deliverTime	INTEGER	发货单发货时间
    private Long deliverTime;
    //urgencyType	INTEGER	是否是紧急发货单，0-普通 1-急采
    private Integer urgencyType;
    //expressBatchSn	STRING	发货批次号
    private String expressBatchSn;
    //receiveAddressInfo	OBJECT	收货仓详细地址
    private TemuOrderShipV2GetReceiveAddressInfoVO receiveAddressInfo;
    //plateNumber	STRING	车牌号
    private String plateNumber;
    //receiveTime	INTEGER	发货单收货时间
    private Long receiveTime;
    //packageDetailList	LIST	包裹详情列表
    private List<TemuOrderShipV2GetPackageDetailVO> packageDetailList;
    //subPurchaseOrderBasicVO	OBJECT	采购单信息
    private TemuOrderShipV2GetSubPurchaseOrderBasicVO subPurchaseOrderBasicVO;
    //subWarehouseName	STRING	子仓名称
    private String subWarehouseName;
    //purchaseTime	INTEGER	下单时间（时间戳：毫秒）
    private Long purchaseTime;
    //skcPurchaseNum	INTEGER	下单数量
    private Integer skcPurchaseNum;
    //deliverSkcNum	INTEGER	实发skc数目
    private Integer deliverSkcNum;
    //deliveryOrderCreateTime	INTEGER	发货单创建时间
    private Long deliveryOrderCreateTime;
}
