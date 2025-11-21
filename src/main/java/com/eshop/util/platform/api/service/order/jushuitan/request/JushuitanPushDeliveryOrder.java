package com.eshop.util.platform.api.service.order.jushuitan.request;

import lombok.Data;

@Data
public class JushuitanPushDeliveryOrder {

    //deliveryOrderCode
    //OMS订单号
    //是
    //销售出库单-出仓单号
    //
    private  String deliveryOrderCode;
    //orderType
    //单据类型
    //是
    //
    //默认”JYCK“，若唯品会JITX补寄订单，则推送”BFCK“；
    //
    //如果是聚水潭补发、换货类型订单，可以开通功能推送”BFCK“、”HHCK“类型，详情介绍见该页：5.2 订单多类型
    private String orderType;
    //warehouseCode
    //外部仓库编码
    //是
    //奇门配置-仓库代码
    //WMS提供
    private String warehouseCode;

    //oaidOrderSourceCode
    //oaid对应线上单号
    //否
    //-
    //淘系oaid对应的线上单号，唯一
    private String oaidOrderSourceCode;
    //latestDeliveryTime
    //最晚发货时间
    //否
    //订单-计划发货日期
    private String latestDeliveryTime;
    //sourcePlatformCode
    //平台来源编码
    //是
    //
    //按奇门标准传值，详情见 5.1
    private String sourcePlatformCode;
    //sourcePlatformName
    //平台来源名称
    //是
    //
    //
    private String sourcePlatformName;
    //createTime
    //单据创建时间
    //是
    //订单审核时间
    //
    private String createTime;
    //placeOrderTime
    // 前台订单 (店铺订单) 创建时间 (下单时间)
    //是
    //订单审核时间
    //
    private String placeOrderTime;
    //payTime
    //付款时间
    //是
    //订单-支付日期
    //
    private String payTime;
    //payNo
    //支付平台交易号
    //否
    //订单-支付单号
    //
    private String payNo;
    //operateTime
    //操作时间
    //是
    //订单审核时间
    //
    private String operateTime;
    //shopNick
    //店铺名称
    //是
    //销售出库单-店铺名称
    //
    private String shopNick;
    //buyerNick
    //买家昵称
    //是
    //订单-买家账号
    //代发业务会使用该字段传店铺ID一类信息，详情可见菜单【关于收件人加密】
    private String buyerNick;
    //totalAmount
    //订单总金额 (元)
    //是
    //商品总金额+运费-折扣金额
    //受奇门配置-金额隐藏影响，开启则推0
    private String totalAmount;
    //itemAmount
    //商品总金额 (元)
    //是
    //订单项(实际成交金额*应发数量)总和
    //
    private String itemAmount;
    //discountAmount
    //订单折扣金额 (元)
    //是
    //订单表里的折扣金额
    //
    private String discountAmount;
    //freight
    //快递费用 (元  )
    //是
    //订单表里的运费金额
    //
    private String freight;
    //arAmount
    //应收金额 (元)
    //是
    //
    //
    private String arAmount;
    //gotAmount
    //已收金额 (元)
    //是
    //不是货到付款状态:订单表中的实付金额
    //是货到付款：
    //0
    //
    //
    private String gotAmount;
    //serviceFee
    //COD 服务费
    //是
    //
    //
    private String serviceFee;
    //logisticsCode
    //快递公司编码
    //是
    //销售出库单-快递公司
    //
    private String logisticsCode;
    //logisticsName
    //快递公司名称
    //是
    //
    //
    private String logisticsName;
    //expressCode
    //物流单号
    //否
    //销售出库单-物流单号
    //订单有运单号且开启奇门配置-推送物流信息才会推送该字段；否则为空
    private String expressCode;
    //insuranceFlag
    //是否需要保价, Y/N
    //是
    //
    //推送前提：
    //1、开启奇门配置保价推送
    //2、物流设置保价规则，且对应订单需要获取面单号并命中该规则，有保价金额则为“Y”
    private String insuranceFlag;
    //sellerMessage
    //卖家留言
    //否
    //订单-卖家备注
    //
    private String sellerMessage;
    //buyerMessage
    //买家留言
    //否
    //买家留言
    //
    private String buyerMessage;
    //remark
    //备注
    //否
    //-
    //不是订单的线下备注！
    //推送内容：订单-线上单号；
    //可配置商家端基础设置【【聚水潭OMS】订单推送时，备注（remark）不推送线上单号】开启
    private String remark;

    //request-deliveryOrder-deliveryRequirements-----发货要求
    private JushuitanPushDeliveryRequirements deliveryRequirements;

    //request-deliveryOrder-senderInfo-----发件人信息节点
    private JushuitanPushSenderInfo senderInfo;

    //request-deliveryOrder-receiverInfo-----收件人信息节点（如果是加密订单会推送平台的原始密文串，各个平台密文规则不同，可以见菜单“关于订单收件人加密”）
    private JushuitanPushReceiverInfo receiverInfo;

    //request-deliveryOrder-extendProps----主单扩展节点
    private JushuitanPushDeliveryOrderExtendProps extendProps;
    
}
