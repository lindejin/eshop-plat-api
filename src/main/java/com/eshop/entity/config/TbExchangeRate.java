package com.eshop.entity.config;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * <p>
 * 汇率
 * </p>
 *
 * @author config
 * @since 2025-02-11
 */
@Getter
@Setter
@ToString
@TableName("tb_exchange_rate")
public class TbExchangeRate implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 货币类型
     */
    private String currencyType;

    /**
     * 货币名称
     */
    private String currencyName;

    /**
     * 汇率类型(1: 真实汇率, 2:折扣汇率, 3: 固定汇率)
     */
    private Byte exchangeRateType;

    /**
     * 折扣率(如果是折扣汇率_已小数方式存储)
     */
    private Double discountRate;

    /**
     * 创建人id
     */
    private Integer createrId;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 最后修改人id
     */
    private Integer lastUpdateId;

    /**
     * 最后修改时间
     */
    private LocalDateTime lastUpdateTime;

    /**
     * 货币符号
     */
    private String currencySymbol;
}
