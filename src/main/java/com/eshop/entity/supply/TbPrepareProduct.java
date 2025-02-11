package com.eshop.entity.supply;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * <p>
 * 备货单 
 * </p>
 *
 * @author supply
 * @since 2025-02-11
 */
@Getter
@Setter
@ToString
@TableName("tb_prepare_product")
public class TbPrepareProduct implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 备货单号
     */
    private Long prepareNo;

    /**
     * 商户_id
     */
    private Integer merchantId;

    /**
     * 仓库id
     */
    private Integer depotId;

    /**
     * 备货计划名称
     */
    private String prepareName;

    /**
     * 供应商_id
     */
    private Integer supplierId;

    /**
     * 备货类型(1: 常规备货)
     */
    private Byte prepareType;

    /**
     * 备货单状态(-1: 驳回,1: 待申请, 2: 待审核, 3: 已审核)
     */
    private Byte prepareStatus;

    /**
     * 是否推送wms(1:已推送,2:未推送)
     */
    private Byte isPushWms;

    /**
     * 商品总费用
     */
    private BigDecimal productSumMoney;

    /**
     * 创建人
     */
    private Integer createrId;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 审核人
     */
    private Integer auditorId;

    /**
     * 审核时间
     */
    private LocalDateTime auditorTime;

    /**
     * 备注
     */
    private String remark;

    /**
     * 是否已被删除(1: 是, 2: 否)
     */
    private Byte isDelete;

    /**
     * 删除时间
     */
    private LocalDateTime deleteTime;
}
