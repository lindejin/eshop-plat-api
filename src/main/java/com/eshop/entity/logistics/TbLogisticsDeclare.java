package com.eshop.entity.logistics;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.math.BigDecimal;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * <p>
 * 申报信息
 * </p>
 *
 * @author logistics
 * @since 2025-02-12
 */
@Getter
@Setter
@ToString
@TableName("tb_logistics_declare")
public class TbLogisticsDeclare implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 物流方式_id
     */
    private Long modeId;

    /**
     * 申报品名(中)
     */
    private String declareCnName;

    /**
     * 申报品名(英)
     */
    private String declareEnName;

    /**
     * 申报百分比
     */
    private Double declarePercentage;

    /**
     * 最小申报值
     */
    private BigDecimal minDeclaredValue;

    /**
     * 最大申报值
     */
    private BigDecimal maxDeclaredValue;

    /**
     * 申报重量(g)
     */
    private Double declaredWeight;

    /**
     * 是否开启组合sku申报(1:未开启, 2:已开启)
     */
    private Byte isCombineSku;

    /**
     * 是否优先按渠道【申报重量】进行申报(1: 否, 2:是)
     */
    private Byte isPriorityPlace;
}
