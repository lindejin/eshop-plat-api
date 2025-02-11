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
 * 订单流水
 * </p>
 *
 * @author order
 * @since 2025-02-11
 */
@Getter
@Setter
@ToString
@TableName("tb_order_flowing_water")
public class TbOrderFlowingWater implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 平台编码
     */
    private String platformCode;

    /**
     * 店铺id
     */
    private Integer shopId;

    /**
     * 订单号
     */
    private String orderNo;

    /**
     * 流水类型(1: 订单结算. 2: 订单扣款, 3: 订单退款, 4: 冻结)
     */
    private Byte flowingWaterType;

    /**
     * 流水触发时间
     */
    private LocalDateTime flowingWaterTime;

    /**
     * 收入金额/支出支出 (只填写正数)
     */
    private BigDecimal money;

    /**
     * excel原始金额
     */
    private BigDecimal rawMoney;

    /**
     * 备注
     */
    private String remark;

    /**
     * 最后修改人id
     */
    private Integer lastUpdateId;

    /**
     * 最后修改时间
     */
    private LocalDateTime lastUpdateTime;
}
