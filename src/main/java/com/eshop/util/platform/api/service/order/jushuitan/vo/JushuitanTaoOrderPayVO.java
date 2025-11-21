package com.eshop.util.platform.api.service.order.jushuitan.vo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class JushuitanTaoOrderPayVO {
    //名称	类型	是否必须	示例值	描述
    //status	string			支付信息状态
    private String status;
    //outer_pay_id	string			外部支付单号
    private String outer_pay_id;
    //pay_date	string			支付时间
    private String pay_date;
    //amount	string			支付金额
    private String amount;
    //payment	string			支付渠道
    private String payment;
    //buyer_account	string			支付帐号
    private String buyer_account;
    //is_order_pay	bool			是否支付
    private Boolean is_order_pay;
    //pay_id	string			支付单ID
    private String pay_id;
}
