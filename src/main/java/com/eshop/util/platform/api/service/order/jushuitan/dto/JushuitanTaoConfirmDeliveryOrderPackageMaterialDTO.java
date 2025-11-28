package com.eshop.util.platform.api.service.order.jushuitan.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Map;

@Getter
@Setter
public class JushuitanTaoConfirmDeliveryOrderPackageMaterialDTO {

    //type	String	XLL	包材型号
    private String type;
    //quantity	Number	12	包材的数量
    private Integer quantity;
    //extendProps	Map		包材信息扩展属性
    private Map<String, String> extendProps;
}
