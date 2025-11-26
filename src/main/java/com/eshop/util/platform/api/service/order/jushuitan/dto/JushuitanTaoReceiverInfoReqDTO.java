package com.eshop.util.platform.api.service.order.jushuitan.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class JushuitanTaoReceiverInfoReqDTO {
    //oaid	String	false	订单收件人 ID, string (50)	订单收件人 ID, string (50)
    private String oaid;
    //deliveryOrderCode	String	true	出库单号, string (50) , 必填	出库单号, string (50) , 必填
    private String deliveryOrderCode;
    //ownerCode	String	false	货主ID, string (50)	货主ID
    private String ownerCode;
    //warehouseCode	String	false	WS1231，string (64)	仓库编码
    private String warehouseCode;
    //scene	String	false	使用场景, string(10)，必填	使用场景。1001，顺丰电子面单发货；1002，4通一达电子面单发货；1003，EMS电子面单发货；1004，其他电子面单发货；2001，客户售后服务
    private String scene;
}
