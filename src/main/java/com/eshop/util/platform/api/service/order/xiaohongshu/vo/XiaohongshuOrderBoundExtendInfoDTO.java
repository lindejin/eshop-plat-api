package com.eshop.util.platform.api.service.order.xiaohongshu.vo;

import java.util.List;

@lombok.Getter
@lombok.Setter
public class XiaohongshuOrderBoundExtendInfoDTO {

    //  payNo	string	交易流水号
    //	payChannel	string	交易渠道，AliPay=支付宝，TP=微信
    //	productValue	number	订单价值（货值，订单商品申价之和（税前价））
    //	payAmount	number	订单支付金额（含运费）
    //	taxAmount	number	订单税金
    //	shippingFee	number	运费 含运费税
    //	discountAmount	number	订单优惠
    //	zoneCodes	array<string>	海关三级地址区域编码

    private String payNo;
    private String payChannel;
    private Double productValue;
    private Double payAmount;
    private Double taxAmount;
    private Double shippingFee;
    private Double discountAmount;
    private List<String> zoneCodes;
}
