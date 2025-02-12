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
 * 商品属性信息
 * </p>
 *
 * @author sds
 * @since 2025-02-12
 */
@Getter
@Setter
@ToString
@TableName("ae_tp_product_attr")
public class AeTpProductAttr implements Serializable {

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

    /**
     * 属性排序索引
     */
    private Byte spec;

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
