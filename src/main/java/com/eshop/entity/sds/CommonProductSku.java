package com.eshop.entity.sds;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * <p>
 * 通用库商品sku
 * </p>
 *
 * @author sds
 * @since 2025-02-12
 */
@Getter
@Setter
@ToString
@TableName("common_product_sku")
public class CommonProductSku implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 主表_id
     */
    private Long productId;

    /**
     * sku_编码
     */
    private String skuCode;

    /**
     * 属性值图片_id
     */
    private Long fileImgId;

    /**
     * 销售单价($)
     */
    private BigDecimal unitPrice;

    /**
     * 商品重量(g)
     */
    private BigDecimal skuWeight;

    /**
     * 销售状态(1: 可销售, 2:不可以销售)
     */
    private Byte saleStatus;

    /**
     * 创建人
     */
    private Long createId;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 修改人
     */
    private Long updateId;

    /**
     * 修改时间
     */
    private Date updateTime;
}
