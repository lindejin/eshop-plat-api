package com.eshop.sync.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * @author ldj
 * @date 2024/3/16 11:09
 * @Description: ...
 * @Version 1.0
 */
@Setter
@Getter
public class DhOrderShipmentTrackingReqDTO {
    //请求参数
    //参数名称	参数类型	是否必须	取值说明	参数说明
    //trackno	String	必须		运单号
    private String trackno;
    //shippingtype	String	必须		物流方式，如e-ulink等
    private String shippingtype;
    //language	String	必须		语言，只能是EN或CN
    private String language;
}
