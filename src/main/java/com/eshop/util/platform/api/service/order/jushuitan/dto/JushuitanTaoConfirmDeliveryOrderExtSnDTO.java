package com.eshop.util.platform.api.service.order.jushuitan.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class JushuitanTaoConfirmDeliveryOrderExtSnDTO {

    //imei	String[]		imei
    private List<String> imei;
    //sn	String[]		sn
    private List<String> sn;
}
