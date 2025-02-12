package com.eshop.entity.product;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * <p>
 * 产品SKU属性值列表
 * </p>
 *
 * @author product
 * @since 2025-02-12
 */
@Getter
@Setter
@ToString
@TableName("dh_sku_attr")
public class DhSkuAttr implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 商品sku_id
     */
    private Long skuId;

    /**
     * 规格类型(1 产品规格,3自定义规格,4备货地规格)
     */
    private Byte sizeSpecType;

    /**
     * sku属性id
     */
    private Long attrId;

    /**
     * sku属性值id
     */
    private Long attrValId;
}
