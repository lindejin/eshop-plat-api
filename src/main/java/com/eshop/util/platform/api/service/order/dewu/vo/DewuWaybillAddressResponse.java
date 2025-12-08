package com.eshop.util.platform.api.service.order.dewu.vo;

@lombok.Getter
@lombok.Setter
public class DewuWaybillAddressResponse {

    //  province	String	-	目的地：省
    //  city	String	-	目的地：市
    //  region	String	-	目的地：区
    //  country	String	-	国家
    //  post_code	String	-	邮编
    //  detailed_address	String	-	详细地址（目前中通快递才会有值）

    private String province;

    private String city;

    private String region;

    private String country;

    private String street;

    private String post_code;

    private String detailed_address;
}
