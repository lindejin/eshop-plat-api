package com.eshop.util.platform.call.order.temu.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TemuOrderPoCombinedShipmentListGatewayContext {
    //mallid	LONG	是	是	商家店铺id, 开放平台网关透传参数
    private Long mallid;
    //appkey	STRING	是	是	应用身份id，开放平台网关透传参数
    private String appkey;
}
