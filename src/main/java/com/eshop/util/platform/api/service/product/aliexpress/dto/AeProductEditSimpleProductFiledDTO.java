package com.eshop.util.platform.api.service.product.aliexpress.dto;


import lombok.Getter;
import lombok.Setter;

/**
 * @author ldj
 * @date 2024/2/29 17:42
 * @Description: ...
 * @Version 1.0
 */
@Getter
@Setter
public class AeProductEditSimpleProductFiledDTO {
    //request.addApiParameter("product_id", "1234");
    //request.addApiParameter("fied_name", "deliveryTime");
    //request.addApiParameter("fiedvalue", "{  \"mobileDetail\": [  {        \"type\": \"text\",        \"content\": \" POSTAGE<>:  We provide free express shipping via UPS / DHL / FEDEX / EMS / TNT / ARAMEX / for most of country when your orders around US$200 (please contact us if you have qustions). Delivery time around 4-7 days (business days).NOTE<>: We have only one store called 'TWOTWINSTYLE' on aliexpress. The products selling in other stores with same designs or photos are not from us. 'TWOTWINSTYLE' have their own separate production lines, all merchandise sold are exclusive and high quality.\"      } ],  \"version\": \"1.0\",  \"versionNum\": 1}");
    private String product_id;
    private String fied_name;
    private String fiedvalue;
}
