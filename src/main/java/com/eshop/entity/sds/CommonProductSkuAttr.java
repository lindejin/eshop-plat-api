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
 * 通用库商品sku属性
 * </p>
 *
 * @author sds
 * @since 2025-02-12
 */
@Getter
@Setter
@ToString
@TableName("common_product_sku_attr")
public class CommonProductSkuAttr implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 主表_id
     */
    private Long productId;

    /**
     * sku_id
     */
    private Long skuId;

    /**
     * 属性_id
     */
    private Long attrId;

    /**
     * 属性名称
     */
    private String attrName;

    /**
     * 属性值_id
     */
    private Long attrValId;

    /**
     * 属性值_名称
     */
    private String attrValName;
}
