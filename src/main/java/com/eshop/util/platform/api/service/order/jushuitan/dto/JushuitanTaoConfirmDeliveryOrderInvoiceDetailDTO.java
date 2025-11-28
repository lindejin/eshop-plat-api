package com.eshop.util.platform.api.service.order.jushuitan.dto;


import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class JushuitanTaoConfirmDeliveryOrderInvoiceDetailDTO {
    //items	Item[]		商品列表
    private List<JushuitanTaoConfirmDeliveryOrderInvoiceItemDTO> items;
}
