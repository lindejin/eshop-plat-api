package com.eshop.entity.sds;

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
 * 虾皮产品SKU列表
 * </p>
 *
 * @author sds
 * @since 2025-02-12
 */
@Getter
@Setter
@ToString
@TableName("shopee_product_sku")
public class ShopeeProductSku implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 商品id
     */
    private Long productId;

    /**
     * 产品编码
     */
    private String spuCode;

    /**
     * 产品sku编码
     */
    private String skuCode;

    /**
     * 产品sku的modelId
     */
    private Long modelId;

    /**
     * 产品sku的modelId
     */
    private Long modelGlId;

    /**
     * 价格
     */
    private BigDecimal originalPrice;

    /**
     * 商品数量
     */
    private Long stock;

    /**
     * 商品货号
     */
    private String productCode;

    /**
     * 商品sku图片
     */
    private Long skuImgId;

    /**
     * 第三方商品sku图片
     */
    private String imageId;

    /**
     * 第三方商品sku_url图片
     */
    private String imageUrl;

    /**
     * 虾皮折扣活动ID
     */
    private Long discountId;

    /**
     * 价格
     */
    private BigDecimal discountPrice;
}
