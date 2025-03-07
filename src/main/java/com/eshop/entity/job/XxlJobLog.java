package com.eshop.entity.job;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * <p>
 * 
 * </p>
 *
 * @author job
 * @since 2025-03-07
 */
@Getter
@Setter
@ToString
@TableName("xxl_job_log")
public class XxlJobLog implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 执行器主键ID
     */
    private Long jobGroup;

    /**
     * 任务，主键ID
     */
    private Long jobId;

    /**
     * 执行器地址，本次执行的地址
     */
    private String executorAddress;

    /**
     * 执行器任务handler
     */
    private String executorHandler;

    /**
     * 执行器任务参数
     */
    private String executorParam;

    /**
     * 执行器任务分片参数，格式如 1/2
     */
    private String executorShardingParam;

    /**
     * 失败重试次数
     */
    private Long executorFailRetryCount;

    /**
     * 调度-时间
     */
    private Date triggerTime;

    /**
     * 调度-结果
     */
    private Long triggerCode;

    /**
     * 调度-日志
     */
    private String triggerMsg;

    /**
     * 执行-时间
     */
    private Date handleTime;

    /**
     * 执行-状态
     */
    private Long handleCode;

    /**
     * 执行-日志
     */
    private String handleMsg;

    /**
     * 告警状态：0-默认、1-无需告警、2-告警成功、3-告警失败
     */
    private Byte alarmStatus;
}
