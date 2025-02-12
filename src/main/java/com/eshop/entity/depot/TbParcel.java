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
 * 包裹
 * </p>
 *
 * @author depot
 * @since 2025-02-12
 */
@Getter
@Setter
@ToString
@TableName("tb_parcel")
public class TbParcel implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 包裹号
     */
    private Long parcelNo;

    /**
     * 商户_id
     */
    private Long merchantId;

    /**
     * 店铺_id
     */
    private Long shopId;

    /**
     * 平台_id
     */
    private Long platformId;

    /**
     * 批次号
     */
    private Long batchNo;

    /**
     * 仓库id
     */
    private Long depotId;

    /**
     * 运单号/货运单号
     */
    private String waybillNo;

    /**
     * 订单号
     */
    private String orderNo;

    /**
     * 大篮子号
     */
    private Long basketNo;

    /**
     * 小篮子号
     */
    private Long smallBasketNo;

    /**
     * 物流方式
     */
    private Long modeId;

    /**
     * 商户_成本价
     */
    private BigDecimal sumMerchantCostPrice;

    /**
     * 包裹重量
     */
    private Double weight;

    /**
     * 包裹状态(1:待配货,2:待复核,3:待打包,4:待出库,5:已出库,6:包裹换单,99:包裹退单)
     */
    private Byte parcelStatus;

    /**
     * 包裹类型(1:单品,2:多品)
     */
    private Byte parcelType;

    /**
     * 订单日期
     */
    private Date orderTime;

    /**
     * 备注
     */
    private String remark;
}
