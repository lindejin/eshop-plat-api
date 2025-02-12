package com.eshop.util.platform.call.order.temu.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TemuOrderPoAfterSalesParentReturnOrderGetReqDTO {

    //parentAfterSalesSn	STRING	是	售后父单号,必填
    private String parentAfterSalesSn;
    //afterSalesSn	STRING	否	售后子单号,非必填
    private String afterSalesSn;
}
