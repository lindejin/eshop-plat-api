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
 * 有备货时，每个备货地独立价格信息
 * </p>
 *
 * @author product
 * @since 2025-02-12
 */
@Getter
@Setter
@ToString
@TableName("dh_sku_location_price")
public class DhSkuLocationPrice implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 商品sku_id
     */
    private Long skuId;

    /**
     * 产品sku零售价
     */
    private BigDecimal retailPrice;

    /**
     * 产品备货地址编码(必须在itemSkuList[].itemSkuInvenList[].inventoryLocation中。示例值：CN)
     */
    private String inventoryLocation;
}
