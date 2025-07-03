package com.eshop.util.platform.api.service.logistics.temu.dto;

import java.util.List;

@lombok.Getter
@lombok.Setter
@lombok.ToString
public class TemuLogisticsShipmentCreateSendRequest {

    //shipCompanyId	LONG	True	Ship Company ID, you can get this ID from "bg.logistics.shippingservices.get"
    /**
     * 物流公司id
     */
    private Long shipCompanyId;

    //orderSendInfoList	OBJECT[]	False	Product List in this package
    /**
     * 发货商品信息
     */
    private List<TemuLogisticsShipmentCreateSendRequestOrderSendInfo> orderSendInfoList;

    //warehouseId	STRING	True	Warehouse ID
    /**
     * 仓库id
     */
    private String warehouseId;

    //weight	STRING	True	The weight of the package. For local U.S. orders, this filed should be input with integer and the decimal places should be input by extendWeight. For Non-local U.S. orders, two decimal places are filled in by default.
    /**
     * 重量（默认2位小数）
     */
    private String weight;

    //weightUnit	STRING	True	The unit of the weight. The weight unit for packages in the United States is "lb" while in other countries it is "kg".
    /**
     * 重量单位，美国为lb（磅），其他国家为kg（千克）
     */
    private String weightUnit;

    //length	STRING	True	The length of the package, the length should be input with two decimal places
    /**
     * 包裹长度（默认2位小数）
     */
    private String length;
    //width	STRING	True	width of the package, width should be input with two decimal places
    /**
     * 包裹宽度（默认2位小数）
     */
    private String width;
    //height	STRING	True	height of the package, height should be input with two decimal places
    /**
     * 包裹高度（默认2位小数）
     */
    private String height;

    //dimensionUnit	STRING	True	dimension(eg:length/width/height) Unit. The dimension unit for packages in the United States is "in". while in other countries it is "cm"
    /**
     * 尺寸单位高度 ，美国为in（英寸）其他国家为cm（厘米）
     */
    private String dimensionUnit;


    //channelId	LONG	False	Channel ID, you can get this ID from "bg.logistics.shippingservices.get"
    /**
     * 渠道id，取自 "bg.logistics.shippingservices.get"
     */
    private Long channelId;

    //shipLogisticsType	STRING	False	Ship logistics type, you can get this type from "temu.logistics.shiplogisticstype.get"
    /**
     * 船舶物流类型，您可以从 "temu.logistics.shiplogisticstype.get"
     */
    private String shipLogisticsType;

    //pickupEndTime	LONG	False	The end time for scheduling pickup, with a timestamp of seconds
    /**
     * 预约上门取件结束时间
     * 当渠道为需要下call同时入参预约时间渠道时，需入参。剩余渠道无需入参。
     */
    private Long pickupEndTime;

    //pickupStartTime	LONG	False	The start time for scheduling pickup, with a timestamp of seconds
    /**
     * 预约上门取件开始时间
     * 当渠道为需要下call同时入参预约时间渠道时，需入参。剩余渠道无需入参。
     */
    private Long pickupStartTime;

    //splitSubPackage	BOOLEAN	False	Is Single SKU Split into Multiple Packages TRUE:Indicates that the scenario involves splitting a single SKU into multiple packages. FALSE or not filled: Indicates that the scenario does not involve splitting a single SKU into multiple packages.
    /**
     * 是否为单件SKU拆多包裹
     * TRUE：是单件SKU多包裹场景
     * FALSE/不填：不是单件SKU多包裹场景
     */
    private Boolean splitSubPackage;

    //signServiceId	LONG	False	Unique Identifier for Signature Service
    /**
     * 想使用的签收服务ID
     */
    private Long signServiceId;

    //sendSubRequestList	OBJECT[]	False	Sub Package List Information
    /**
     * 单件sku多包裹场景，附属包裹入参
     */
    private List<TemuLogisticsShipmentCreateSendRequestSendSubRequest> sendSubRequestList;

    //confirmAcceptance	STRING[]	False	Confirmation matters for this shipment, enumerated as follows: DENY_CANCELLATION: Reject the cancellation request for this order; DENY_ADDRESS_CHANGE: Reject the address change request for this order; DENY_PARENT_RISK_WARNING: Reject the risk warning for this order; NO_DELIVERY_ON_SATURDAY: Delivery on Saturday is unavailable; SIGNATURE_ON_DELIVERY: Signature is necessary.
    /**
     * 本次发货的确认事项，列举如下：
     * DENY_CANCELLATION：拒绝本次订单的取消请求；
     * DENY_ADDRESS_CHANGE：拒绝本次订单的地址变更请求；
     * DENY_PARENT_RISK_WARNING：拒绝本次订单的风险警告；
     * NO_DELIVERY_ON_SATURDAY：周六无法配送；
     * SIGNATURE_ON_DELIVERY：需要签名。
     */
    private List<String> confirmAcceptance;


    //extendWeight	STRING	False	The extend weight of the package. For local U.S. orders, the decimal places are filled with integer through this parameter while extendWeightUnit is "oz".
    /**
     * 包裹的延伸重量。对于美国本地订单，小数部分通过此参数填充整数，extendWeightUnit 为“oz”。
     */
    private String extendWeight;

    //extendWeightUnit	STRING	False	The unit of the extend weight. For local U.S. orders, the extend weight unit for packages is "oz".
    /**
     * 延伸重量的单位。对于美国本地订单，包裹的延伸重量单位为“盎司”。 oz
     */
    private String extendWeightUnit;

}
