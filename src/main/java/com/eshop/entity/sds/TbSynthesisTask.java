package com.eshop.entity.sds;

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
 * 模特合成任务配置
 * </p>
 *
 * @author sds
 * @since 2025-02-11
 */
@Getter
@Setter
@ToString
@TableName("tb_synthesis_task")
public class TbSynthesisTask implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 商户_id
     */
    private Integer merchantId;

    /**
     * 模版id
     */
    private Integer templateId;

    /**
     * 样机_id(1,2,3)
     */
    private String prototypeId;

    /**
     * 素材分类_id(1,2,3)
     */
    private String materialClassifyId;

    /**
     * 背景_id(1,2,3)
     */
    private String backgroundId;

    /**
     * 任务状态(1: 运行中, 2: 已停止)
     */
    private Byte taskStatus;

    /**
     * 目标数量
     */
    private Integer targetQuantity;

    /**
     * 执行数量
     */
    private Integer executorQuantity;

    /**
     * 创建人id
     */
    private Integer createId;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;
}
