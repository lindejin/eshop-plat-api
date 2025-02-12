package com.eshop.entity.log;

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
 * 订单运行日志
 * </p>
 *
 * @author log
 * @since 2025-02-12
 */
@Getter
@Setter
@ToString
@TableName("tb_inventory_log")
public class TbInventoryLog implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 盘点计划编号
     */
    private Long inventoryNo;

    /**
     * 运行属性/运行描述
     */
    private String operateProperty;

    /**
     * 描述
     */
    private String description;

    /**
     * 操作人
     */
    private Long operatorId;

    /**
     * 操作人id
     */
    private String operator;

    /**
     * 运行时间
     */
    private Date operateTime;
}
