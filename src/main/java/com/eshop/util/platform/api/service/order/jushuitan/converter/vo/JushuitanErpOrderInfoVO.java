package com.eshop.util.platform.api.service.order.jushuitan.converter.vo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class JushuitanErpOrderInfoVO {

    //主动推送 deliveryOrderCode OMS订单号 是 销售出库单-出仓单号
    //淘系 io_id 出库单号 只有淘系订单才有 需要单开一个【OMS订单号】，作为取消接口的入参
    private String deliveryOrderCode;

    //oaidOrderSourceCode oaid对应线上单号 否 - 淘系oaid对应的线上单号，唯一
    //淘系 so_id string 线上订单号
    //是自研ERP的销售订单号
    private String oaidOrderSourceCode;

    //orderType 单据类型是默认”JYCK“，若唯品会JITX补寄订单，则推送”BFCK“；
    //如果是聚水潭补发、换货类型订单，可以开通功能推送”BFCK“、”HHCK“类型，详情介绍见该页：5.2 订单多类型
    private String orderType;

    //warehouseCode外部仓库编码是奇门配置-仓库代码WMS提供
    //淘系 wms_co_id int 分仓编号 对接以后聚水潭会提供给我们
    private String warehouseCode;



    //latestDeliveryTime 最晚发货时间 否 订单-计划发货日期
    private String latestDeliveryTime;
    //createTime 单据创建时间 是 订单审核时间
    //淘系 created string 登记时间 对应ERP销售订单的创建时间 创建时间是取这个还是接口创建的时间，都行
    private String createTime;
    //payNo 支付平台交易号 否 订单-支付单号
    private String payNo;

    //shop_id	integer	11690153	店铺编号
    private Long shopId;
    //shopNick 店铺名称 是 销售出库单-店铺名称
    //
    private String shopNick;

    //buyerNick 买家昵称 是 订单-买家账号
    //淘系 shop_buyer_id string 买家帐号 先存在后台表
    private String buyerNick;

    //totalAmount 订单总金额 (元) 是 商品总金额+运费-折扣金额 受奇门配置-金额隐藏影响，开启则推0
    //主动拉取的需要自己计算
    private String totalAmount;

    //itemAmount 商品总金额 (元) 是 订单项(实际成交金额*应发数量)总和
    //淘系  pay_amount  string 应付金额
    private String itemAmount;

    // discountAmount 订单折扣金额 (元) 是 订单表里的折扣金额
    //淘系 free_amount string 优惠金额 --- 折扣金额
    private String discountAmount;
    // freight 快递费用 (元  ) 是 订单表里的运费金额
    //淘系 freight  string  运费
    private String freight;
    //gotAmount 已收金额 (元) 是 不是货到付款状态:订单表中的实付金额 是货到付款： 0
    //淘系 paid_amount string 已付金额 --- 实际已付金额
    private String gotAmount;

    //logisticsCode 快递公司编码 是 销售出库单-快递公司
    //lc_id string 快递公司编码 需要存储在后台
    private String logisticsCode;
    //expressCode 物流单号 否 销售出库单-物流单号 订单有运单号且开启奇门配置-推送物流信息才会推送该字段；否则为空
    //l_id string 是 快递单号
    private String expressCode;
    //insuranceFlag 是否需要保价, Y/N 是  推送前提：
    //1、开启奇门配置保价推送
    //2、物流设置保价规则，且对应订单需要获取面单号并命中该规则，有保价金额则为“Y”
    private String insuranceFlag;



    //api接口拉取补充 以淘系为基准
    // status string 出库单状态：Archive:归档,WaitConfirm:待出库,Confirmed:已出库,Cancelled:取消,Delete:作废,OuterConfirming:外部发货中
    // 都是WaitConfirm:待出库
    private String  status;

    //invoice_title string 发票抬头
    //先存在后台表
    private String invoiceTitle;


    //这个要新开发
    //buyer_message string 买家留言
    private String buyerMessage;

    //buyer_tax_no string 发票税号  先存在后台表
    private String  buyerTaxNo;

    // warehouse string 仓库名称  只显示不保存
//    private String  warehouse;

    //type	string	普通订单	订单类型，普通订单；补发订单；分销Plus；供销Plus；换货订单
    private String  type;
}
