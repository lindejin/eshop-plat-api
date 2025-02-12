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
 * @since 2025-02-12
 */
@Getter
@Setter
@ToString
@TableName("tb_inventory_task")
public class TbInventoryTask implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 仓库id
     */
    private Long depotId;

    /**
     * 盘点名称
     */
    private String inventoryTaskName;

    /**
     * 盘点编号
     */
    private Long inventoryNo;

    /**
     * 盘点类型
     */
    private Byte inventoryType;

    /**
     * 盘点状态 1.等待盘点(盘点创建) 2.盘点中 3.待审核（盘点结束）4.审核通过 5.审核不通过 6.盘点复核 9.盘点作废
     */
    private Byte inventoryStatus;

    /**
     * 创建人
     */
    private Long createId;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 备注
     */
    private String remark;
}
