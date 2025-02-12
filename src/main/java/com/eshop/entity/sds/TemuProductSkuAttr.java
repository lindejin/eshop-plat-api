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
 * Temu产品模版属性值
 * </p>
 *
 * @author sds
 * @since 2025-02-12
 */
@Getter
@Setter
@ToString
@TableName("temu_product_sku_attr")
public class TemuProductSkuAttr implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 商品id
     */
    private Long productId;

    /**
     * skuId
     */
    private Long productSkuId;

    /**
     * 基础属性id
     */
    private Long pid;

    /**
     * 产品属性名称
     */
    private String propName;

    /**
     * 属性值id
     */
    private Long valId;

    /**
     * 产品属性值名称
     */
    private String value;
}
