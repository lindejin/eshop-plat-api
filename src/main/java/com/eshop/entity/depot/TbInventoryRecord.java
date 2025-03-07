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
 * 盘点计划
 * </p>
 *
 * @author depot
 * @since 2025-03-07
 */
@Getter
@Setter
@ToString
@TableName("tb_inventory_record")
public class TbInventoryRecord implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 盘点编号
     */
    private Long inventoryNo;

    /**
     * 停止计划人
     */
    private Long stopTaskId;

    /**
     * 停止计划时间
     */
    private Date stopTaskTime;

    /**
     * 审核人
     */
    private Long reviewTaskId;

    /**
     * 审核时间
     */
    private Date reviewTaskTime;

    /**
     * 复核人
     */
    private Long checkTaskId;

    /**
     * 复核时间
     */
    private Date checkTaskTime;

    /**
     * 作废人
     */
    private Long invalidTaskId;

    /**
     * 作废时间
     */
    private Date invalidTaskTime;
}
