package com.eshop.util.platform.call.order.temu.ship.dto;

import java.util.List;

@lombok.Getter
@lombok.Setter
@lombok.ToString
public class TemuOrderShipPackingSendReqDTO {

    //参数接口	参数类型	是否必填	说明
    //deliveryAddressId	INTEGER	是	发货地址id
    private Long deliveryAddressId;
    //deliverMethod	INTEGER	是	发货方式
    private Integer deliverMethod;
    //deliveryOrderSnList	LIST	是	发货单号
    private List<String> deliveryOrderSnList;

    //selfDeliveryInfo	OBJECT	否	自送信息
    private TemuOrderShipPackingSendSelfDeliveryInfoDTO selfDeliveryInfo;
    //thirdPartyExpressDeliveryInfoVO	OBJECT	否	第三方配送
    private TemuOrderShipPackingSendThirdPartyExpressDeliveryInfoDTO thirdPartyExpressDeliveryInfoVO;
    //thirdPartyDeliveryInfo	OBJECT	否	公司指定物流
    private TemuOrderShipPackingSendThirdPartyDeliveryInfoDTO thirdPartyDeliveryInfo;


}
