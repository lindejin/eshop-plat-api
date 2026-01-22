package com.eshop.util.platform.api.service.order.jushuitan.vo;

import com.eshop.util.platform.api.structure.BaseResponseVO;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class JushuitanTaoConfirmDeliveryOrderRespVO extends BaseResponseVO {

    private  JushuitanTaoConfirmDeliveryOrderResponseVO response;


    //flag	String	success	响应结果:success|failure
    private String flag;
    //code	String	0	响应码
    private String code;
    //message	String	invalid appkey	响应信息
    private String message;
}
