package com.eshop.util.platform.api.service.product.temu.dto.add;

import java.util.List;

@lombok.Getter
@lombok.Setter
@lombok.ToString
public class TemuGoodsAddVehicleLibraryRelationReqDTO {

    //productPropValueDependencyReqList	LIST	否	车型列表
    //vehicleLibraryId	INTEGER	是	车型库 ID

    private List<TemuGoodsAddProductPropValueDependencyReqDTO> productPropValueDependencyReqList;
    private Long vehicleLibraryId;
}
