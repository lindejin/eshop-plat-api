package com.eshop.entity.order;

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
 * 运单表
 * </p>
 *
 * @author order
 * @since 2025-02-11
 */
@Getter
@Setter
@ToString
@TableName("tb_waybill")
public class TbWaybill implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 包裹号
     */
    private Long parcelNo;

    /**
     * 运单号/货运单号
     */
    private String waybillNo;

    /**
     * 仓库id
     */
    private Integer depotId;

    /**
     * 买家自选物流
     */
    private String buyerOptionalLogistics;

    /**
     * 物流服务提供商
     */
    private String checkoutShippingCarrier;

    /**
     * 物流方式/物流渠道
     */
    private Integer logisticsModeId;

    /**
     * 内部单号
     */
    private String interiorNo;

    /**
     * 虚拟单号
     */
    private String virtualNo;

    /**
     * 预估运费
     */
    private BigDecimal estimateFreight;

    /**
     * 实际运费
     */
    private BigDecimal realityFreight;

    /**
     * 货运重量(g),预估重量 
     */
    private Double freightWeight;

    /**
     * 包材_id
     */
    private Integer packingId;

    /**
     * 包材费
     */
    private BigDecimal packingFee;

    /**
     * 包材重量
     */
    private Double packingWeight;

    /**
     * 运单第三方_id
     */
    private String waybillExternalId;

    /**
     * 订单自定义id
     */
    private String waybillCustomizeId;

    /**
     * 发货类型(1: 国内发货, 2: 国外发货)
     */
    private Byte shipmentType;

    /**
     * 包裹类型(1: 初始包裹,2:拆包包裹,3 重发包裹,4:寄样包裹)
     */
    private Byte parcelType;

    /**
     * 是否妥投(1: 是, 2:否)
     */
    private Byte isDelivered;

    /**
     * 是否虚假运单(1:是, 2:否)
     */
    private Byte isFakeWaybill;

    /**
     * 是否需要采购(1:是, 2:否)
     */
    private Byte isPurchase;

    /**
     * 是否上传至平台(1:是, 2:否)
     */
    private Byte isUpload;

    /**
     * 是否下载(1: 是, 2:否)
     */
    private Byte isDownload;

    /**
     * 是否已推送仓库(1: 是, 2:否)
     */
    private Byte isPushDepot;

    /**
     * 运单号上传至平台时间
     */
    private LocalDateTime uploadTime;

    /**
     * 出库时间
     */
    private LocalDateTime outboundTime;

    /**
     * 包裹备注
     */
    private String remark;
}
