package com.eshop.util.platform.api.service.order.temu.vo;

import java.util.List;

@lombok.Getter
@lombok.Setter
@lombok.ToString
public class TemuOrderPoLogisticsShipmentResultShipmentInfoV2VO {

    //carrierId	LONG	Carrier ID, it's the same ID with the logisticsServiceProviderId you got from "bg.logistics.companies.get".
    //carrierId	INTEGER	否	物流公司ID
    private Long carrierId;

    //carrierName	STRING	Carrier name, it's the same name with the logisticsServiceProviderId you got from "bg.logistics.companies.get".
    //carrierName	STRING	否	物流公司名称
    private String carrierName;

    //trackingNumber	STRING	Tracking Number.
    //trackingNumber	STRING	否	运单号
    private String trackingNumber;

    //skuId	LONG	SKU ID.
    //skuId	INTEGER	否	商品skuId
    private Long skuId;

    //quantity	INTEGER	Quantity of the product.
    //quantity	INTEGER	否	商品skuId对应发货数量
    private Long quantity;

    //packageSn	STRING	Package number
    //packageSn	STRING	否	包裹号
    private String packageSn;

    //packageDeliveryType	INTEGER	Package delivery type,enumerated as follows: 1:Seller fulfills this order by non-integrated channel 2:Seller fulfills this order by Temu-integrated channel 3:Cooperative warehouse fulfills this order by non-integrated channel 4:Cooperative warehouse fulfills this order by Temu-integrated channel
    //packageDeliveryType update	INTEGER	否	发货包裹履约类型，新增枚举值3和4
    //● 1：导入运单发货
    //● 2：在线下单发货
    //● 3：合作对接仓导入运单发货
    //● 4：合作对接仓在线下单发货
    private Integer packageDeliveryType;

    //trackingWarningLabel	INTEGER	Tracking warning labels, 0:No Issues 1: No Tracking Information 2:Potentially Incorrect 4: Inconsistent Shipping Address
    //trackingWarningLabel	INTEGER	否	运单物流提醒标签
    //0-无问题，1-查无轨迹，2-疑似有误，3-收货地址不一致，4-未揽收
    private Integer trackingWarningLabel;

    //cooperativeWarehouseDTO	OBJECT	Only when this order is fulfilled by the cooperative warehouse, this parameter may return DTO information. If this order is fulfilled by the seller, this parameter may return empty.
    //cooperativeWarehouseDTO update	STRING	否	只在packageDeliveryType=3或4（合作对接仓导入运单发货/合作对接仓在线下单发货）时返回，在packageDeliveryType=1或2时，返回为空
    //a. 合作对接仓服务商编码：warehouseProviderCode：
    //b. 合作对接仓服务商名字：warehouseProviderBrandName
    //c. 合作对接仓编码：warehouseCode
    //d. 合作对接仓名字：warehouseName
    private TemuOrderPoLogisticsShipmentResultCooperativeWarehouseV2VO cooperativeWarehouseDTO;


    //subPackageShipmentInfoList	OBJECT[]	subPackage Shipment result
    //subPackageShipmentInfoList	LIST	否	附属包裹列表
    // 当为单sku拆单发货场景时，后续增加补充的运单信息将作为附属包裹展示
    private List<TemuOrderPoLogisticsShipmentResultShipmentInfoSubPackageV2VO> subPackageShipmentInfoList;

}
