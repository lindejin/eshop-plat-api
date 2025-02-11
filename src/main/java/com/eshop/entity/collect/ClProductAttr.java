package com.eshop.entity.collect;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * <p>
 * 采集商品属性信息
 * </p>
 *
 * @author collect
 * @since 2025-02-11
 */
@Getter
@Setter
@ToString
@TableName("cl_product_attr")
public class ClProductAttr implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 产品id
     */
    private Integer productId;

    /**
     * 产品编码
     */
    private String spuCode;

    /**
     * 属性Id
     */
    private Integer attrId;

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
