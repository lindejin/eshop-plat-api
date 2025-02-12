package com.eshop.entity.collect;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * <p>
 * 采集sku属性信息
 * </p>
 *
 * @author collect
 * @since 2025-02-12
 */
@Getter
@Setter
@ToString
@TableName("cl_product_sku_attr")
public class ClProductSkuAttr implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 产品id
     */
    private Long productId;

    /**
     * 产品spuCode
     */
    private String spuCode;

    /**
     * 商品skuId
     */
    private Long skuId;

    /**
     * 商品sku
     */
    private String skuCode;

    /**
     * 属性类型(1.规格属性)
     */
    private Byte attrType;

    /**
     * sku属性id
     */
    private Long attrId;

    /**
     * 属性名称
     */
    private String attrName;

    /**
     * sku属性值id
     */
    private Long attrValId;

    /**
     * 属性值
     */
    private String attrValName;

    /**
     * 自定义属性值
     */
    private String customValName;
}
