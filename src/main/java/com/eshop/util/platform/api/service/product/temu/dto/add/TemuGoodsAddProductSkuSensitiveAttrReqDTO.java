package com.eshop.util.platform.api.service.product.temu.dto.add;

import java.util.List;

@lombok.Getter
@lombok.Setter
@lombok.ToString
public class TemuGoodsAddProductSkuSensitiveAttrReqDTO {

    //sensitiveTypes	LIST	否	敏感类型， PURE_ELECTRIC(1, "纯电"), INTERNAL_ELECTRIC(2, "内电"), MAGNETISM(3, "磁性"), LIQUID(4, "液体"), POWDER(5, "粉末"), PASTE(6, "膏体"), CUTTER(7, "刀具")
    //isSensitive	INTEGER	否	是否敏感属性，0：非敏感，1：敏感
    //sensitiveList	LIST	否	敏感类型， PURE_ELECTRIC(110001, "纯电"), INTERNAL_ELECTRIC(120001, "内电"), MAGNETISM(130001, "磁性"), LIQUID(140001, "液体"), POWDER(150001, "粉末"), PASTE(160001, "膏体"), CUTTER(170001, "刀具")

    private List<Long> sensitiveTypes;
    private Long isSensitive;
    private List<Long> sensitiveList;
}
