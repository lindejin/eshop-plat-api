package com.eshop.entity.product;

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
 * 产品SKU列表
 * </p>
 *
 * @author product
 * @since 2025-02-11
 */
@Getter
@Setter
@ToString
@TableName("dh_product_sku")
public class DhProductSku implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 商品id
     */
    private Integer productId;

    /**
     * 产品编码
     */
    private String spuCode;

    /**
     * 产品sku编码
     */
    private String skuCode;

    /**
     * 产品备货数量
     */
    private Integer inventory;

    /**
     * sku预计收入
     */
    private BigDecimal retailPrice;

    /**
     * 是否可销售(0 不可销售，1 可销售)
     */
    private Byte saleStatus;

    /**
     * 商品sku图片
     */
    private Integer skuImgId;

    /**
     * 主库产品sku编码
     */
    private String mainSkuCode;

    /**
     * 敦煌网sku_id
     */
    private Long dhSkuId;
}
