package com.eshop.util.platform.api.service.product.aliexpress.dto;


import lombok.Getter;
import lombok.Setter;

/**
 * @author ldj
 * @date 2024/2/29 15:52
 * @Description: ...
 * @Version 1.0
 */
@Getter
@Setter
public class AeProductSchemaProductInstancePostDTO {
    //request.addApiParameter("product_instance_request", "{     \"category_id\": 348,     \"title_multi_language_list\":     [         {             \"locale\": \"es_ES\",             \"title\": \"atestproducttesttest001\"         }     ],     \"description_multi_language_list\":     [         {             \"locale\": \"es_ES\",             \"module_list\":             [                 {                     \"type\": \"html\",                     \"html\":                     {                         \"content\": \"unotesttestdescription002\"                     }                 }             ]         }     ],     \"locale\": \"es_ES\",     \"product_units_type\": \"100000015\",     \"image_url_list\":     [         \"https://upload.wikimedia.org/wikipedia/commons/b/ba/E-SENS_architecture.jpg\"     ],     \"category_attributes\":     {         \"Brand Name\":         {             \"value\": \"200010868\"         },         \"ShirtsType\":         {             \"value\": \"200001208\"         },         \"Material\":         {             \"value\":             [                 \"567\"             ]         },         \"SleeveLength(cm)\":         {             \"value\": \"200001500\"         }     },     \"sku_info_list\":     [         {             \"sku_code\": \"WEO19293829123\",             \"inventory\": 3,             \"price\": 9900,             \"discount_price\": 9800,             \"sku_attributes\":             {                 \"Size\":                 {                     \"alias\": \"Uni\",                     \"value\": \"200003528\"                 }             }         }     ],     \"inventory_deduction_strategy\": \"payment_success_deduct\",     \"package_weight\": 1.5,     \"package_length\": 10,     \"package_height\": 20,     \"package_width\": 30,     \"shipping_preparation_time\": 3,     \"shipping_template_id\": \"714844311\",     \"service_template_id\": \"0\" }");
    private String product_instance_request;
    //request.addApiParameter("developer_features", "{\"source\":\"Lengow\"}");
    private String developer_features;

}
