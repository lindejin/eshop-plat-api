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
 * 退货单明细
 * </p>
 *
 * @author supply
 * @since 2025-03-07
 */
@Getter
@Setter
@ToString
@TableName("tb_refund_detail")
public class TbRefundDetail implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 退货单号
     */
    private Long refundNo;

    /**
     * 采购单编号
     */
    private Long purchasesNo;

    /**
     * sku编号
     */
    private String productSku;

    /**
     * 商品名称
     */
    private String productName;

    /**
     * 商品单价
     */
    private BigDecimal purchasePrice;

    /**
     * 退货数量
     */
    private Long refundAmount;

    /**
     * 小计(单价 * 数量)
     */
    private BigDecimal subtotal;

    /**
     * 备注
     */
    private String remark;
}
