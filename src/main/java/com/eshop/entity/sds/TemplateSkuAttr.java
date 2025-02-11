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
 * @since 2025-02-11
 */
@Getter
@Setter
@ToString
@TableName("template_sku_attr")
public class TemplateSkuAttr implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 商品skuId
     */
    private Integer skuId;

    /**
     * 产品sku编码
     */
    private String skuCode;

    /**
     * sku变种属性id
     */
    private Integer attrId;

    /**
     * sku变种属性值id
     */
    private Integer attrValueId;
}
