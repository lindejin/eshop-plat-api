package com.eshop.entity.order;

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
 * 订单发票
 * </p>
 *
 * @author order
 * @since 2025-02-12
 */
@Getter
@Setter
@ToString
@TableName("tb_order_invoice")
public class TbOrderInvoice implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 订单号
     */
    private String orderNo;

    /**
     * 发票编号
     */
    private String invoiceCode;

    /**
     * 交易号
     */
    private String transactionNo;

    /**
     * 开票时间
     */
    private Date invoiceTime;

    /**
     * 商品数量
     */
    private Long productAmount;

    /**
     * 商品金额
     */
    private BigDecimal productSum;

    /**
     * 运费
     */
    private BigDecimal freight;

    /**
     * 应付金额
     */
    private BigDecimal copeSum;
}
