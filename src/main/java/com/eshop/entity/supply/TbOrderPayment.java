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
 * 采购单付款信息
 * </p>
 *
 * @author supply
 * @since 2025-02-12
 */
@Getter
@Setter
@ToString
@TableName("tb_order_payment")
public class TbOrderPayment implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

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
    private Long paymentBankId;

    /**
     * 付款方式(1:现款,2:支付宝,3:微信)
     */
    private Byte paymentType;

    /**
     * 供应商id
     */
    private Long supplierId;

    /**
     * 申请人
     */
    private Long petitionerId;

    /**
     * 申请时间
     */
    private Date petitionerTime;

    /**
     * 审核人_id
     */
    private Long auditorId;

    /**
     * 审核时间
     */
    private Date auditorTime;

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
    private Long paymentPersonId;

    /**
     * 付款时间
     */
    private Date paymentTime;

    /**
     * 付款信息是否作废(1:正常,2:已作废)
     */
    private Byte paymentIsInvalid;
}
