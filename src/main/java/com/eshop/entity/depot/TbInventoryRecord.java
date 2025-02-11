package com.eshop.entity.depot;

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
 * 盘点计划
 * </p>
 *
 * @author depot
 * @since 2025-02-11
 */
@Getter
@Setter
@ToString
@TableName("tb_inventory_record")
public class TbInventoryRecord implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 盘点编号
     */
    private Long inventoryNo;

    /**
     * 停止计划人
     */
    private Integer stopTaskId;

    /**
     * 停止计划时间
     */
    private LocalDateTime stopTaskTime;

    /**
     * 审核人
     */
    private Integer reviewTaskId;

    /**
     * 审核时间
     */
    private LocalDateTime reviewTaskTime;

    /**
     * 复核人
     */
    private Integer checkTaskId;

    /**
     * 复核时间
     */
    private LocalDateTime checkTaskTime;

    /**
     * 作废人
     */
    private Integer invalidTaskId;

    /**
     * 作废时间
     */
    private LocalDateTime invalidTaskTime;
}
