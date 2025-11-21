package com.eshop.util.platform.api.service.order.jushuitan.request;

import lombok.Data;

@Data
public class JushuitanPushDeliveryOrderExtendProps {

    //oid
    //内部订单号
    //是
    //内部订单号
    //
    private String oid;
    //subOrderType
    //订单-店铺-店铺站点编码
    //否
    //站点编码
    //ERP内给平台定义的站点编码
    private String subOrderType;
    //isDecrypt
    //拼多多或京东是否加密字符串
    //否
    //拼多多或京东是否加密字符串
    //否=“false”；
    //是=“true”
    private String isDecrypt;
    //shopId
    //店铺编号
    //否
    //店铺信息-店铺编号
    //
    private String shopId;
    //isJitx
    //是否JITX订单
    //是
    //标签是否含有JITX
    //否=“false”；
    //是=“true”
    private String isJitx;
    //vendorType
    //订单类型
    //否
    //标签是否含有JITX
    //否=空；
    //是=“
    //JITX”
    private String vendorType;
    //vendorId
    //唯品供应商ID
    //否
    //唯品供应商ID
    //
    private String vendorId;
    //labels
    //销售出库单标签
    //否
    //销售出库单-标记|多标签
    //标签名，多个以英文逗号拼接
    private String labels;
    //buyer_paidamount
    //买家实付金额
    //否
    //订单详情-营收小计-买家实付
    //受奇门金额隐私影响；
    //开启奇门推送营收小计开关后推送
    private String buyerPaidamount;
    //sellerIncome_amount
    //商家实收
    //否
    //订单详情-营收小计-商家实收
    //受奇门金额隐私影响；
    //开启奇门推送营收小计开关后推送
    private String sellerIncomeAmount;
    //platform_freeamount
    //平台优惠总金额
    //否
    //营收小计-平台补贴
    //开启奇门推送营收小计开关后推送
    private String platformFreeamount;
    //store_id
    //门店编码
    //否
    //
    //抖音小时达专用
    private String storeId;
    //store_name
    //门店名称
    //否
    //
    //抖音小时达专用
    private String storeName;
}
