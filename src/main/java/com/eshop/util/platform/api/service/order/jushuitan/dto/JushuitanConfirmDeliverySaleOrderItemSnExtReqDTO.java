package com.eshop.util.platform.api.service.order.jushuitan.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class JushuitanConfirmDeliverySaleOrderItemSnExtReqDTO {

    //sn	string	否		唯一码
    private String sn;
    //imei	string	否		imei码（多个逗号隔开）
    private String imei;
}
