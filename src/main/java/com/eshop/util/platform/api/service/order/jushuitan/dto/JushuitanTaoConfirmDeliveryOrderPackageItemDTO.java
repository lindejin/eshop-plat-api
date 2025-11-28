package com.eshop.util.platform.api.service.order.jushuitan.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Map;

@Getter
@Setter
public class JushuitanTaoConfirmDeliveryOrderPackageItemDTO {

    //itemCode	String	I1234	商品编码
    private String itemCode;
    //itemId	String	WI1234	商品仓储系统编码
    private String itemId;
    //quantity	Number	11	包裹内该商品的数量
    private Integer quantity;
    //orderLineNo	String	1	单据行号
    private String orderLineNo;
    //extendProps	Map		商品列表扩展属性
    private Map<String, String> extendProps;
}
