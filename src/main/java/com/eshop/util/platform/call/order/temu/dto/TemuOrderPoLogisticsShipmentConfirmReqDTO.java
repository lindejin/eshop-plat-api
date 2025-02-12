package com.eshop.util.platform.call.order.temu.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class TemuOrderPoLogisticsShipmentConfirmReqDTO {
    //sendType	INTEGER	是	发货类型：0-单个运单发货 1-拆成多个运单发货 2-合并发货
    private Integer sendType;
    //sendRequestList	LIST	是	包裹信息
    private List<TemuOrderPoLogisticsShipmentConfirmSendRequestDTO> sendRequestList;
}
