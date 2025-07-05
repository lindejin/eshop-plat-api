package com.eshop.util.platform.api.service.order.temu.dto;

import java.util.List;

@lombok.Getter
@lombok.Setter
@lombok.ToString
public class TemuOrderPoV2LogisticsShipmentConfirmReqDTO {
    //sendType	INTEGER	是	发货类型：0-单个运单发货 1-拆成多个运单发货 2-合并发货
    private Integer sendType;
    //sendRequestList	LIST	是	包裹信息
    private List<TemuOrderPoV2LogisticsShipmentConfirmSendRequestDTO> sendRequestList;
}
