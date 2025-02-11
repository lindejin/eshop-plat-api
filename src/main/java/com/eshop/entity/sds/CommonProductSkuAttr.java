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
 * @since 2025-02-11
 */
@Getter
@Setter
@ToString
@TableName("common_product_sku_attr")
public class CommonProductSkuAttr implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 主表_id
     */
    private Integer productId;

    /**
     * sku_id
     */
    private Integer skuId;

    /**
     * 属性_id
     */
    private Integer attrId;

    /**
     * 属性名称
     */
    private String attrName;

    /**
     * 属性值_id
     */
    private Integer attrValId;

    /**
     * 属性值_名称
     */
    private String attrValName;
}
