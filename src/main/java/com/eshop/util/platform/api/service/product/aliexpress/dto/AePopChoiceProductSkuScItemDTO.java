package com.eshop.util.platform.api.service.product.aliexpress.dto;

import lombok.Data;

/**
 * @author rch
 * @date 2024/4/17 16:28
 * @Description: 货品信息
 * @Version 1.0
 */
@Data
public class AePopChoiceProductSkuScItemDTO {
    // 货品编辑
    private String sc_item_code;

    // 内电：274526 弱磁：274452 粉末：274511 液体：274259 膏体：274363
    private String[] special_product_type_list;

    // 货品条码
    private String sc_item_bar_code;

    // 是否原箱， "1"：是 ； "0"：否
    private String original_box;
}
