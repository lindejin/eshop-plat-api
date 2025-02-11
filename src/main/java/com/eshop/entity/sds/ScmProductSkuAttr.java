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
 * 供应链商品sku属性
 * </p>
 *
 * @author sds
 * @since 2025-02-11
 */
@Getter
@Setter
@ToString
@TableName("scm_product_sku_attr")
public class ScmProductSkuAttr implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 供应链商品_id
     */
    private Integer scmProductId;

    /**
     * sku_id
     */
    private Integer scmSkuId;

    /**
     * 属性_id
     */
    private Integer scmAttrId;

    /**
     * 属性名称
     */
    private String scmAttrName;

    /**
     * 属性值_id
     */
    private Integer scmAttrValId;

    /**
     * 属性值
     */
    private String scmAttrValName;
}
