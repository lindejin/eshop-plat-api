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
 * 商品sku赠品关联表
 * </p>
 *
 * @author product
 * @since 2025-02-12
 */
@Getter
@Setter
@ToString
@TableName("tb_product_sku_gift")
public class TbProductSkuGift implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键自增
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * sku编码（主商品）
     */
    private String skuCode;

    /**
     * sku编码（赠品）
     */
    private String skuCodeGift;

    /**
     * 图片id（赠品）
     */
    private Long skuImgId;

    /**
     * 商品中文名（赠品）
     */
    private String productName;

    /**
     * 商品英文名（赠品）
     */
    private String productNameEn;

    /**
     * 赠品数量（赠品）
     */
    private Long giftNum;
}
