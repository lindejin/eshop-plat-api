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
 * 通用库商品模板属性
 * </p>
 *
 * @author sds
 * @since 2025-02-11
 */
@Getter
@Setter
@ToString
@TableName("common_tp_product_attr")
public class CommonTpProductAttr implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 模版id
     */
    private Integer templateId;

    /**
     * 主表_id
     */
    private Integer productId;

    /**
     * 属性名称
     */
    private String attrName;

    /**
     * 属性类型(1:常规属性)ps: 模板属性只需要常规属性
     */
    private Byte attrType;
}
