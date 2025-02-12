package com.eshop.entity.depot;

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
 * 库存
 * </p>
 *
 * @author depot
 * @since 2025-02-12
 */
@Getter
@Setter
@ToString
@TableName("tb_stock")
public class TbStock implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 仓库id
     */
    private Long depotId;

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
    private Long inventoryQuantity;

    /**
     * 缺货数量
     */
    private Long stockoutQuantity;

    /**
     * 采购中数量
     */
    private Long purchaseQuantity;

    /**
     * 待处理数量
     */
    private Long pendingQuantity;

    /**
     * 冻结数量
     */
    private Long freezeQuantity;

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

    /**
     * 产品类型(1:默认,2:素材,3:供应链,4:成品)
     */
    private Byte productType;
}
