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
 * 类目属性值	
 * </p>
 *
 * @author product
 * @since 2025-02-11
 */
@Getter
@Setter
@ToString
@TableName("dh_category_attr_val")
public class DhCategoryAttrVal implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 属性Id(自定义属性，属性值id为从1向上累加也可不填;品牌属性值默认为99;与对应的类目属性值ID一致)
     */
    private Integer attrId;

    /**
     * 产品线属性值编号
     */
    private Integer attrValId;

    /**
     * 发布类目属性编号
     */
    private Integer catePubAttrId;

    /**
     * 属性值主键
     */
    private Integer catePubAttrValId;

    /**
     * 属性值英文
     */
    private String attrValName;

    /**
     * 属性值中文
     */
    private String attrValNameCn;

    /**
     * 是否选中(1:选中,2:未选中)
     */
    private Byte checked;
}
