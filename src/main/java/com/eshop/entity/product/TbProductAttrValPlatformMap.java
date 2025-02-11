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
 * 商品属性值 映射平台值
 * </p>
 *
 * @author product
 * @since 2025-02-11
 */
@Getter
@Setter
@ToString
@TableName("tb_product_attr_val_platform_map")
public class TbProductAttrValPlatformMap implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 属性Id
     */
    private Integer attrId;

    /**
     * 属性名称
     */
    private String attrName;

    /**
     * 属性值id
     */
    private Integer attrValId;

    /**
     * 属性值名称(存属性值名称,不是自定义值)
     */
    private String attrValName;

    /**
     * 平台编码
     */
    private String platformCode;

    /**
     * 平台属性Id
     */
    private String platformAttrId;

    /**
     * 平台属性名称
     */
    private String platformAttrName;

    /**
     * 平台属性值Id
     */
    private String platformAttrValId;

    /**
     * 平台属性值名称
     */
    private String platformAttrValName;
}
