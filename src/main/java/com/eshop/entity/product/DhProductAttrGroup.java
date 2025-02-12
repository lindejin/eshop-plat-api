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
 * 兼容属性列表
 * </p>
 *
 * @author product
 * @since 2025-02-12
 */
@Getter
@Setter
@ToString
@TableName("dh_product_attr_group")
public class DhProductAttrGroup implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 商品id
     */
    private Long productId;

    /**
     * 属性Id
     */
    private Long attrId;

    /**
     * 兼容性属性值中文名称
     */
    private String lineAttrvalNameCn;

    /**
     * 属性值id
     */
    private Long attrValId;

    /**
     * 兼容性属性值英文名称
     */
    private String lineAttrvalName;

    /**
     * 兼容性属性中文名称
     */
    private String attrNameCn;

    /**
     * 兼容性属性英文名称
     */
    private String attrName;
}
