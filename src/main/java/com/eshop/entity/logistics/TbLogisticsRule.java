package com.eshop.entity.logistics;

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
 * @author logistics
 * @since 2025-02-11
 */
@Getter
@Setter
@ToString
@TableName("tb_logistics_rule")
public class TbLogisticsRule implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 规则ID，主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 平台
     */
    private Integer platformId;

    /**
     * 物流方式
     */
    private Integer logisticsModeId;

    /**
     * 优先级
     */
    private Integer priority;

    /**
     * 最大重量
     */
    private BigDecimal maxWeight;

    /**
     * 最小重量
     */
    private BigDecimal minWeight;

    /**
     * 最长边
     */
    private BigDecimal maxLength;

    /**
     * 最短边
     */
    private BigDecimal minLength;

    /**
     * 长宽高之和
     */
    private BigDecimal dimensionSum;

    /**
     * 创建者
     */
    private Long createId;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 更新者
     */
    private Long updateId;

    /**
     * 更新时间
     */
    private LocalDateTime updateTime;

    /**
     * 备注
     */
    private String remark;

    /**
     * 是否激活（1是 0否）
     */
    private Byte isActive;
}
