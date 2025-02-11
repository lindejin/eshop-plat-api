package com.eshop.entity.log;

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
 * 费用运行日志
 * </p>
 *
 * @author log
 * @since 2025-02-11
 */
@Getter
@Setter
@ToString
@TableName("tb_cost_log")
public class TbCostLog implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 运行属性/运行描述
     */
    private String operateProperty;

    /**
     * 描述
     */
    private String description;

    /**
     * 更新前费用cost_json
     */
    private String rawCostJson;

    /**
     * 更新后费用updated_cost_json
     */
    private String updatedCostJson;

    /**
     * 业务id biz_id
     */
    private String bizId;

    /**
     * 操作人
     */
    private String operator;

    /**
     * 运行时间
     */
    private LocalDateTime operateTime;
}
