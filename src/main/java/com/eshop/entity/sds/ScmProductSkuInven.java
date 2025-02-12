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
 * 供应链商品sku供应价格
 * </p>
 *
 * @author sds
 * @since 2025-02-12
 */
@Getter
@Setter
@ToString
@TableName("scm_product_sku_inven")
public class ScmProductSkuInven implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 供应链商品_id
     */
    private Long scmProductId;

    /**
     * sku_id
     */
    private Long scmSkuId;

    /**
     * sku编码
     */
    private String skuCode;

    /**
     * 仓库_id
     */
    private Long depotId;

    /**
     * 销售单价
     */
    private BigDecimal unitPrice;

    /**
     * 采购单价
     */
    private BigDecimal purchasePrice;

    /**
     * 运费
     */
    private BigDecimal freight;

    /**
     * 建议零售价
     */
    private BigDecimal proposePrice;

    /**
     * 商品重量(g)
     */
    private Double skuWeight;

    /**
     * 销售状态(1: 可销售, 2:不可以销售)
     */
    private Byte saleStatus;
}
