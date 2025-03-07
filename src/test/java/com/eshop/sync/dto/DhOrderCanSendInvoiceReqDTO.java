package com.eshop.sync.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * @author ldj
 * @date 2024/3/16 11:09
 * @Description: ...
 * @Version 1.0
 */
@Setter
@Getter
public class DhOrderCanSendInvoiceReqDTO {
    //请求参数
    //参数名称	参数类型	是否必须	取值说明	参数说明
    //orderNo	String	必须	卖家后台登录能看到成交的订单号;示例值:1330312162	订单号
    private String orderNo;
}
