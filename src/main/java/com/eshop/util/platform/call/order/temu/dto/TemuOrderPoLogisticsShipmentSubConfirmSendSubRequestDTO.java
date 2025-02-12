package com.eshop.util.platform.call.order.temu.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TemuOrderPoLogisticsShipmentSubConfirmSendSubRequestDTO {
    //trackingNumber	STRING	是	运单号
    private String trackingNumber;
    //carrierId	LONG	是	物流公司id
    private Long carrierId;
}
