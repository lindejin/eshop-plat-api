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
 * 模板产品规格变种属性值列表
 * </p>
 *
 * @author sds
 * @since 2025-02-11
 */
@Getter
@Setter
@ToString
@TableName("shopee_product_specs_attr_val")
public class ShopeeProductSpecsAttrVal implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 商品id
     */
    private Integer productId;

    /**
     * 产品编码
     */
    private String spuCode;

    /**
     * 规格属性id
     */
    private Integer attrId;

    /**
     * 层级(最多两层)
     */
    private Byte level;

    /**
     * 产品属性值名称
     */
    private String attrValueName;

    /**
     * 索引(从0开始)
     */
    private Byte indexVal;

    /**
     * 属性图片
     */
    private Integer imgId;
}
