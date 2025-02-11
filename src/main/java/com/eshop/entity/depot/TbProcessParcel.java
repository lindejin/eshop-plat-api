package com.eshop.entity.depot;

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
 * 加工包裹
 * </p>
 *
 * @author depot
 * @since 2025-02-11
 */
@Getter
@Setter
@ToString
@TableName("tb_process_parcel")
public class TbProcessParcel implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 商户_id
     */
    private Integer merchantId;

    /**
     * 批次号
     */
    private Long batchNo;

    /**
     * 仓库id
     */
    private Integer depotId;

    /**
     * 包裹号
     */
    private Long parcelNo;

    /**
     * 店铺_id
     */
    private Integer shopId;

    /**
     * 平台_id
     */
    private Integer platformId;

    /**
     * 运单号/货运单号
     */
    private String waybillNo;

    /**
     * 包裹类型(1:单品,2:多品)
     */
    private Byte parcelType;

    /**
     * 包裹状态(-1: 已取消,-2:已退件,1: 待配货,2: 待复核,3: 已出库,4: 加工中,5:已复核)
     */
    private Byte parcelStatus;

    /**
     * 小篮子编号(多品复核用)
     */
    private Long smallBasketCode;

    /**
     * 包裹重量(g)
     */
    private Double parcelWeight;

    /**
     * 包裹运费
     */
    private BigDecimal parcelFreight;

    /**
     * 包裹成本价
     */
    private BigDecimal parcelCost;

    /**
     * 包材费
     */
    private BigDecimal packingFee;

    /**
     * 虚拟篮子编号
     */
    private Integer virtualBasketNo;

    /**
     * 是否优先配货 (1:是 2:否)
     */
    private Byte priorityDistribution;

    /**
     * 平台最迟发货时间
     */
    private LocalDateTime deliveryDeadlineTime;

    /**
     * 备注
     */
    private String remark;

    /**
     * 创建人id
     */
    private Integer createrId;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 是否已被删除(1: 是, 2: 否)
     */
    private Byte isDelete;

    /**
     * 删除时间
     */
    private LocalDateTime deleteTime;

    /**
     * 物流方式/物流渠道
     */
    private Integer logisticsModeId;

    /**
     * 面单序号
     */
    private Integer pdfIndex;

    /**
     * 排序字段
     */
    private Integer sort;
}
