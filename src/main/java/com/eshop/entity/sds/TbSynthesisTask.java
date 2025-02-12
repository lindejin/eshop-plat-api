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
 * 模特合成任务配置
 * </p>
 *
 * @author sds
 * @since 2025-02-12
 */
@Getter
@Setter
@ToString
@TableName("tb_synthesis_task")
public class TbSynthesisTask implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 商户_id
     */
    private Long merchantId;

    /**
     * 模版id
     */
    private Long templateId;

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
    private Long targetQuantity;

    /**
     * 执行数量
     */
    private Long executorQuantity;

    /**
     * 创建人id
     */
    private Long createId;

    /**
     * 创建时间
     */
    private Date createTime;
}
