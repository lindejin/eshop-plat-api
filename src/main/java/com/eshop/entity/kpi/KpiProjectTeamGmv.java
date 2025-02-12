package com.eshop.entity.kpi;

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
 * 项目组gmv
 * </p>
 *
 * @author kpi
 * @since 2025-02-12
 */
@Getter
@Setter
@ToString
@TableName("kpi_project_team_gmv")
public class KpiProjectTeamGmv implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 项目组id
     */
    private Long teamId;

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
    private Long createId;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 最后修改人id
     */
    private Long lastUpdateId;

    /**
     * 最后修改时间
     */
    private Date lastUpdateTime;
}
