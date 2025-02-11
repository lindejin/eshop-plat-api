package com.eshop.entity.kpi;

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
 * 项目组gmv
 * </p>
 *
 * @author kpi
 * @since 2025-02-11
 */
@Getter
@Setter
@ToString
@TableName("kpi_project_team_gmv")
public class KpiProjectTeamGmv implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 项目组id
     */
    private Integer teamId;

    /**
     * 结算月份(yyyy-MM)
     */
    private String settlementTime;

    /**
     * 上月平均
     */
    private BigDecimal lastMonthAverage;

    /**
     * 本月目标
     */
    private BigDecimal thisMonthTarget;

    /**
     * 创建人id
     */
    private Integer createId;

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
}
