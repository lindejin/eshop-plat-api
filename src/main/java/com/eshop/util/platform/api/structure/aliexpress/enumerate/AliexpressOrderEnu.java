package com.eshop.util.platform.api.structure.aliexpress.enumerate;

/**
 * @author ldj
 * @date 2024/2/28 10:40
 * @Description: ...
 * @Version 1.0
 */
public enum AliexpressOrderEnu {
    //request.setApiName("aliexpress.solution.order.receiptinfo.get");
    //获取订单收据信息
    GET_SOLUTION_ORDER_RECEIPT_INFO("aliexpress.solution.order.receiptinfo.get"),
    //request.setApiName("aliexpress.solution.order.get");
    //从速卖通获取订单清单
    GET_SOLUTION_ORDER_LIST("aliexpress.solution.order.get"),
    //request.setApiName("aliexpress.solution.order.fulfill");
    //为卖家配送订单
    FULFILL_SOLUTION_ORDER("aliexpress.solution.order.fulfill"),
    //request.setApiName("aliexpress.trade.seller.order.decrypt");
    //买家订单物流详情解密
    DECRYPT_ORDER("aliexpress.trade.seller.order.decrypt"),
    //request.setApiName("aliexpress.trade.seller.order.acceptcancel");
    //卖家同意取消订单
    ACCEPT_CANCEL_ORDER("aliexpress.trade.seller.order.acceptcancel"),
    //request.setApiName("aliexpress.trade.seller.order.refusecancel");
    //卖家拒绝取消订单
    REFUSE_CANCEL_ORDER("aliexpress.trade.seller.order.refusecancel"),
    //request.setApiName("aliexpress.taxation.platform.open.get");
    //平台固定参数获取
    GET_TAXATION_PLATFORM("aliexpress.taxation.platform.open.get"),
    //request.setApiName("aliexpress.trade.redefining.extendsbuyeracceptgoodstime");
    //延长买家收货时间
    EXTENDS_BUYER_ACCEPT_GOODS_TIME("aliexpress.trade.redefining.extendsbuyeracceptgoodstime"),
    //request.setApiName("aliexpress.trade.new.redefining.findorderbyid");
    //新版交易订单详情查询
    FIND_ORDER_BY_ID("aliexpress.trade.new.redefining.findorderbyid"),
    //request.setApiName("aliexpress.merchant.redefining.queryremarks");
    //查询卖家备注内容
    QUERY_REMARKS("aliexpress.merchant.redefining.queryremarks"),
    //request.setApiName("aliexpress.merchant.redefining.queryremark");
    //查询订单卖家备注
    QUERY_REMARK("aliexpress.merchant.redefining.queryremark"),
    //request.setApiName("aliexpress.trade.redefining.findloanlistquery");
    //查询订单放款信息
    FIND_LOAN_LIST_QUERY("aliexpress.trade.redefining.findloanlistquery"),
    //request.setApiName("aliexpress.trade.redefining.findordertradeinfo");
    //订单交易信息查询
    FIND_ORDER_TRADE_INFO("aliexpress.trade.redefining.findordertradeinfo"),
    //request.setApiName("aliexpress.trade.seller.orderlist.get");
    //订单列表查询
    ORDER_LIST_GET("aliexpress.trade.seller.orderlist.get"),
    //request.setApiName("aliexpress.trade.redefining.findorderlistsimplequery");
    //订单列表简化查询
    FIND_ORDER_LIST_SIMPLE_QUERY("aliexpress.trade.redefining.findorderlistsimplequery"),
    //request.setApiName("aliexpress.trade.redefining.findorderbaseinfo");
    //订单基础信息查询
    FIND_ORDER_BASE_INFO("aliexpress.trade.redefining.findorderbaseinfo"),
    //request.setApiName("aliexpress.trade.redefining.findorderreceiptinfo");
    //订单收货信息查询
    FIND_ORDER_RECEIPT_INFO("aliexpress.trade.redefining.findorderreceiptinfo"),
    //request.setApiName("aliexpress.merchant.redefining.saveremark");
    //记录订单备注信息
    SAVE_REMARK("aliexpress.merchant.redefining.saveremark");

    private final String apiName;

    AliexpressOrderEnu(String apiName) {
        this.apiName = apiName;
    }

    public String getApiName() {
        return this.apiName;
    }

}
