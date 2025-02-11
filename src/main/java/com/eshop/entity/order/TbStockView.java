package com.eshop.entity.order;

import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.math.BigDecimal;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * <p>
 * VIEW
 * </p>
 *
 * @author order
 * @since 2025-02-11
 */
@Getter
@Setter
@ToString
@TableName("tb_stock_view")
public class TbStockView implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;

    /**
     * 仓库id
     */
    private Integer depotId;

    /**
     * 仓位编码
     */
    private String positionCode;

    /**
     * 库存sku编号
     */
    private String productSku;

    /**
     * 商品名称
     */
    private String productName;

    /**
     * 库存数量
     */
    private Integer inventoryQuantity;

    /**
     * 缺货数量
     */
    private Integer stockoutQuantity;

    /**
     * 采购中数量
     */
    private Integer purchaseQuantity;

    /**
     * 待处理数量
     */
    private Integer pendingQuantity;

    /**
     * 冻结数量
     */
    private Integer freezeQuantity;

    /**
     * 最低采购单价
     */
    private BigDecimal minUnitPrice;

    /**
     * 成本价
     */
    private BigDecimal costPrice;

    /**
     * 备注
     */
    private String remark;
}
