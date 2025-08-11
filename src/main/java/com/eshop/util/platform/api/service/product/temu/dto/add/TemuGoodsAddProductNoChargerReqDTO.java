package com.eshop.util.platform.api.service.product.temu.dto.add;

import java.util.List;

@lombok.Getter
@lombok.Setter
@lombok.ToString
public class TemuGoodsAddProductNoChargerReqDTO {

    //noChargerProductIds	LIST	是	无充电器版本货品id (清空传空list)

    private List<Long> noChargerProductIds;
}
