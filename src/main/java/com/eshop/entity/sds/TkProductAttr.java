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
 * TK产品属性列表
 * </p>
 *
 * @author sds
 * @since 2025-02-12
 */
@Getter
@Setter
@ToString
@TableName("tk_product_attr")
public class TkProductAttr implements Serializable {

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
     * 产品属性名称
     */
    private String attrName;

    /**
     * 属性类型：2.销售属性 3.产品属性
     */
    private Byte type;
}
