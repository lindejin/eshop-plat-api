package com.eshop.entity.order;

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
 * 发货单列表（箱唛）
 * </p>
 *
 * @author order
 * @since 2025-02-11
 */
@Getter
@Setter
@ToString
@TableName("tb_shipment_order")
public class TbShipmentOrder implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 揽货批次号
     */
    private Long batchNo;

    /**
     * 平台id
     */
    private Integer platformId;

    /**
     * 店铺id
     */
    private Integer shopId;

    /**
     * 订单号
     */
    private String orderNo;

    /**
     * 订单id
     */
    private Long orderId;

    /**
     * 采购单号
     */
    private String platPurchaseOrderNo;

    /**
     * 渠道id
     */
    private Long platChannelId;

    /**
     * 发货类型
     */
    private String shipmentType;

    /**
     * 发货状态
     */
    private Integer shipmentStatus;

    /**
     * 订单类型 4.ae全托管jit 5.ae全托管cf
     */
    private Integer orderType;

    /**
     * 发货单号
     */
    private String consignOrderNo;

    /**
     * 创建人
     */
    private Integer creatorId;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 扩展字段1
     */
    private String extField1;

    /**
     * 扩展字段2
     */
    private String extField2;

    /**
     * 扩展字段3
     */
    private String extField3;

    /**
     * 是否删除(1: 是, 2:否)
     */
    private Byte isDelete;

    /**
     * 删除人
     */
    private Integer deleteId;

    /**
     * 删除时间
     */
    private LocalDateTime deleteTime;
}
