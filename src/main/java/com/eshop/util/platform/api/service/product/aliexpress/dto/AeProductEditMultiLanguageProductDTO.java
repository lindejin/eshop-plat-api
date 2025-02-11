package com.eshop.util.platform.api.service.product.aliexpress.dto;


import lombok.Getter;
import lombok.Setter;

/**
 * @author ldj
 * @date 2024/2/29 17:44
 * @Description: ...
 * @Version 1.0
 */
@Getter
@Setter
public class AeProductEditMultiLanguageProductDTO {
    //request.addApiParameter("product_id", "32234411234");
    //request.addApiParameter("aeop_a_e_product_multilanguage_info", "{\"mobile_detail\":\"{    \\\"mobileDetail\\\": [        {            \\\"content\\\": \\\"context1\\\",            \\\"type\\\": \\\"text\\\"        },        {            \\\"col\\\": 1,            \\\"images\\\": [                {                    \\\"height\\\":500,                    \\\"imgUrl\\\": \\\"https://ae01.alicdn.com/kf/HTB1WQ.MKpXXXXXhXVXXq6xXFXXX6.jpg\\\",                    \\\"width\\\":500,                    \\\"targetUrl\\\":\\\"https://ae01.alicdn.com/kf/HTB1WQ.MKpXXXXXhXVXXq6xXFXXX6.jpg\\\"                },                {                    \\\"imgUrl\\\": \\\"https://ae01.alicdn.com/kf/HTB1WQ.MKpXXXXXhXVXXq6xXFXXX6.jpg\\\",                    \\\"targetUrl\\\":\\\"https://ae01.alicdn.com/kf/HTB1WQ.MKpXXXXXhXVXXq6xXFXXX6.jpg\\\"                }            ],            \\\"type\\\": \\\"image\\\"        },        {            \\\"content\\\": \\\"context3\\\",            \\\"type\\\": \\\"text\\\"        }    ],    \\\"version\\\": \\\"1.0\\\",    \\\"versionNum\\\": 1}\",\"subject\":\"foo\",\"detail\":\"bar\",\"locale\":\"ru_RU\"}");
    private String product_id;
    private String aeop_a_e_product_multilanguage_info;
}
