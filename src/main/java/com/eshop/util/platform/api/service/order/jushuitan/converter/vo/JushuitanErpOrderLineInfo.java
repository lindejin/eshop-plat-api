package com.eshop.util.platform.api.service.order.jushuitan.converter.vo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class JushuitanErpOrderLineInfo {

    //orderLineNo  行号  是
    private String orderLineNo;
    //ownerCode  货主编码  是  奇门配置-货主  WMS提供
    private String ownerCode;
    //itemCode  sku商品编码  是  订单-商品编码
    private String itemCode;
    //inventoryType  库存类型  是    固定为“ZP”，销售订单只能出库正品
    private String inventoryType;
    //planQty  计划出库数量  是
    private Integer planQty;
    //retailPrice  零售价  否  单价  开启奇门推送营收小计开关后推送；  很可能有  除不尽情况，建议使用明细行的商品总金额
    private String retailPrice;
    //actualPrice  零售价  否  单价
    private String actualPrice;


    //isGift  是否赠品标识  是  1-赠品；  0-非赠品
    private Integer isGift;
    //combine_sku_id  组合装编码  否
    private String combine_sku_id;
    //combine_sku_quantity  组合装数量  否
    private Integer combine_sku_quantity;
    //buyer_paidamount  买家实付金额（明细）  否  订单详情-营收小计-买家实付  按金额占比分摊明细
    private String buyer_paidamount;
    //sellerIncome_amount  商家实收  否  订单详情-营收小计-商家实收  按金额占比分摊明细
    private String sellerIncome_amount;
    //platform_freeamount  平台优惠总金额  否  营收小计-平台补贴  开启奇门推送营收小计开关后推送；  按金额占比分摊明细
    private String platform_freeamount;
    //venderFee  邮费  否  订单邮费  开启奇门推送营收小计开关后推送；  按金额占比分摊明细
    private String venderFee;
}
