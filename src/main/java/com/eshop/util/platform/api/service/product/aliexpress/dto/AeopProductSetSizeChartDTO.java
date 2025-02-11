package com.eshop.util.platform.api.service.product.aliexpress.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * @author ldj
 * @date 2024/3/2 17:31
 * @Description: 修改商品所引用的尺码模板
 * @Version 1.0
 */
@Getter
@Setter
public class AeopProductSetSizeChartDTO {
    //名称	类型	是否必须	描述
    //channel_seller_id	String	否	不传默认查询对应的AE的普通账号数据，渠道seller id （可以在这个API中查询：global.seller.relation.query）， 请使用 business_type = ONE_STOP_SERVICE 的全托管店铺 channel_seller_id
    private String channel_seller_id;
    //channel	String	否	渠道（可以在这个API中查询：global.seller.relation.query）
    private String channel;
    //product_id	Number	否	商品Id
    private Number product_id;
    //sizechart_id	Number	否	尺码表模版Id, 必须与当前商品所在类目想对应。
    private Number sizechart_id;
}
