package com.eshop.util.platform.api.service.product.temu.dto.add;

@lombok.Getter
@lombok.Setter
@lombok.ToString
public class TemuGoodsAddProductSkuWarehouseStockQuantityReqDTO {

    //targetStockAvailable	INTEGER	是	目标库存
    //warehouseId	STRING	是	仓库ID
    //currentStockAvailable	INTEGER	否	当前库存

    private Long targetStockAvailable;
    private String warehouseId;
    private Long currentStockAvailable;
}
