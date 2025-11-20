package com.eshop.util.platform.api.service.order.jushuitan.vo;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class JushuitanOrderPayRespVO {

    //is_order_pay	boolean	true	是否支付
    private Boolean is_order_pay;
    //buyer_account	string	38	支付帐号
    private String buyer_account;
    //amount	number	706.0	支付金额
    private BigDecimal amount;
    //pay_date	string	2019-12-1616:35:28	支付时间
    private String pay_date;
    //outer_pay_id	string	20210928	外部支付单号
    private String outer_pay_id;
    //pay_id	string	37163	支付单ID
    private String pay_id;
    //payment	string	微信	支付方式
    private String payment;
    //status	string		支付状态
    private String status;
    //pay_type	string		支付类型
    private String pay_type;
    //o_id	number		内部订单号
    private Long o_id;
}
