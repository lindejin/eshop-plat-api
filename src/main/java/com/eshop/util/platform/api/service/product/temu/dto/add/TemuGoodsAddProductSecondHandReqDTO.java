package com.eshop.util.platform.api.service.product.temu.dto.add;

@lombok.Getter
@lombok.Setter
@lombok.ToString
public class TemuGoodsAddProductSecondHandReqDTO {

    //isSecondHand	BOOLEAN	否	是否二手货品，二手店铺传true，其他店铺不传值
    //secondHandLevel	INTEGER	否	成色定义，二手货品必传值，非二手货品不可传值，枚举值：（1：接近全新，2：状况极佳，3：状况良好，4：尚可接受）

    private Boolean isSecondHand;
    private Long secondHandLevel;
}
