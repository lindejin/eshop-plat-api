package com.eshop.util.platform.api.service.order.jushuitan.converter.vo;


import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class JushuitanErpOrderVO {

    /**
     * 订单信息
     */
    private JushuitanErpOrderInfoVO orderInfo;

    /**
     * 订单发件人信息
     */
    private JushuitanErpOrderSenderInfoVO senderInfo;

    /**
     * 订单收件人信息
     */
    private JushuitanErpOrderReceiverInfo receiverInfo;

    /**
     *  订单多明细
     *
     *    介绍：常规情况下来讲，平台会是一个SKU对应一条明细（orderline）,但是商家匹配组合装，
     *    或者赠品的场景，会存在一个SKU编码，在多条明细的场景下。我们建议WMS支持相同商品有多条
     *    明细的情况，这样可以更好的兼容线上单号、金额的取值。毕竟默认ERP做合并，这种明细级别的
     *    数据，就会随机取其中一条。
     *
     *    配置：默认合并，需要开启多明细，请前往云仓控制台-云仓配置-相同商品多行明细开启。
     */
    private List<JushuitanErpOrderLineInfo> orderLines;
}
