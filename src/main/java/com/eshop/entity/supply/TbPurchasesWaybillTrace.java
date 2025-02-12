package com.eshop.entity.supply;

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
 * 采购单物流轨迹
 * </p>
 *
 * @author supply
 * @since 2025-02-12
 */
@Getter
@Setter
@ToString
@TableName("tb_purchases_waybill_trace")
public class TbPurchasesWaybillTrace implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 运单号
     */
    private String waybillNo;

    /**
     * 节点发生时间
     */
    private Date acceptTime;

    /**
     * 事件名称
     */
    private String info;
}
