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
 * TK订单费用明细
 * </p>
 *
 * @author order
 * @since 2025-02-11
 */
@Getter
@Setter
@ToString
@TableName("tk_order_cost_detail")
public class TkOrderCostDetail implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 订单号
     */
    private String orderNo;

    /**
     * 货币类型
     */
    private String currency;

    /**
     * 结算记录Id
     */
    private String statementId;

    /**
     * 同步状态(1:已成功,2:未同步,3:店铺异常,4:暂不同步)
     */
    private Byte syncStatus;

    /**
     * 请求Id
     */
    private String requestId;

    /**
     * 结算时间
     */
    private LocalDateTime statementTime;

    /**
     * 总结算金额
     */
    private BigDecimal settlementAmount;

    /**
     * 总收入
     */
    private BigDecimal revenueAmount;

    /**
     * 卖家折扣后小计
     */
    private BigDecimal afterSellerDiscountsSubtotalAmount;

    /**
     * 折扣前小计(商品总价)
     */
    private BigDecimal productTotalPrice;

    /**
     * 平台折扣
     */
    private BigDecimal platformDiscountAmount;

    /**
     * 总费用
     */
    private BigDecimal feeAmount;

    /**
     * 交易费(客户付款金额*2.24%)
     */
    private BigDecimal transactionFee;

    /**
     * TIKTOK商店佣金
     */
    private BigDecimal platformCommissionAmount;

    /**
     * 卖家运费
     */
    private BigDecimal shippingFeeAmount;

    /**
     * 实际运费
     */
    private BigDecimal actualShippingFeeAmount;

    /**
     * 平台运费折扣
     */
    private BigDecimal platformShippingFeeDiscountAmount;

    /**
     * 客户运费
     */
    private BigDecimal customerShippingFeeAmount;

    /**
     * 如果卖家负责退货，将收取退货运费。
     */
    private BigDecimal actualReturnShippingFeeAmount;

    /**
     * 退还客户运费
     */
    private BigDecimal refundShippingFee;

    /**
     * 运费补贴
     */
    private BigDecimal shippingFeeSubsidyAmount;

    /**
     * SFP服务费(订单金额*5.6%)
     */
    private BigDecimal sfpFee;

    /**
     * 客户付款金额
     */
    private BigDecimal customerPaymentAmount;

    private BigDecimal salesTaxPaymentAmount;

    /**
     * 退款返回折扣
     */
    private BigDecimal platformDiscountRefundAmount;

    /**
     * 退还金额
     */
    private BigDecimal customerRefundAmount;

    /**
     * 平台补贴的退款金额
     */
    private BigDecimal platformRefundSubsidyAmount;

    /**
     * 从最终结算中扣除的退款金额
     */
    private BigDecimal customerOrderRefundAmount;

    /**
     * 仅适用于美国。向买方收取的产品和交付的最终销售税
     */
    private BigDecimal salesTaxAmount;

    /**
     * 仅适用于美国。如果购买被退还，所申请的销售税将退还给买家。
     */
    private BigDecimal salesTaxRefundAmount;

    /**
     * 客户实际为产品支付的价格（产品销售价格减去任何平台优惠券和商家优惠券）乘以佣金百分比
     */
    private BigDecimal affiliateCommissionAmount;

    /**
     * 客户通过联盟合作伙伴的链接为产品支付的金额
     */
    private BigDecimal affiliatePartnerCommissionAmount;

    /**
     * 仅适用于美国。退货费是在TikTok商店处理成功订单时收取的金额
     */
    private BigDecimal referralFeeAmount;

    /**
     * 最终调整金额
     */
    private BigDecimal adjustmentAmount;

    /**
     * 仅适用于美国。交易费是在TikTok商店处理成功订单时收取的服务费
     */
    private BigDecimal transactionFeeAmount;

    /**
     * 零售交货费用金额
     */
    private BigDecimal retailDeliveryFeeAmount;

    /**
     * 零售配送费由TikTok商店收取和汇款
     */
    private BigDecimal retailDeliveryFeePaymentAmount;

    /**
     * TikTok商店因退货或退款请求规则或其他问题而支付的损失补贴
     */
    private BigDecimal retailDeliveryFeeRefundAmount;

    /**
     * 创作者的个人所得税预扣金额
     */
    private BigDecimal pitAmount;

    /**
     * 退款或退货将从退还的推荐费总额中扣除20%的退款管理费
     */
    private BigDecimal refundAdministrationFeeAmount;

    /**
     * 在扣除任何个人所得税之前支付给创作者的佣金
     */
    private BigDecimal affiliateCommissionBeforePit;

    /**
     * 需要签名确认服务的包裹所产生的费用
     */
    private BigDecimal signatureConfirmationFeeAmount;

    /**
     * 卖家使用TikTok运费产生的运费
     */
    private BigDecimal fbmShippingCostAmount;

    /**
     * 卖家因TikTok完成的订单而产生的运费
     */
    private BigDecimal fbtShippingCostAmount;

    /**
     * TikTok商店提供的运费奖励
     */
    private BigDecimal shippingCostDiscountAmount;

    /**
     * 因卖方过失而从卖方退款订单中扣除的运费奖励金额
     */
    private BigDecimal refundShippingCostDiscountAmount;

    /**
     * 卖家因购买额外的TikTok运输保险服务而产生的运输保险费
     */
    private BigDecimal shippingInsuranceFeeAmount;

    /**
     * 卖家折扣
     */
    private BigDecimal sellerDiscount;

    /**
     * 同步时间
     */
    private LocalDateTime syncTime;

    /**
     * 商品退款金额
     */
    private BigDecimal refundSubtotal;

    /**
     * 运费结算
     */
    private BigDecimal shippingCostAmount;
}
