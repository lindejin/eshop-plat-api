package com.eshop.entity.order;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * <p>
 * 
 * </p>
 *
 * @author order
 * @since 2025-02-11
 */
@Getter
@Setter
@ToString
@TableName("tb_order_cost_shopee")
public class TbOrderCostShopee implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 订单号
     */
    private String orderNo;

    /**
     * 商户_id
     */
    private Integer merchantId;

    /**
     * 平台id
     */
    private Integer platformId;

    /**
     * 店铺id
     */
    private Integer shopId;

    /**
     * 用于错误跟踪的 API 请求的标识符
     */
    private String requestId;

    /**
     * 货币类型
     */
    private String currency;

    /**
     * 汇率(从主要商店货币到联盟商店货币的汇率。)
     */
    private BigDecimal exchangeRate;

    /**
     * 订单收入
     */
    private BigDecimal escrowAmount;

    /**
     * 调整后订单收入
     */
    private BigDecimal escrowAmountAfterAdjustment;

    /**
     * 商品金额
     */
    private BigDecimal costOfGoodsSold;

    /**
     * 原始商品成本
     */
    private BigDecimal originalCostOfGoodsSold;

    /**
     * 原始Shopee折扣
     */
    private BigDecimal originalShopeeDiscount;

    /**
     * 退款金额
     */
    private BigDecimal sellerReturnRefund;

    /**
     * 每件商品的最终总和，特定订单的 Shopee 折扣
     */
    private BigDecimal shopeeDiscount;

    /**
     * 卖家代金券 卖方为订单提供的代金券的最终价值。
     */
    private BigDecimal voucherFromSeller;

    /**
     * 卖家金币返现
     */
    private BigDecimal sellerCoinCashBack;

    /**
     * 买家支付运费
     */
    private BigDecimal buyerPaidShippingFee;

    /**
     * 实际运费（物流业者收取的运费）
     */
    private BigDecimal actualShippingFee;

    /**
     * shopee运费折扣
     */
    private BigDecimal shopeeShippingRebate;

    /**
     * 第三方物流运费折扣 3PF
     */
    private BigDecimal shippingFeeDiscountFrom3pl;

    /**
     * 逆向运费
     */
    private BigDecimal reverseShippingFee;

    /**
     * RSF卖家保护费索赔金额(通过运费险节约下来的运费总额)
     */
    private BigDecimal rsfSellerProtectionFeeClaimAmount;

    /**
     * 最终退还给卖家的运费
     */
    private BigDecimal finalReturnToSellerShippingFee;

    /**
     * 卖家交易费
     */
    private BigDecimal sellerTransactionFee;

    /**
     * 服务费
     */
    private BigDecimal serviceFee;

    /**
     * 佣金
     */
    private BigDecimal commissionFee;

    /**
     * 活动费
     */
    private BigDecimal campaignFee;

    /**
     * 运费险计划活动服务费（运费卖家保护费金额）
     */
    private BigDecimal shippingSellerProtectionFeeAmount;

    /**
     * 交付卖家保护费保费金额
     */
    private BigDecimal deliverySellerProtectionFeePremiumAmount;

    /**
     * 最终托管产品GST
     */
    private BigDecimal finalEscrowProductGst;

    /**
     * 订单AMS佣金费
     */
    private BigDecimal orderAmsCommissionFee;

    /**
     * 托管税 印尼政府对卖家征收的跨境税。
     */
    private BigDecimal escrowTax;

    /**
     * 销售税(马来西亚)
     */
    private BigDecimal salesTaxOnLvg;

    /**
     * 逆向运费税
     */
    private BigDecimal reverseShippingFeeSst;

    /**
     * 运费税
     */
    private BigDecimal shippingFeeSst;

    /**
     * 代扣税(菲律宾）
     */
    private BigDecimal withholdingTax;

    /**
     * 海外退货服务费
     */
    private BigDecimal overseasReturnServiceFee;

    /**
     * 进口货物增值税(泰国)
     */
    private BigDecimal vatOnImportedGoods;

    /**
     * 买家交易费
     */
    private BigDecimal buyerTransactionFee;

    /**
     * 总交易费用 此值表示总交易费用。credit_card_transaction_fee=buyer_transaction_fee+seller_transaction_fee
     */
    private BigDecimal creditCardTransactionFee;

    /**
     * Shopee代金券 Shopee为订单提供的代金券的最终价值。
     */
    private BigDecimal voucherFromShopee;

    /**
     * 所有买家账款  买家在结账时支付的总金额的快照值
     */
    private BigDecimal buyerTotalAmount;

    /**
     * 可调整退款 来自 Shopee 争议解决中心的可调整退款金额。退货退款金额 = 如果可调整 RR，则等于 drc_adjustable_refund
     */
    private BigDecimal drcAdjustableRefund;

    /**
     * 返回json
     */
    private String responseBody;

    /**
     * 创建人
     */
    private Integer createId;

    /**
     * 创建人
     */
    private Integer updateId;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 修改时间
     */
    private LocalDateTime updateTime;

    /**
     * 是否更新 1是 2否
     */
    private Byte isUpdate;

    /**
     * 是否结束 1是 2否
     */
    private Byte isEnd;
}
