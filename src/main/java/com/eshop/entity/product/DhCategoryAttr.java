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
 * 类目属性
 * </p>
 *
 * @author product
 * @since 2025-02-12
 */
@Getter
@Setter
@ToString
@TableName("dh_category_attr")
public class DhCategoryAttr implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 类目id
     */
    private Long categoryId;

    /**
     * 属性Id(自定义属性，属性值id为从1向上累加也可不填;品牌属性值默认为99;与对应的类目属性值ID一致)
     */
    private Long attrId;

    /**
     * 子属性id
     */
    private Long childAttrId;

    /**
     * 发布类目属性编号
     */
    private Long catePubAttrId;

    /**
     * 产品属性英文名称
     */
    private String attrName;

    /**
     * 产品属性中文名称
     */
    private String attrNameCn;

    /**
     * 类目选择形式(1：多选框 2：下拉框 4：字符型输入框 5：数值型输入框)
     */
    private Byte type;

    /**
     * 类目选择样式(类目相关参数的选择样式 ；1：文本 2：图片 3：图文)
     */
    private Byte style;

    /**
     * 是否为必填(1：必填项， 0：非必填项)
     */
    private Byte isRequired;

    /**
     * 是否是品牌属性(1: 是, 0: 否)
     */
    private Byte isBrand;

    /**
     * 是否销售属性(1: 是, 0: 否)
     */
    private Byte isSaleAttr;

    /**
     * 是否购买属性(1: 是, 0: 否)
     */
    private Byte isBuyAttr;

    /**
     * 属性的属性值是否可以自定义修改(1：是 0：否 ，只对多选、单选有效;)
     */
    private Byte isDefined;

    /**
     * 是否定位属性(1：定位属性，0：非定位属性)
     */
    private Byte isLocated;

    /**
     * 是否有other属性值
     */
    private String isOther;
}
