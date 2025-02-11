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
 * 产品属性列表
 * </p>
 *
 * @author sds
 * @since 2025-02-11
 */
@Getter
@Setter
@ToString
@TableName("dh_tp_product_attr")
public class DhTpProductAttr implements Serializable {

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
     * 产品属性英文名称
     */
    private String attrName;

    /**
     * 产品属性中文名称
     */
    private String attrNameCn;

    /**
     * 是否是品牌属性(1:是,0:否；示例值：1)
     */
    private Byte isBrand;

    /**
     * 产品品牌id(产品品牌id,从品牌列表中获得。所选品牌需要对卖和产品类目有效能用)
     */
    private String brandId;
}
