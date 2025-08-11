package com.eshop.util.platform.api.service.product.temu.dto.add;

import java.util.List;

@lombok.Getter
@lombok.Setter
@lombok.ToString
public class TemuGoodsAddProductWarehouseRouteTargetReqDTO {

    //siteIdList	LIST	是	站点ID.
    //warehouseId	STRING	是	仓库ID

    private List<Long> siteIdList;
    private String warehouseId;
}
