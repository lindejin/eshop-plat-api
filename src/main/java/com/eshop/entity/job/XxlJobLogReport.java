package com.eshop.entity.job;

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
 * 
 * </p>
 *
 * @author job
 * @since 2025-02-11
 */
@Getter
@Setter
@ToString
@TableName("xxl_job_log_report")
public class XxlJobLogReport implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 调度-时间
     */
    private LocalDateTime triggerDay;

    /**
     * 运行中-日志数量
     */
    private Integer runningCount;

    /**
     * 执行成功-日志数量
     */
    private Integer sucCount;

    /**
     * 执行失败-日志数量
     */
    private Integer failCount;

    private LocalDateTime updateTime;
}
