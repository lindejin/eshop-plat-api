package com.eshop.entity.collect;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.math.BigDecimal;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * <p>
 * 采集商品sku信息
 * </p>
 *
 * @author collect
 * @since 2025-02-11
 */
@Getter
@Setter
@ToString
@TableName("cl_product_sku")
public class ClProductSku implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 产品id
     */
    private Integer productId;

    /**
     * spu编码
     */
    private String spuCode;

    /**
     * 原sku
     */
    private String rawSku;

    /**
     * sku编码
     */
    private String skuCode;

    /**
     * 商品资源url
     */
    private String skuSourceUrl;

    /**
     * 图片id
     */
    private Integer imgId;

    /**
     * 成本价
     */
    private BigDecimal price;

    /**
     * 促销价
     */
    private BigDecimal promotionalPrice;

    /**
     * 库存
     */
    private Integer inventory;

    /**
     * 是否可销售(1;可销售. -1: 不可销售, 2:补货中)
     */
    private Byte skuStatus;

    /**
     * 备注
     */
    private String remark;
}
