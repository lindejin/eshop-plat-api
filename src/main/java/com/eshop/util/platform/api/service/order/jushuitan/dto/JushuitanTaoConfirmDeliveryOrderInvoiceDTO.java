package com.eshop.util.platform.api.service.order.jushuitan.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class JushuitanTaoConfirmDeliveryOrderInvoiceDTO {

    //header	String	XXX公司	发票抬头
    private String header;
    //amount	String	12.0	发票金额
    private String amount;
    //content	String	XXX公司报销XX元	发票内容
    private String content;
    //detail	Detail		发货详情
    private JushuitanTaoConfirmDeliveryOrderInvoiceDetailDTO detail;
    //code	String	CODE123	发票代码(纳税企业的标识)
    private String code;
    //number	String	NUM123	发票号码(纳税企业内部的发票号)
    private String number;
}
