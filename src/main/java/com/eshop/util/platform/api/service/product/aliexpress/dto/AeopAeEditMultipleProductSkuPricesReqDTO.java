package com.eshop.util.platform.api.service.product.aliexpress.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * @author ldj
 * @date 2024/3/7 15:34
 * @Description: ...
 * @Version 1.0
 */
@Getter
@Setter
public class AeopAeEditMultipleProductSkuPricesReqDTO {
    //名称	类型	是否必须	描述
    //product_id	Number	否	商品id
    private Number product_id;
    //sku_id_price_map	Object	否	商品sku与价格映射表。 SKU的价格信息(一个或着多个),格式{"id1":price1,"id2":price2}； 其中id可以通过商品查询接口：aliexpress.offer.product.query 中的aeop_ae_product_s_k_us列表中各个sku对象中“id”字段值进行获取, 没有sku销售属性的商品其id必须回传“<none>”值，例如：{ "<none>": "0.6"}
    private String sku_id_price_map;
}
