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
 * 产品属性值
 * </p>
 *
 * @author product
 * @since 2025-02-11
 */
@Getter
@Setter
@ToString
@TableName("dh_product_attr_val")
public class DhProductAttrVal implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 商品id
     */
    private Integer productId;

    /**
     * 属性Id(自定义属性，属性值id为从1向上累加也可不填;品牌属性值默认为99;与对应的类目属性值ID一致)
     */
    private Integer attrId;

    /**
     * 属性值id
     */
    private Integer attrValId;

    /**
     * 产品属性值英文名称
     */
    private String attrValName;

    /**
     * 属性值中文名称
     */
    private String attrValNameCn;

    /**
     * 产品属性图片路径
     */
    private String picUrl;

    /**
     * 文件库ID
     */
    private Integer imgId;
}
