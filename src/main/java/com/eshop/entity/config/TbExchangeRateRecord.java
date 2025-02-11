package com.eshop.entity.config;

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
 * 汇率记录
 * </p>
 *
 * @author config
 * @since 2025-02-11
 */
@Getter
@Setter
@ToString
@TableName("tb_exchange_rate_record")
public class TbExchangeRateRecord implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 货币类型
     */
    private String currencyType;

    /**
     * 同步日期(yyyy-MM-dd)
     */
    private LocalDateTime syncDate;

    /**
     * 执行汇率(7位小数)
     */
    private BigDecimal executeExchangeRate;

    /**
     * 实际汇率(7位小数)
     */
    private BigDecimal actualExchangeRate;

    /**
     * 汇率类型(1: 真实汇率, 2:折扣汇率, 3: 固定汇率)
     */
    private Byte exchangeRateType;

    /**
     * 折扣率(如果是折扣汇率_已小数方式存储)
     */
    private Double discountRate;
}
