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
 * 速卖通产品sku分国家的日常促销价
 * </p>
 *
 * @author sds
 * @since 2025-02-12
 */
@Getter
@Setter
@ToString
@TableName("ae_product_sku_tutelage_price")
public class AeProductSkuTutelagePrice implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 自增id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 产品id
     */
    private Long productId;

    /**
     * 产品sku主键id
     */
    private Long skuId;

    /**
     * 产品skuCode
     */
    private String skuCode;

    /**
     * 货品条码
     */
    private String productBarcode;

    /**
     * 商品价格(不含预估物流服务费)
     */
    private BigDecimal price;

    /**
     * 半托管-JIT库存
     */
    private Long halfTubeInventory;

    /**
     * 仓库编码
     */
    private String warehouseCode;

    /**
     * 		SKU货品id
     */
    private Long scItemId;

    /**
     * SKU货品编码
     */
    private String scItemCode;

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
