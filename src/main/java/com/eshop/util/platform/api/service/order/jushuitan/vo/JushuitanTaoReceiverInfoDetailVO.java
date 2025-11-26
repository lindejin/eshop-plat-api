package com.eshop.util.platform.api.service.order.jushuitan.vo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class JushuitanTaoReceiverInfoDetailVO {

    //oaid	String	订单收件人 ID, string (50)	订单收件人 ID, string (50)
    private String oaid;
    //name	String	姓名, string (50) , 必填	姓名, string (50) , 必填
    private String name;
    //tel	String	固定电话, string (50)	固定电话, string (50)
    private String tel;
    //mobile	String	移动电话, string (50) , 必填	移动电话, string (50) , 必填
    private String mobile;
    //countryCode	String	国家二字码，string(50)	国家二字码，string(50)
    private String countryCode;
    //province	String	省份, string (50) , 必填	省份, string (50) , 必填
    private String province;
    //detailAddress	String	详细地址, string (200) , 必填	详细地址, string (200) , 必填
    private String detailAddress;
    //city	String	杭州	收件人所在城市
    private String city;
    //district	String	余杭区	收件人所在区
    private String district;
    //town	String	五常街道	收件人所在街道
    private String town;

}
