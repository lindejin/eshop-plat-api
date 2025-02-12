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
 * Temu产品属性值
 * </p>
 *
 * @author sds
 * @since 2025-02-12
 */
@Getter
@Setter
@ToString
@TableName("temu_product_attr_val")
public class TemuProductAttrVal implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 商品id
     */
    private Long productId;

    /**
     * 平台属性Id
     */
    private String pid;

    /**
     * 属性id
     */
    private Long attrValId;

    /**
     * 产品属性名称
     */
    private String propName;

    /**
     * 产品属性值名称
     */
    private String attrValName;

    /**
     * 属性输入值
     */
    private String numberInputValue;
}
