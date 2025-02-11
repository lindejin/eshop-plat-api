package com.eshop.util.platform.api.service.product.aliexpress.dto;


import lombok.Getter;
import lombok.Setter;

/**
 * @author ldj
 * @date 2024/2/29 13:44
 * @Description: ...
 * @Version 1.0
 */
@Getter
@Setter
public class AeProductBatchProductPriceUpdateDTO {
    //        request.addApiParameter("mutiple_product_update_list", "[{\"product_id\":\"1000005237852\",\"multi_country_price_configuration\":{\"price_type\":\"absolute\",\"country_price_list\":[{\"sku_price_by_country_list\":[{\"price\":\"15\",\"discount_price\":\"13.99\",\"sku_code\":\"abc123\"},{\"price\":\"15\",\"discount_price\":\"13.99\",\"sku_code\":\"abc123\"}],\"ship_to_country\":\"FR\"},{\"sku_price_by_country_list\":[{\"price\":\"15\",\"discount_price\":\"13.99\",\"sku_code\":\"abc123\"},{\"price\":\"15\",\"discount_price\":\"13.99\",\"sku_code\":\"abc123\"}],\"ship_to_country\":\"FR\"}]},\"multiple_sku_update_list\":[{\"discount_price\":\"14.99\",\"price\":\"19.99\",\"sku_code\":\"123abc\"},{\"discount_price\":\"14.99\",\"price\":\"19.99\",\"sku_code\":\"123abc\"}]}]");
    private String mutiple_product_update_list;
}
