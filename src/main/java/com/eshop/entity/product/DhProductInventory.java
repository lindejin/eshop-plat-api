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
 * 产品备货信息
 * </p>
 *
 * @author product
 * @since 2025-02-12
 */
@Getter
@Setter
@ToString
@TableName("dh_product_inventory")
public class DhProductInventory implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 商品id
     */
    private Long productId;

    /**
     * 产品备货地(示例值：CN)
     */
    private String inventoryLocation;

    /**
     * 产品备货数量(备货状态为有备货时必填，设置该值时，与产品中可销售的SKU之和一致)
     */
    private Long inventoryQty;

    /**
     * 扣减库存类型(备货状态为有备货时必填。1-下单扣减库存；2-支付完成扣减库存，默认是1。示例值：1)
     */
    private Byte subtractStockType;
}
