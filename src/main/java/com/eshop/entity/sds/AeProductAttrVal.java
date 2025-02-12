package com.eshop.entity.sds;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * <p>
 * 商品属性值
 * </p>
 *
 * @author sds
 * @since 2025-02-12
 */
@Getter
@Setter
@ToString
@TableName("ae_product_attr_val")
public class AeProductAttrVal implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 产品id
     */
    private Long productId;

    /**
     * 属性Id
     */
    private Long attrId;

    /**
     * 属性名称
     */
    private String attrName;

    /**
     * 属性值id
     */
    private Long attrValId;

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
    private Long imgId;

    /**
     * sku自定义图片，女装类目色卡图。图片格式只允许jpg、png、jpeg这3种格式
     */
    private String skuImage;

    /**
     * 自定义属性值
     */
    private String customAttrVal;

    /**
     * 属性值单位
     */
    private String attrValueUnit;

    /**
     * 创建人
     */
    private Long createId;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 修改人
     */
    private Long updateId;

    /**
     * 修改时间
     */
    private Date updateTime;
}
