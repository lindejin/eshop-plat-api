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
 * 质检单
 * </p>
 *
 * @author depot
 * @since 2025-02-11
 */
@Getter
@Setter
@ToString
@TableName("tb_quality_control")
public class TbQualityControl implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 质检单号
     */
    private Long qcNo;

    /**
     * 仓库id
     */
    private Integer depotId;

    /**
     * 供应商id
     */
    private Integer supplierId;

    /**
     * 质检员id
     */
    private Integer qualityInspectorId;

    /**
     * 质检时间
     */
    private LocalDateTime qcTime;
}
