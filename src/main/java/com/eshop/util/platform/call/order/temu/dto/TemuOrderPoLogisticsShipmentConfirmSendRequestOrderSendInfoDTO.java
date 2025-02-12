package com.eshop.util.platform.call.order.temu.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TemuOrderPoLogisticsShipmentConfirmSendRequestOrderSendInfoDTO {

    //orderSn	STRING	是	orderSn
    private String orderSn;
    //parentOrderSn	STRING	是	parentOrderSn
    private String parentOrderSn;
    //goodsId	INTEGER	否	goodsId
    private Long goodsId;
    //skuId	INTEGER	否	skuId
    private Long skuId;
    //quantity	INTEGER	是	发货数量
    private Integer quantity;
}
