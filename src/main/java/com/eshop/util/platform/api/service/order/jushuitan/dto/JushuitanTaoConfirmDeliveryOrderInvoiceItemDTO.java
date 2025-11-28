package com.eshop.util.platform.api.service.order.jushuitan.dto;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class JushuitanTaoConfirmDeliveryOrderInvoiceItemDTO {
    //itemName	String	淘公仔	商品名称
    private String itemName;
    //unit	String	个	商品单位
    private String unit;
    //price	String	12.0	商品单价
    private String price;
    //quantity	Number	12	数量
    private Integer quantity;
    //amount	String	12.0	金额
    private String amount;
    //itemCode	String	1234	商品编码
    private String itemCode;
    //itemId	String	1234	商品仓储系统编码
    private String itemId;
}
