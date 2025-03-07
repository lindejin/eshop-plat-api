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
 * TK产品SKU仓库库存信息
 * </p>
 *
 * @author sds
 * @since 2025-03-07
 */
@Getter
@Setter
@ToString
@TableName("tk_product_sku_stock")
public class TkProductSkuStock implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 商品id
     */
    private Long productId;

    /**
     * 产品sku_id
     */
    private Long skuId;

    /**
     * 仓库id
     */
    private String warehouseId;

    /**
     * 可用库存
     */
    private Long availableStock;
}
