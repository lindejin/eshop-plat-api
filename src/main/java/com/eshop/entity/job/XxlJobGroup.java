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
 * @since 2025-02-12
 */
@Getter
@Setter
@ToString
@TableName("xxl_job_group")
public class XxlJobGroup implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 执行器AppName
     */
    private String appName;

    /**
     * 执行器名称
     */
    private String title;

    /**
     * 执行器地址类型：0=自动注册、1=手动录入
     */
    private Byte addressType;

    /**
     * 执行器地址列表，多地址逗号分隔
     */
    private String addressList;

    private Date updateTime;
}
