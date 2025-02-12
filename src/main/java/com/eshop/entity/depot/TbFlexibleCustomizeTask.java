package com.eshop.entity.depot;

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
 * 柔性定制任务
 * </p>
 *
 * @author depot
 * @since 2025-02-12
 */
@Getter
@Setter
@ToString
@TableName("tb_flexible_customize_task")
public class TbFlexibleCustomizeTask implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 批次号
     */
    private Long batchNo;

    /**
     * 篮子编号
     */
    private Long bigBasketCode;

    /**
     * 任务类型
     */
    private Byte taskType;

    /**
     * 状态
     */
    private Byte taskStatus;

    /**
     * 创建人
     */
    private Long createId;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 本次合成数量
     */
    private Long composeQuantity;

    /**
     * 备注
     */
    private String remark;
}
