package com.eshop.util.platform.call.order.temu.ship.vo;

@lombok.Getter
@lombok.Setter
@lombok.ToString
public class TemuOrderShipStagingGetReceiveAddressInfoVO {
    //districtCode	INTEGER	区编码
    private Long districtCode;
    //cityName	STRING	市
    private String cityName;
    //districtName	STRING	区
    private String districtName;
    //provinceCode	INTEGER	省份编码
    private Long provinceCode;
    //cityCode	INTEGER	市编码
    private Long cityCode;
    //detailAddress	STRING	详细地址
    private String detailAddress;
    //provinceName	STRING	省
    private String provinceName;
}
