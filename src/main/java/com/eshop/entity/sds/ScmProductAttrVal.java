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
 * 供应链商品属性值
 * </p>
 *
 * @author sds
 * @since 2025-02-12
 */
@Getter
@Setter
@ToString
@TableName("scm_product_attr_val")
public class ScmProductAttrVal implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 供应链商品_id
     */
    private Long scmProductId;

    /**
     * 属性_id
     */
    private Long attrId;

    /**
     * 属性值
     */
    private String attrValName;

    /**
     * 属性值图片_id
     */
    private Long fileImgId;

    /**
     * 色彩码值(#ffffff)
     */
    private String colorCode;
}
