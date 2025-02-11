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
 * 商品属性值
 * </p>
 *
 * @author product
 * @since 2025-02-11
 */
@Getter
@Setter
@ToString
@TableName("tb_product_attr_val")
public class TbProductAttrVal implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 产品编码
     */
    private String spuCode;

    /**
     * 属性Id
     */
    private Integer attrId;

    /**
     * 属性值名称
     */
    private String attrName;

    /**
     * 属性值id
     */
    private Integer attrValId;

    /**
     * 属性值名称
     */
    private String attrValName;

    /**
     * 属性值中文名称
     */
    private String attrValNameCn;

    /**
     * 属性值图片_id
     */
    private Integer imgId;

    /**
     * 自定义属性值
     */
    private String customAttrVal;
}
