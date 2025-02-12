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
 * 商品属性 映射平台值
 * </p>
 *
 * @author product
 * @since 2025-02-12
 */
@Getter
@Setter
@ToString
@TableName("tb_product_attr_platform_map")
public class TbProductAttrPlatformMap implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 属性Id
     */
    private Long attrId;

    /**
     * 属性名称
     */
    private String attrName;

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
}
