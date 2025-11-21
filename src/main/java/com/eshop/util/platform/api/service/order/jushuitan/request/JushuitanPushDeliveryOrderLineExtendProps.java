package com.eshop.util.platform.api.service.order.jushuitan.request;

import lombok.Data;

@Data
public class JushuitanPushDeliveryOrderLineExtendProps {

    //shop_i_id
    //店铺款号
    //是
    //订单项-平台店铺款式编码
    //
    private String shop_i_id;
    //shop_sku_id
    //平台商品ID
    //否
    //订单项-
    //平台店铺商品编码
    //
    private String shop_sku_id;
    //isGift
    //是否赠品标识
    //是
    //1-赠品；
    //0-非赠品
    private Integer isGift;
    //combine_sku_id
    //组合装编码
    //否
    private String combine_sku_id;
    //combine_sku_quantity
    //组合装数量
    //否
    private Integer combine_sku_quantity;
    //buyer_paidamount
    //买家实付金额（明细）
    //否
    //订单详情-营收小计-买家实付
    //按金额占比分摊明细
    private String buyer_paidamount;
    //sellerIncome_amount
    //商家实收
    //否
    //订单详情-营收小计-商家实收
    //按金额占比分摊明细
    private String sellerIncome_amount;
    //platform_freeamount
    //平台优惠总金额
    //否
    //营收小计-平台补贴
    //开启奇门推送营收小计开关后推送；
    //按金额占比分摊明细
    private String platform_freeamount;
    //venderFee
    //邮费
    //否
    //订单邮费
    //开启奇门推送营收小计开关后推送；
    //按金额占比分摊明细
    private String venderFee;
    //itemTotalAmount
    //单价*数量
    //否
    //商品金额
    //开启奇门推送营收小计开关后推送；
    //按金额占比分摊明细
    private String itemTotalAmount;
}
