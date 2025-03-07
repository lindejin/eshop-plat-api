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
 * 质检单
 * </p>
 *
 * @author depot
 * @since 2025-03-07
 */
@Getter
@Setter
@ToString
@TableName("tb_quality_control")
public class TbQualityControl implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 质检单号
     */
    private Long qcNo;

    /**
     * 仓库id
     */
    private Long depotId;

    /**
     * 供应商id
     */
    private Long supplierId;

    /**
     * 质检员id
     */
    private Long qualityInspectorId;

    /**
     * 质检时间
     */
    private Date qcTime;
}
