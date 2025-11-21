package com.eshop.util.platform.api.service.order.jushuitan.request;

import lombok.Data;

@Data
public class JushuitanPushExtendProps {
    //PrintMeta
    //通用打印数据（json串）
    //否
    //唯品会MP、小红书、微信视频号打印数据；
    //聚水潭系统有运单号且开启推送物流信息，则推送与之相关的面单打印数据
    private String printMeta;
    //drp_info
    //分销商公司信息
    //否
    //drp_co_id(分销公司ID)
    //+drp_co_name（分销公司名称）
    //
    //新商家默认隐藏不推送此字段，开启基础设置-云仓对接-其他单据-【聚水潭OMS】推送字段隐私保护，可开启分销商信息推送
    private String drpInfo;
    //pay_info
    //订单-付款方式
    //否
    //payment+付款方式
    private String payInfo;
    //tradeAttr
    //-
    //否
    //淘宝小时达信息串，json串，原样下发
    private String tradeAttr;
}
