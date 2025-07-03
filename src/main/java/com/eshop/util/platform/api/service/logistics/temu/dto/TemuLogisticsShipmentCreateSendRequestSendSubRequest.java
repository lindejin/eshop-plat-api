package com.eshop.util.platform.api.service.logistics.temu.dto;

import java.util.List;

@lombok.Getter
@lombok.Setter
@lombok.ToString
public class TemuLogisticsShipmentCreateSendRequestSendSubRequest {

    //warehouseId	STRING	True	Warehouse ID
    private String warehouseId;


    //weight	STRING	True	The weight of the package. For local U.S. orders, this filed should be input with integer and the decimal places should be input by extendWeight. For Non-local U.S. orders, two decimal places are filled in by default.
    private String weight;
    //weightUnit	STRING	True	The unit of the weight. The weight unit for packages in the United States is "lb" while in other countries it is "kg".
    private String weightUnit;


    //length	STRING	True	width of the package, width should be input with two decimal places
    private String length;
    //width	STRING	True	width of the package, width should be input with two decimal places
    private String width;
    //height	STRING	True	height of the package, height should be input with two decimal places
    private String height;
    //dimensionUnit	STRING	True	dimension(eg:length/width/height) Unit. The dimension unit for packages in the United States is "in". while in other countries it is "cm"
    private String dimensionUnit;


    //channelId	LONG	False	Channel ID, you can get this ID from "bg.logistics.shippingservices.get"
    private Long channelId;
    //shipLogisticsType	STRING	False	Ship logistics type, you can get this type from "temu.logistics.shiplogisticstype.get"
    private String shipLogisticsType;
    //shipCompanyId	LONG	True	Ship Company ID, you can get this ID from "bg.logistics.shippingservices.get"
    private Long shipCompanyId;

    //confirmAcceptance	STRING[]	False	Confirmation matters for this shipment, enumerated as follows: DENY_CANCELLATION: Reject the cancellation request for this order; DENY_ADDRESS_CHANGE: Reject the address change request for this order; DENY_PARENT_RISK_WARNING: Reject the risk warning for this order; NO_DELIVERY_ON_SATURDAY: Delivery on Saturday is unavailable; SIGNATURE_ON_DELIVERY: Signature is necessary.
    private List<String> confirmAcceptance;

    //signServiceId	LONG	False	Unique Identifier for Signature Service
    private Long signServiceId;


    //extendWeight	STRING	False	The extend weight of the package. For local U.S. orders, the decimal places are filled with integer through this parameter while extendWeightUnit is "oz".
    private String extendWeight;
    //extendWeightUnit	STRING	False	The unit of the extend weight. For local U.S. orders, the extend weight unit for packages is "oz".
    private String extendWeightUnit;

}
