package com.eshop.util.platform.api.service.order.jushuitan.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class JushuitanTaoConfirmDeliveryOrderImeiDTO {
    //extSnList	ExtSn[]		extSn
    private List<JushuitanTaoConfirmDeliveryOrderExtSnDTO> extSnList;
}
