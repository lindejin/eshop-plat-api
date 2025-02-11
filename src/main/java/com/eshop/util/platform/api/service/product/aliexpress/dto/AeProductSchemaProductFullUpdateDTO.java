package com.eshop.util.platform.api.service.product.aliexpress.dto;


import lombok.Getter;
import lombok.Setter;

/**
 * @author ldj
 * @date 2024/2/29 16:15
 * @Description: ...
 * @Version 1.0
 */
@Getter
@Setter
public class AeProductSchemaProductFullUpdateDTO {
    //request.addApiParameter("schema_full_update_request", "{\"category_id\":200000346,\"title_multi_language_list\":[{\"locale\":\"es_ES\",\"title\":\"test\"}],\"description_multi_language_list\":[{\"locale\":\"es_ES\",\"module_list\":[{\"type\":\"html\",\"html\":{\"content\":\"test\"}}]}],\"locale\":\"es_ES\",\"product_units_type\":\"100000000\",\"image_url_list\":[\"https://ae01.alicdn.com/kf/HTB1TZJRVkvoK1RjSZFwq6AiCFXa0.jpg_350x350.jpg\"],\"category_attributes\":{\"Brand Name\":{\"value\":\"200010868\"},\"Material\":{\"value\":[\"47\",\"49\"]},\"Clothing Length\":{\"value\":\"1876\"}},\"sku_info_list\":[{\"sku_code\":\"234\",\"inventory\":234,\"price\":23,\"discount_price\":12,\"sku_attributes\":{\"Size\":{\"value\":\"200000989\"},\"Color\":{\"alias\":\"32\",\"sku_image_url\":\"https://ae01.alicdn.com/kf/HTB1TZJRVkvoK1RjSZFwq6AiCFXa0.jpg_350x350.jpg\",\"value\":\"771\"}}}],\"inventory_deduction_strategy\":\"place_order_withhold\",\"package_weight\":234,\"package_length\":234,\"package_height\":234,\"package_width\":234,\"shipping_preparation_time\":3,\"shipping_template_id\":\"1000\",\"service_template_id\":\"0\",\"aliexpress_product_id\":32985684727}");
    //request.addApiParameter("developer_features", "{\"source\":\"Lengow\"}");
    private String schema_full_update_request;
    private String developer_features;
}
