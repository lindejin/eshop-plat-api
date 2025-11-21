package com.eshop.util.platform.api.service.order.jushuitan.request;

import lombok.Data;

@Data
public class JushuitanPushReceiverInfo {

    //name
    //收件人
    //是
    //销售出库单-收货人
    //
    private String name;
    //mobile
    //移动电话
    //是
    //销售出库单-手机
    //
    private String mobile;
    //province
    //省
    //是
    //销售出库单-
    //详细地址-
    //省
    //
    private String province;
    //city
    //市
    //是
    //销售出库单-
    //详细地址-
    //市
    //
    private String city;
    //area
    //区
    //是
    //销售出库单-
    //详细地址-
    //区
    //
    private String area;
    //town
    //镇
    //否
    //销售出库单-
    //详细地址-
    //镇
    private String town;
    //detailAddress
    //详细地址
    //是
    //销售出库单-
    //详细地址-
    //详细地址
    //
    private String detailAddress;
    //oaid
    //oaid
    //否
    //-
    //淘系密文订单必传；
    //小红书密文订单必传；
    //1688平台传值中间带 -  ，为caid
    private String oaid;
    //idNumber
    //身份证号
    //否
    //订单-收件人-身份证
    //需要开启基础配置-推送身份证信息
    private String idNumber;

    //request-deliveryOrder-receiverInfo-extendProps----收件人信息节点
    private JushuitanPushReceiverExtendProps extendProps;
}
