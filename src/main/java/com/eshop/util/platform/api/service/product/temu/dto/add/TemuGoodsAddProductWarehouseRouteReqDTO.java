package com.eshop.util.platform.api.service.product.temu.dto.add;

import java.util.List;

@lombok.Getter
@lombok.Setter
@lombok.ToString
public class TemuGoodsAddProductWarehouseRouteReqDTO {

    //targetRouteList	LIST	是	目标自发货站点-仓关系
    //currentRouteList	LIST	否	当前自发货站点-仓关系

    private List<TemuGoodsAddProductWarehouseRouteTargetReqDTO> targetRouteList;
    private List<TemuGoodsAddProductWarehouseRouteCurrentReqDTO> currentRouteList;
}
