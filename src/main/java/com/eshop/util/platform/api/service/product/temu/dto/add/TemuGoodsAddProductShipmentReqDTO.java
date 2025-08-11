package com.eshop.util.platform.api.service.product.temu.dto.add;

@lombok.Getter
@lombok.Setter
@lombok.ToString
public class TemuGoodsAddProductShipmentReqDTO {

    //freightTemplateId	STRING	是	运费模板id
    //shipmentLimitSecond	INTEGER	是	承诺发货时间(单位:s)

    private String freightTemplateId;
    private Long shipmentLimitSecond;
}
