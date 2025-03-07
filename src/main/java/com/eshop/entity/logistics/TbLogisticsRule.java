package com.eshop.entity.logistics;

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
 * 
 * </p>
 *
 * @author logistics
 * @since 2025-03-07
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
    private Long id;

    /**
     * 平台
     */
    private Long platformId;

    /**
     * 物流方式
     */
    private Long logisticsModeId;

    /**
     * 优先级
     */
    private Long priority;

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
    private Date createTime;

    /**
     * 更新者
     */
    private Long updateId;

    /**
     * 更新时间
     */
    private Date updateTime;

    /**
     * 备注
     */
    private String remark;

    /**
     * 是否激活（1是 0否）
     */
    private Byte isActive;
}
