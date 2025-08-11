package com.eshop.util.platform.api.service.product.temu.dto.add;

import java.util.List;

@lombok.Getter
@lombok.Setter
@lombok.ToString
public class TemuGoodsAddProductSkuStockQuantityReqDTO {

    //warehouseStockQuantityReqs	LIST	是	发货仓库存库存请求列表
    private List<TemuGoodsAddProductSkuWarehouseStockQuantityReqDTO> warehouseStockQuantityReqs;
}
