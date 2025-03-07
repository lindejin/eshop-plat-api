package com.eshop.entity.job;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * <p>
 * 
 * </p>
 *
 * @author job
 * @since 2025-02-12
 */
@Getter
@Setter
@ToString
@TableName("xxl_job_lock")
public class XxlJobLock implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 锁名称
     */
    @TableId("lock_name")
    private String lockName;
}
