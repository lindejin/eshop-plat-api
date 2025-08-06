package com.eshop.util.platform.call.order.temu.order.vo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TemuFullOrderPurchaseOrderV2RespVO {

    //返回总数据Body
    private String respBody;

    /**
     * 说明:null
     * 是否必填:false
     * 类型标识:6，类型:object
     */
    private TemuFullOrderPurchaseOrderV2ResultVO result;


    /**
     * 说明:null
     * 是否必填:false
     * 类型标识:5，类型:boolean
     */
    private Boolean success;

    /**
     * 说明:null
     * 是否必填:false
     * 类型标识:1，类型:long
     */
    private Long errorCode;

    /**
     * 说明:null
     * 是否必填:false
     * 类型标识:4，类型:string
     */
    private String errorMsg;
}
