package com.eshop.util.platform.api.service.order.jushuitan.vo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class JushuitanTaoConfirmDeliveryOrderResponseVO {

    //flag	String	success	响应结果:success|failure
    private String flag;
    //code	String	0	响应码
    private String code;
    //message	String	invalid appkey	响应信息
    private String message;


    /*
        //成功
        <?xml version="1.0" encoding="utf-8"?>
        <response>
            <flag>success</flag>
            <code>0</code>
            <message>进入异步发货队列成功!</message>
        </response>


        //失败
        <?xml version="1.0" encoding="utf-8"?>
        <response>
            <flag>failure</flag>
            <code>JST_DELIVERY_EXPRESS_ERROR</code>
            <message>发货失败! 您回传的物流编码[1082]在聚水潭系统找不到，可能导致运单号不能上传平台。请您按奇门规范回传标准的物流编码或者主动联系聚水潭商家维护物流映射规则，标准物流编码地址：https://open.taobao.com/api.htm?docId=26001&amp;docType=2 的[requestpackages - logisticsCode]字段。</message>
        </response>
     */
}
