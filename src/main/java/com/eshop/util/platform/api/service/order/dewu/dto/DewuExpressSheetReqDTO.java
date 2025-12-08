package com.eshop.util.platform.api.service.order.dewu.dto;

@lombok.Getter
@lombok.Setter
public class DewuExpressSheetReqDTO {

    //参数名称	参数类型	是否必填	参数示例	参数描述
    //order_no	String	非必填	-	订单号（订单号与售后单号必填一个）
    //after_sale_no	String	非必填	-	售后单号（订单号与售后单号必填一个）
    private String order_no;
    private String after_sale_no;
}
