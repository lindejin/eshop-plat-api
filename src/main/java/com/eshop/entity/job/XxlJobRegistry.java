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
@TableName("xxl_job_registry")
public class XxlJobRegistry implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    private String registryGroup;

    private String registryKey;

    private String registryValue;

    private Date updateTime;
}
