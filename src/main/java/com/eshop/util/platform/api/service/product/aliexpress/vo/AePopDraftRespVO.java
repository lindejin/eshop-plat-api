package com.eshop.util.platform.api.service.product.aliexpress.vo;

import lombok.Getter;
import lombok.Setter;

/**
 * @author rch
 * @date 2024/4/2 11:22
 * @Description: 托管商品新发一阶段pop信息草稿保存接口
 * @Version 1.0
 */
@Getter
@Setter
public class AePopDraftRespVO {
    private String respBody;
    //product_id	Number	新商品的ID
    private Long draft_id;
}
