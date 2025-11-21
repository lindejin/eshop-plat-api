package com.eshop.util.platform.api.service.order.jushuitan.request;

import lombok.Data;

@Data
public class JushuitanPushReceiverExtendProps {
    //realName
    //身份证姓名
    //否
    //订单-收件人-真实姓名
    //需要开启基础配置-推送身份证信息

    private String idNumber;

}
