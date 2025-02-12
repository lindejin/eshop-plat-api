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
@TableName("temu_tp_product_attr_val")
public class TemuTpProductAttrVal implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 商品id
     */
    private Long productId;

    /**
     * 第三方属性Id
     */
    private String pid;

    /**
     * 属性值id(平台属性值Id)
     */
    private Long attrValId;

    /**
     * 产品属性值名称
     */
    private String attrValName;

    /**
     * 自定义值
     */
    private String numberInputValue;
}
