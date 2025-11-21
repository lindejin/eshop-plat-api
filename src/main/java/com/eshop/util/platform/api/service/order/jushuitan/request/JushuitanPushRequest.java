package com.eshop.util.platform.api.service.order.jushuitan.request;

import lombok.Data;

import java.util.List;

@Data
public class JushuitanPushRequest {

    /**
     * 订单推送
     */
    //request-deliveryOrder-----主单节点
    private JushuitanPushDeliveryOrder deliveryOrder;
    //request-orderLines-----商品列表节点
    private List<JushuitanPushDeliveryOrderLine> orderLines;
    //request-extendProps----主扩展节点
    private JushuitanPushExtendProps extendProps;

    /**
     * 订单取消
     */
    //warehouseCode 外部仓库编码
    //必填 是
    //OMS字段值 warehouseCode 奇门配置-仓库代码
    private String warehouseCode;

    //ownerCode 货主编码
    //必填 是
    //OMS字段值 customerid 奇门配置-货主
    private String ownerCode;

    //orderCode OMS订单号
    //必填 是
    //OMS字段值 销售出库单-出仓单号
    private String orderCode;

    //orderType单据类型
    //必填 是
    //OMS字段值 -  销售订单取消类型，固定为“JYCK”
    private String orderType;
    
    //cancelReason 取消原因
    //必填 是
    //OMS字段值 - ERP转异常原因，例如已退款等
    private String cancelReason;
}
