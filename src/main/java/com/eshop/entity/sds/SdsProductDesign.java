package com.eshop.entity.sds;

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
 * sds-产品设计队列
 * </p>
 *
 * @author sds
 * @since 2025-02-12
 */
@Getter
@Setter
@ToString
@TableName("sds_product_design")
public class SdsProductDesign implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 设计任务id
     */
    private String taskId;

    /**
     * 是否已同步【sds已设计完成并已拉取成品数据】（0未同步或未设计 1同步完成）
     */
    private String syn;

    /**
     * 任务创建时间
     */
    private Date createTime;
}
