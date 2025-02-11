package com.eshop.entity.sds;

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
 * 规则-配置表(可能多个  和阶段分项事件一对多)
 * </p>
 *
 * @author sds
 * @since 2025-02-11
 */
@Getter
@Setter
@ToString
@TableName("rule_config")
public class RuleConfig implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 分项配置规则id
     */
    private Integer itemConfigId;

    /**
     * 排序
     */
    private Integer sort;

    /**
     * 条件类型 1.大于 2.大于等于 3.小于 4.小于等于 5.等于 6.不等于
     */
    private Integer type;

    /**
     * 具体值
     */
    private BigDecimal value;

    /**
     * 创建人
     */
    private Integer createId;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 修改人
     */
    private Integer updateId;

    /**
     * 修改时间
     */
    private LocalDateTime updateTime;

    /**
     * 条件类型 1.或 2.且 3非
     */
    private Integer relationType;
}
