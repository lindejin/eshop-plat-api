package com.eshop.util.platform.api.service.supply.aliexpress.dto;

import com.alibaba.fastjson.JSONObject;
import lombok.Getter;
import lombok.Setter;

/**
 * @author xxs
 * @date 2024/10/8
 * @Description: ...
 * @Version 1.0
 */
@Getter
@Setter
public class AeShipOrderVO {

    /**
     * 返回的json数据
     */
    private JSONObject jsonObj;

    /**
     * "0、成功；2、失败"
     */
    private int ack;

    /**
     * 返回信息
     */
    private String msg;

    /**
     * 物流单号
     */
    private String lbx;

    /**
     * 发货单号
     */
    private String consignOrderNo;
}
