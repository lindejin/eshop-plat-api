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
 * 商品属性信息
 * </p>
 *
 * @author product
 * @since 2025-03-07
 */
@Getter
@Setter
@ToString
@TableName("tb_product_attr")
public class TbProductAttr implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 产品编码
     */
    private String spuCode;

    /**
     * 属性Id
     */
    private Long attrId;

    /**
     * 产品属性名称 (英文)
     */
    private String attrName;

    /**
     * 是否购买属性(1: 是, 2: 否)
     */
    private Byte isBuyAttr;

    /**
     * 属性值是否存在图片(1: 是, 2:否)
     */
    private Byte isContainImg;
}
