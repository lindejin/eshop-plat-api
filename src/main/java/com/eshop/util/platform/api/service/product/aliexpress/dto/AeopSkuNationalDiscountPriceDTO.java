package com.eshop.util.platform.api.service.product.aliexpress.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * @author ldj
 * @date 2024/3/2 16:47
 * @Description: ...
 * @Version 1.0
 */
@Getter
@Setter
public class AeopSkuNationalDiscountPriceDTO {
    //discount_price	String	否	sku分国家的日常促销价价格
    private String discount_price;
    //shipto_country	String	否	sku分国家的日常促销价的国家：ISO两位的国家编码（目前支持国家：RU US CA ES FR UK NL IL BR CL AU UA BY JP TH SG KR ID MY PH VN IT DE SA AE PL TR）
    private String shipto_country;
}
