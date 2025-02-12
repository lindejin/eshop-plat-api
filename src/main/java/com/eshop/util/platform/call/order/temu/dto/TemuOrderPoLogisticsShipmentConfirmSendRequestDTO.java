package com.eshop.util.platform.call.order.temu.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class TemuOrderPoLogisticsShipmentConfirmSendRequestDTO {
    //carrierId	INTEGER	是	物流公司id
    private Integer carrierId;
    //trackingNumber	STRING	是	运单号
    private String trackingNumber;
    //orderSendInfoList	LIST	是	发货商品信息
    private List<TemuOrderPoLogisticsShipmentConfirmSendRequestOrderSendInfoDTO> orderSendInfoList;
}
