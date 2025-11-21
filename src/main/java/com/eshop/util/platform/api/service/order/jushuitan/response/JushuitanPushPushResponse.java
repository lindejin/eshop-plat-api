package com.eshop.util.platform.api.service.order.jushuitan.response;

import lombok.Data;

@Data
public class JushuitanPushPushResponse {

    //flag
    //是否成功
    //是
    //
    //success=成功；failure=失败
    private String flag;

    //code
    //响应码
    //否
    //
    //
    private String code;

    //deliveryOrderId
    //仓储单据ID
    //否
    //外部单号，WMS返回则默认存储，售后单推送时preDeliberyOrderId）携带
    private String deliveryOrderId;

    //message
    //响应信息
    //否
    private String message;

    /**
     * 订单推送回传例子
     */
    /*
        //成功
        <?xml version="1.0" encoding="utf-8"?>
        <response>
            <flag>success</flag>
            <code>0</code>
            <message>WMS接单成功</message>
           <deliveryOrderId>WMS888888</deliveryOrderId>
        </response>


        //失败
        <?xml version="1.0" encoding="utf-8"?>
        <response>
            <flag>failure</flag>
            <code>19983</code>
            <message>WMS系统库存不足</message>
           <deliveryOrderId></deliveryOrderId>
        </response>
     */
    /**
     * 订单取消回传例子
     */
    /*
        //成功
        <?xml version="1.0" encoding="utf-8"?>
        <response>
            <flag>success</flag>
            <code>0</code>
            <message>WMS取消成功</message>
        </response>


        //失败
        <?xml version="1.0" encoding="utf-8"?>
        <response>
            <flag>failure</flag>
            <code>1998</code>
            <message>WMS系统已到不可取消环节，请联系客服！</message>
        </response>
     */
}
