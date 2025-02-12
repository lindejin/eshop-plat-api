package com.eshop.entity.order;

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
 * 订单费用明细 (存储原始货币,根据货币类型与日期计算CNY)
 * </p>
 *
 * @author order
 * @since 2025-02-12
 */
@Getter
@Setter
@ToString
@TableName("tb_order_cost_detail")
public class TbOrderCostDetail implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 订单号
     */
    private String orderNo;

    /**
     * 货币类型
     */
    private String currency;

    /**
     * 买家付款方式
     */
    private String paymentMethod;

    /**
     * 商品总售价
     */
    private BigDecimal productTotalPrice;

    /**
     * 应收运费
     */
    private BigDecimal receivablePostage;

    /**
     * 其他收入
     */
    private BigDecimal otherRevenue;

    /**
     * 商品成本价
     */
    private BigDecimal productCostPrice;

    /**
     * 物流支出
     */
    private BigDecimal logisticsCosts;

    /**
     * 预估物流运费
     */
    private BigDecimal estimateFreight;

    /**
     * 包材费
     */
    private BigDecimal packingFee;

    /**
     * 平台服务费
     */
    private BigDecimal serviceFee;

    /**
     * 平台佣金费
     */
    private BigDecimal platformCost;

    /**
     * 转账费用
     */
    private BigDecimal transferCost;

    /**
     * 广告费用
     */
    private BigDecimal advertisingRate;

    /**
     * 平台优惠卷
     */
    private BigDecimal platformCoupon;

    /**
     * 店铺优惠劵
     */
    private BigDecimal shopCoupon;

    /**
     * 推广费/测评费(刷单费)
     */
    private BigDecimal promotionExpenses;

    /**
     * 其他支出
     */
    private BigDecimal otherExpenses;

    /**
     * 买方付款金额
     */
    private BigDecimal buyerPaymentAmount;

    /**
     * 退款金额
     */
    private BigDecimal refundMoney;

    /**
     * 增补费用
     */
    private BigDecimal supplementCost;

    /**
     * 订单平台收入
     */
    private BigDecimal orderPlatformRevenue;
}
