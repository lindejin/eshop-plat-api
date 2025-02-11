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
 * 自定义规格列表
 * </p>
 *
 * @author product
 * @since 2025-02-11
 */
@Getter
@Setter
@ToString
@TableName("dh_product_spec_selfdef")
public class DhProductSpecSelfdef implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 商品id
     */
    private Integer productId;

    /**
     * 自定义规格属性值id
     */
    private Integer attrValId;

    /**
     * 自定义规格名称(自定义规格名称不允许重复；示例值：size)
     */
    private String attrValName;

    /**
     * 自定义规格图片
     */
    private String picUrl;
}
