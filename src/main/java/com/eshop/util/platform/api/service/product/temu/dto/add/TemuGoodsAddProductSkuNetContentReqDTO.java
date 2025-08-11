package com.eshop.util.platform.api.service.product.temu.dto.add;
@lombok.Getter
@lombok.Setter
@lombok.ToString
public class TemuGoodsAddProductSkuNetContentReqDTO {

    //netContentUnitCode	INTEGER	否	净含量单位，1：液体盎司，2：毫升，3：加仑，4：升，5：克，6：千克，7：常衡盎司，8：磅
    //netContentNumber	INTEGER	否	净含量数值

    private Long netContentUnitCode;
    private Long netContentNumber;
}
