package com.eshop.entity.supply;

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
 * 采购单
 * </p>
 *
 * @author supply
 * @since 2025-03-07
 */
@Getter
@Setter
@ToString
@TableName("tb_purchases_order")
public class TbPurchasesOrder implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 采购单号
     */
    private Long purchaseNo;

    /**
     * 第三方单号
     */
    private String thirdPartyNo;

    /**
     * 供应商id
     */
    private Long providerId;

    /**
     * 供应商收款账号id
     */
    private Long receiptId;

    /**
     * 仓库id
     */
    private Long depotId;

    /**
     * 关联的备货单
     */
    private Long prepareId;

    /**
     * 订单类型(1:缺货采购,2:备货采购)
     */
    private Byte orderType;

    /**
     * 采购单状态(1:待发货,2:待收货,3:部分收货,4.已完成,5:已作废)
     */
    private Byte orderStatus;

    /**
     * 付款状态(1:待申请付款,2:待财务审核,3:待付款,4:已付款,5:审核不通过)
     */
    private Byte paymentStatus;

    /**
     * 采购渠道(1:1688,2:淘宝,3:拼多多,4:线下,5:其他)
     */
    private Byte purchasesPlace;

    /**
     * 是否需要付款(1: 需要付款, 2: 暂不付款)
     */
    private Byte isNeedPayment;

    /**
     * 付款时间
     */
    private Date paymentTime;

    /**
     * 订单完成时间
     */
    private Date finishTime;

    /**
     * 账号流水编号
     */
    private String invoicesNo;

    /**
     * 订单货品金额
     */
    private BigDecimal orderMoney;

    /**
     * 折扣价 (采购单支付金额需扣除折扣价)
     */
    private BigDecimal discountPrice;

    /**
     * 其他费用
     */
    private BigDecimal otherMoney;

    /**
     * 运费
     */
    private BigDecimal sumFreight;

    /**
     * 订单备注
     */
    private String remark;

    /**
     * 下单人
     */
    private Long createrId;

    /**
     * 下单时间
     */
    private Date createTime;
}
