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
 * TK产品属性值
 * </p>
 *
 * @author sds
 * @since 2025-03-07
 */
@Getter
@Setter
@ToString
@TableName("tk_product_attr_val")
public class TkProductAttrVal implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 商品id
     */
    private Long productId;

    /**
     * 产品编码
     */
    private String spuCode;

    /**
     * 属性Id(自定义属性，属性值id为从1向上累加也可不填;品牌属性值默认为99;与对应的类目属性值ID一致)
     */
    private Long attrId;

    /**
     * 属性值id
     */
    private Long attrValId;

    /**
     * 产品属性值名称
     */
    private String attrValName;

    /**
     * 属性值图片_id
     */
    private Long fileImgId;
}
