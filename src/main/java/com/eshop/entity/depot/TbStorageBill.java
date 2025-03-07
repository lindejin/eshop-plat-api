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
 * 入库单
 * </p>
 *
 * @author depot
 * @since 2025-03-07
 */
@Getter
@Setter
@ToString
@TableName("tb_storage_bill")
public class TbStorageBill implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 入库单编号
     */
    private Long storageNo;

    /**
     * 仓库id
     */
    private Long depotId;

    /**
     * 采购单编号
     */
    private Long purchasesNo;

    /**
     * 备注
     */
    private String remark;

    /**
     * 入库人_id
     */
    private Long storagePersonId;

    /**
     * 入库时间
     */
    private Date storageTime;

    /**
     * 入库状态(1:常规入库,2:非常规入库)
     */
    private Byte storageStatus;
}
