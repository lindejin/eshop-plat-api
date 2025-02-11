package com.eshop.entity.supply;

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
 * 采购单明细
 * </p>
 *
 * @author supply
 * @since 2025-02-11
 */
@Getter
@Setter
@ToString
@TableName("tb_purchases_detail")
public class TbPurchasesDetail implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 采购单号
     */
    private Long purchaseNo;

    /**
     * 缺货批次_id
     */
    private Integer stockoutId;

    /**
     * sku编号
     */
    private String productSku;

    /**
     * 运单号
     */
    private String waybillNo;

    /**
     * 商品名称
     */
    private String productName;

    /**
     * 采购数量
     */
    private Integer purchaseAmount;

    /**
     * 入库数量
     */
    private Integer storageAmount;

    /**
     * 已退数量
     */
    private Integer refundAmount;

    /**
     * 损耗量
     */
    private Integer lossAmount;

    /**
     * 采购单价
     */
    private BigDecimal purchasePrice;

    /**
     * 单个商品成本价
     */
    private BigDecimal costPrice;

    /**
     * 折扣(PS:0.7 = 七折 = 70%)
     */
    private Double discount;

    /**
     * 小计((折扣*单价) * 数量)
     */
    private BigDecimal subtotal;

    /**
     * 商品收货状态(1:未收货,2:全部收货,3:部分收货)
     */
    private Byte productStatus;

    /**
     * 备注
     */
    private String remark;
}
