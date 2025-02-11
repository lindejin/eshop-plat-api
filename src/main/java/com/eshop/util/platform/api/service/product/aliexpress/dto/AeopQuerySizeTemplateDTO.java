package com.eshop.util.platform.api.service.product.aliexpress.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * @author ldj
 * @date 2024/3/4 17:57
 * @Description: ...
 * @Version 1.0
 */
@Getter
@Setter
public class AeopQuerySizeTemplateDTO {
    //名称	类型	是否必须	描述
    //channel_seller_id	String	否	不传默认查询对应的AE的普通账号数据，渠道seller id （可以在这个API中查询：global.seller.relation.query）， 请使用 business_type = ONE_STOP_SERVICE 的全托管店铺 channel_seller_id
    private String channel_seller_id;
    //channel	String	否	渠道（可以在这个API中查询：global.seller.relation.query）
    private String channel;
    //leaf_category_id	Number	是	叶子类目ID
    private Number leaf_category_id;
    //current_page	Number	是	当前页码,从1开始
    private Number current_page;
}
