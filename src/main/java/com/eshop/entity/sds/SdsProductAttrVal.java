package com.eshop.entity.sds;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * <p>
 * sds-产品属性值
 * </p>
 *
 * @author sds
 * @since 2025-03-07
 */
@Getter
@Setter
@ToString
@TableName("sds_product_attr_val")
public class SdsProductAttrVal implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 产品Id
     */
    private Long productId;

    /**
     * 产品编码
     */
    private String spuCode;

    /**
     * 属性Id
     */
    private Long attrId;

    /**
     * 属性值名称
     */
    private String attrName;

    /**
     * 属性值id
     */
    private Long attrValId;

    /**
     * 属性值名称
     */
    private String attrValName;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 修改时间
     */
    private Date updateTime;
}
