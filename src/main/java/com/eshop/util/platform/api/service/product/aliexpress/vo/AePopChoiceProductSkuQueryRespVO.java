package com.eshop.util.platform.api.service.product.aliexpress.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author rch
 * @date 2024/4/2 11:22
 * @Description: 半托管商品新发第二段提交
 * @Version 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AePopChoiceProductSkuQueryRespVO {
    // SkuId，平台生成的唯一性随机数
    private String skuId;

    // Sku商家编码。 格式:半角英数字,长度20,不包含空格大于号和小于号。如果用户只填写零售价（productprice）和商品编码，需要完整生成一条SKU记录提交，否则商品编码无法保存。系统会认为只提交了零售价，而没有SKU，导致商品编辑未保存。
    private String skuCode;

    // SKU货品信息
    private AePopChoiceProductSkuScItemInfoRespVO aePopChoiceProductSkuScItemInfoRespVO;

    // TODO 还有好些 暂时用不到先不写
}
