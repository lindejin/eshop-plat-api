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
 * 模板产品规格变种属性值列表
 * </p>
 *
 * @author sds
 * @since 2025-03-07
 */
@Getter
@Setter
@ToString
@TableName("template_specs_attr_val")
public class TemplateSpecsAttrVal implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 规格属性id
     */
    private Long attrId;

    /**
     * 层级(最多两层)
     */
    private Byte level;

    /**
     * 产品属性值名称
     */
    private String attrValueName;

    /**
     * 索引(从0开始)
     */
    private Byte indexVal;
}
