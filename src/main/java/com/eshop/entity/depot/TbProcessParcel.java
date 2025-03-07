package com.eshop.entity.depot;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * <p>
 * 加工包裹
 * </p>
 *
 * @author depot
 * @since 2025-03-07
 */
@Getter
@Setter
@ToString
@TableName("tb_process_parcel")
public class TbProcessParcel implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 商户_id
     */
    private Long merchantId;

    /**
     * 批次号
     */
    private Long batchNo;

    /**
     * 仓库id
     */
    private Long depotId;

    /**
     * 包裹号
     */
    private Long parcelNo;

    /**
     * 店铺_id
     */
    private Long shopId;

    /**
     * 平台_id
     */
    private Long platformId;

    /**
     * 运单号/货运单号
     */
    private String waybillNo;

    /**
     * 包裹类型(1:单品,2:多品)
     */
    private Byte parcelType;

    /**
     * 包裹状态(-1: 已取消,1: 待配货,2: 待复核,3: 已出库,4: 加工中)
     */
    private Byte parcelStatus;

    /**
     * 小篮子编号(多品复核用)
     */
    private Long smallBasketCode;

    /**
     * 包裹重量
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
     * 备注
     */
    private String remark;

    /**
     * 创建人id
     */
    private Long createrId;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 是否已被删除(1: 是, 2: 否)
     */
    private Byte isDelete;

    /**
     * 删除时间
     */
    private Date deleteTime;
}
