package com.eshop.util.platform.api.service.order.jushuitan.converter.vo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class JushuitanErpOrderReceiverInfo {

    //name 收件人 是 销售出库单-收货人
    private String name;
    //mobile 移动电话 是 销售出库单-手机
    private String mobile;
    //province 省 是 销售出库单- 详细地址- 省
    private String province;
    //city 市 是 销售出库单- 详细地址- 市
    private String city;
    //area 区 是 销售出库单- 详细地址- 区
    private String area;
    //town 镇 否 销售出库单- 详细地址- 镇
    private String town;
    //detailAddress 详细地址 是 销售出库单- 详细地址- 详细地址
    private String detailAddress;
    //oaid oaid 否 - 淘系密文订单必传； 小红书密文订单必传； 1688平台传值中间带 -  ，为caid
    //淘系api open_id string 买家唯一id  通过这个id去调收件人解密接口
    private String oaid;

    //国家二字码
    //receiver_country string 国家
    private String country;
}
