package com.eshop.util.platform.api.service.product.aliexpress.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * @author ldj
 * @date 2024/3/7 15:36
 * @Description: ...
 * @Version 1.0
 */
@Getter
@Setter
public class AeopAeEditMultipleProductSkuStocksReqDTO {
    //product_id	Number	否	产品ID
    private Number product_id;
    //sku_stocks	Object	否	SKU的库存信息(一个或着多个),格式{"id":number1,"id":number2}。number为要编辑的可售库存数量。其中id可以通过商品查询接口：aliexpress.offer.product.query 中的aeop_ae_product_s_k_us列表中各个sku对象中“id”字段值进行获取, 没有sku销售属性的商品其id必须回传“<none>”值，例如：{"<none>":240}
    private String sku_stocks;
}
