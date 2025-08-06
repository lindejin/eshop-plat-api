package com.eshop.util.platform.call.order.temu.ship.dto;

import java.util.List;

@lombok.Getter
@lombok.Setter
@lombok.ToString
public class TemuOrderShipStagingAddReqDTO {

    private List<TemuOrderShipStagingAddJoinInfoDTO> joinInfoList;
}
