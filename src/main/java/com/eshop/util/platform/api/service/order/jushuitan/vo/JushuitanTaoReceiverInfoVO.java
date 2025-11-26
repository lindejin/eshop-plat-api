package com.eshop.util.platform.api.service.order.jushuitan.vo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class JushuitanTaoReceiverInfoVO {
    //flag	String	success|failure，必填	success|failure，必填
    private String flag;
    //code	String	响应码	响应码
    private String code;
    //message	String	响应信息	响应信息
    private String message;
    //oaid	String	订单收件人 ID, string (50)	订单收件人 ID, string (50)
    private String oaid;
    //deliveryOrderCode	String	出库单号, string (50) , 必填	出库单号, string (50) , 必填
    private String deliveryOrderCode;
    //receiverInfo	ReceiverInfo		收货人信息
    private JushuitanTaoReceiverInfoDetailVO receiverInfo;
}
