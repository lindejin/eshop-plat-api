package com.eshop.entity.supply;

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
 * 采购单付款信息
 * </p>
 *
 * @author supply
 * @since 2025-02-11
 */
@Getter
@Setter
@ToString
@TableName("tb_order_payment")
public class TbOrderPayment implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 付款单号
     */
    private Long paymentNo;

    /**
     * 采购单号
     */
    private Long purchaseNo;

    /**
     * 付款银行账户id
     */
    private Integer paymentBankId;

    /**
     * 付款方式(1:现款,2:支付宝,3:微信)
     */
    private Byte paymentType;

    /**
     * 供应商id
     */
    private Integer supplierId;

    /**
     * 申请人
     */
    private Integer petitionerId;

    /**
     * 申请时间
     */
    private LocalDateTime petitionerTime;

    /**
     * 审核人_id
     */
    private Integer auditorId;

    /**
     * 审核时间
     */
    private LocalDateTime auditorTime;

    /**
     * 应付金额
     */
    private BigDecimal copeMoney;

    /**
     * 实付金额
     */
    private BigDecimal actualMoney;

    /**
     * 付款人
     */
    private Integer paymentPersonId;

    /**
     * 付款时间
     */
    private LocalDateTime paymentTime;

    /**
     * 付款信息是否作废(1:正常,2:已作废)
     */
    private Byte paymentIsInvalid;
}
