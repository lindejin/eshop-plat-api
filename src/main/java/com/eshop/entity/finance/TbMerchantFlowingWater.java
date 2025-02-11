package com.eshop.entity.finance;

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
 * 商户流水
 * </p>
 *
 * @author finance
 * @since 2025-02-11
 */
@Getter
@Setter
@ToString
@TableName("tb_merchant_flowing_water")
public class TbMerchantFlowingWater implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 商户id
     */
    private Integer merchantId;

    /**
     * 流水类型(1: 收入, 2: 支出)
     */
    private Byte flowType;

    /**
     * 流水标志(如: 充值, 备货, 订单结算, 运费支出)
     */
    private String flowMark;

    /**
     * 金额
     */
    private BigDecimal money;

    /**
     * 是否_关联余额(1: 是, 2: 否)
     */
    private Byte isJoinBalance;

    /**
     * 当前商户余额(支出/收入后的)
     */
    private BigDecimal currentBalance;

    /**
     * 备注
     */
    private String remark;

    /**
     * 创建人id
     */
    private Integer creatorId;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;
}
