package com.eshop.util.platform.api.service.order.jushuitan.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Map;

@Getter
@Setter
public class JushuitanTaoConfirmDeliveryOrderRequestDTO {
    //deliveryOrder	DeliveryOrder		发货单信息
    private JushuitanTaoConfirmDeliveryOrderDTO deliveryOrder;
    //packages	Package[]		包裹信息
    private List<JushuitanTaoConfirmDeliveryOrderPackageDTO> packages;
    //orderLines	OrderLine[]		单据列表
    private  List<JushuitanTaoConfirmDeliveryOrderLineDTO> orderLines;
    //extendProps	Map		扩展属性
    private Map<String, String> extendProps;
}
