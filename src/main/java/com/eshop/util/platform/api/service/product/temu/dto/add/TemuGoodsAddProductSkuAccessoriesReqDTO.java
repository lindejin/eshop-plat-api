package com.eshop.util.platform.api.service.product.temu.dto.add;

import java.util.List;

@lombok.Getter
@lombok.Setter
@lombok.ToString
public class TemuGoodsAddProductSkuAccessoriesReqDTO {

    //productSkuAccessories	LIST	是	包装清单列表（最多20个）
    private List<TemuGoodsAddProductSkuAccessoriesItemReqDTO> productSkuAccessories;
}
