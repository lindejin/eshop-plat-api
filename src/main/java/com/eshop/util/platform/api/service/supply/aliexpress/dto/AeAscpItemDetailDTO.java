package com.eshop.util.platform.api.service.supply.aliexpress.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * @author ldj
 * @date 2024/4/13 17:25
 * @Description: ...
 * @Version 1.0
 */
@Getter
@Setter
public class AeAscpItemDetailDTO {
    //        request.addApiParameter("param0", "{\"channel_seller_id\":\"\u6E20\u9053seller id \uFF08\u53EF\u4EE5\u5728\u8FD9\u4E2AAPI\u4E2D\u67E5\u8BE2\uFF1Aglobal.seller.relation.query\uFF09\uFF0C \u8BF7\u4F7F\u7528 business_type \\u003d ONE_STOP_SERVICE \u7684\u5168\u6258\u7BA1\u5E97\u94FA channel_seller_id\",\"channel\":\"\u6E20\u9053\uFF08\u53EF\u4EE5\u5728\u8FD9\u4E2AAPI\u4E2D\u67E5\u8BE2\uFF1Aglobal.seller.relation.query\uFF09\",\"sc_item_id\":\"sc_item_id\"}");
    private String param0;
}
