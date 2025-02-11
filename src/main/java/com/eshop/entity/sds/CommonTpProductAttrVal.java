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
 * 通用库商品模板属性值
 * </p>
 *
 * @author sds
 * @since 2025-02-11
 */
@Getter
@Setter
@ToString
@TableName("common_tp_product_attr_val")
public class CommonTpProductAttrVal implements Serializable {

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
     * 属性_id
     */
    private Integer attrId;

    /**
     * 属性值
     */
    private String attrValName;

    /**
     * 属性值图片_id
     */
    private Integer fileImgId;
}
