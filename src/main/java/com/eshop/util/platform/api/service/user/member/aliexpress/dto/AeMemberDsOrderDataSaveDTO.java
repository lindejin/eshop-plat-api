package com.eshop.util.platform.api.service.user.member.aliexpress.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * @author ldj
 * @date 2024/2/29 15:25
 * @Description: ...
 * @Version 1.0
 */
@Getter
@Setter
public class AeMemberDsOrderDataSaveDTO{
    //request.addApiParameter("dser_collect_data", "{\"ae_product_id\":\"1334345\",\"ae_sku_info\":\"200000182:193;200007763:201336100\",\"product_url\":\"https://www.yousite.com/item/32862631421.html\",\"order_amount\":\"35.33\",\"paytime\":\"20191122:150606\",\"ae_orderid\":\"1334345\",\"product_amount\":\"35.33\"}");
    private String dser_collect_data;
}
