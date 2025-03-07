package com.eshop.entity.finance;

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
 * 包裹每日结算
 * </p>
 *
 * @author finance
 * @since 2025-03-07
 */
@Getter
@Setter
@ToString
@TableName("tb_parcel_daily_settlement")
public class TbParcelDailySettlement implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 包裹号
     */
    private Long parcelNo;

    /**
     * 商户_id
     */
    private Long merchantId;

    /**
     * 商户_成本价
     */
    private BigDecimal merchantCostPrice;

    /**
     * 预估运费
     */
    private BigDecimal estimateFreight;

    /**
     * 包材费
     */
    private BigDecimal packingFee;

    /**
     * 手续费
     */
    private BigDecimal proceduresCost;

    /**
     * 结算时间
     */
    private Date settlementTime;
}
