package com.eshop.util.platform.api.service.order.jushuitan.request;

import lombok.Data;

@Data
public class JushuitanPushDeliveryOrderLine {
    //orderLineNo
    //行号
    //是
    //
    //
    private String orderLineNo;
    //sourceOrderCode
    //交易平台订单编码
    //
    //订单-线上单号
    //
    private String sourceOrderCode;
    //subSourceOrderCode
    //交易平台子订单编码
    //
    //
    //
    private String subSourceOrderCode;
    //ownerCode
    //货主编码
    //是
    //奇门配置-货主 
    //WMS提供
    private String ownerCode;
    //itemCode
    //sku商品编码
    //是
    //订单-商品编码
    //
    private String itemCode;
    //itemId
    //WMS系统商品编码
    //是
    //云仓商品管理-云仓商品编码
    //
    private String itemId;
    //extCode
    //平台商品编码
    //否
    //店铺商品管理-平台店铺商品编码
    //可配置款式编码
    private String extCode;
    //inventoryType
    //库存类型
    //是
    //
    //固定为“ZP”，销售订单只能出库正品
    private String inventoryType;
    //itemName
    //sku商品名称
    //是
    //订单-商品名称
    //
    private String itemName;
    //planQty
    //计划出库数量
    //是
    //
    //
    private Integer planQty;
    //actualQty
    //实际出库数量
    //否
    //
    //默认为“0”
    private Integer actualQty;
    //retailPrice
    //零售价
    //否
    //单价
    //开启奇门推送营收小计开关后推送；
    //很可能有
    //除不尽情况，建议使用明细行的商品总金额
    private String retailPrice;
    //actualPrice
    //零售价
    //否
    //单价
    //
    private String actualPrice;
    //expireDate
    //过期日期
    //否
    //
    //
    private String expireDate;
    //productDate
    //生产日期
    //否
    //
    //
    private String productDate;
    //batchCode
    //批次号
    //否
    //
    //
    private String batchCode;
    //remark
    //商品明细备注
    //否
    //订单-商品-备注
    private String remark;


    //request-orderLines-orderLine-extendProps----订单商品明细扩展节点
    private JushuitanPushDeliveryOrderLineExtendProps extendProps;
}
