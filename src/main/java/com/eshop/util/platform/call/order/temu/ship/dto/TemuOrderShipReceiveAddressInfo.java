package com.eshop.util.platform.call.order.temu.ship.dto;

@lombok.Getter
@lombok.Setter
@lombok.ToString
public class TemuOrderShipReceiveAddressInfo {

    //districtCode	INTEGER	否	区编码
    private Long districtCode;
    //cityName	STRING	否	市
    private String cityName;
    //districtName	STRING	否	区
    private String districtName;
    //phone	STRING	否	联系电话
    private String phone;
    //provinceCode	INTEGER	否	省份编码
    private Long provinceCode;
    //cityCode	INTEGER	否	市编码
    private Long cityCode;
    //receiverName	STRING	否	收货人
    private String receiverName;
    //detailAddress	STRING	否	详细地址
    private String detailAddress;
    //provinceName	STRING	否	省
    private String provinceName;
}
