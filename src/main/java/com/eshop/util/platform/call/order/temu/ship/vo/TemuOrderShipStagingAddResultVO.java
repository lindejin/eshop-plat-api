package com.eshop.util.platform.call.order.temu.ship.vo;

import java.util.List;

@lombok.Getter
@lombok.Setter
@lombok.ToString
public class TemuOrderShipStagingAddResultVO {

    //existJoinErrorSubPurchase	BOOLEAN	是否存在加入发货台失败的发货单
    private Boolean existJoinErrorSubPurchase;
    //joinErrorList	LIST	加入发货台失败的备货单明细列表
    private List<TemuOrderShipStagingAddJoinErrortVO> joinErrorList;
}
