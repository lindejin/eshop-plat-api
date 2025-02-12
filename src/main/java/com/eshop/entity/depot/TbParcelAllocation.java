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
 * 包裹配货
 * </p>
 *
 * @author depot
 * @since 2025-02-12
 */
@Getter
@Setter
@ToString
@TableName("tb_parcel_allocation")
public class TbParcelAllocation implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 配货批次号
     */
    private Long batchNo;

    /**
     * 篮子编号
     */
    private Long basketCode;

    /**
     * 备注
     */
    private String remark;

    /**
     * 是否已完成配货(1:是,2:否)
     */
    private Byte isAllocation;

    /**
     * 配货人
     */
    private Long createId;

    /**
     * 配货时间
     */
    private Date allocationTime;

    /**
     * 配货类型 （1:单品,2:多品)
     */
    private Byte allocationType;

    /**
     * 配货类型（1.常规配货 2.快速配货）
     */
    private Byte allocationMethod;
}
