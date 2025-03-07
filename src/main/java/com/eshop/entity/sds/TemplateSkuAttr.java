package com.eshop.entity.sds;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * <p>
 * 模版产品-规格变种属性列表
 * </p>
 *
 * @author sds
 * @since 2025-03-07
 */
@Getter
@Setter
@ToString
@TableName("template_sku_attr")
public class TemplateSkuAttr implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 商品skuId
     */
    private Long skuId;

    /**
     * 产品sku编码
     */
    private String skuCode;

    /**
     * sku变种属性id
     */
    private Long attrId;

    /**
     * sku变种属性值id
     */
    private Long attrValueId;
}
