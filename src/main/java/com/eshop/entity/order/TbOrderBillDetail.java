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
 * 订单账单明细
 * </p>
 *
 * @author order
 * @since 2025-05-23
 */
@Getter
@Setter
@ToString
@TableName("tb_order_bill_detail")
public class TbOrderBillDetail implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 订单主表_id
     */
    private Long orderId;

    /**
     * 订单号
     */
    private String orderNo;

    /**
     * 汇率币种
     */
    private String currencyCode;

    /**
     * 订单金额
     */
    private BigDecimal orderAmount;

    /**
     * 订单结算金额
     */
    private BigDecimal settlementAmount;

    /**
     * 买方付款金额
     */
    private BigDecimal buyerPayment;

    /**
     * 商品总售价
     */
    private BigDecimal productTotalPrice;

    /**
     * 运费小计(可能存在负数)
     */
    private BigDecimal shippingSubtotal;

    /**
     * 平台总费用
     */
    private BigDecimal platformTotalFees;

    /**
     * 退款金额
     */
    private BigDecimal refundMoney;

    /**
     * 原始币种转换为CNY的执行汇率
     */
    private BigDecimal fxRateCny;

    /**
     * 商品总成本(固定CNY)
     */
    private BigDecimal productTotalCost;

    /**
     * 线下物流运费(固定CNY)
     */
    private BigDecimal shippingCost;

    /**
     * 仓库服务费(固定CNY)
     */
    private BigDecimal depotServiceCost;

    /**
     * 毛利
     */
    private BigDecimal grossProfit;

    /**
     * 付款时间
     */
    private Date paymentTime;

    /**
     * 结算时间
     */
    private Date settlementTime;

    /**
     * 自定义费用(JSON字符串)
     */
    private String customExpenses;
}
