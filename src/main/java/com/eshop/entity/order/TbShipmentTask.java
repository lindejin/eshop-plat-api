package com.eshop.entity.order;

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
 * 发货单批次列表
 * </p>
 *
 * @author order
 * @since 2025-02-12
 */
@Getter
@Setter
@ToString
@TableName("tb_shipment_task")
public class TbShipmentTask implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 揽货批次号
     */
    private Long batchNo;

    /**
     * 批次状态
     */
    private Byte batchStatus;

    /**
     * 批次类型 1揽收 2自寄
     */
    private Byte batchType;

    /**
     * 平台id
     */
    private Long platformId;

    /**
     * 渠道id
     */
    private Long platChannelId;

    /**
     * 店铺id
     */
    private Long shopId;

    /**
     * 订单总数
     */
    private Long orderTotal;

    /**
     * 批次重量
     */
    private BigDecimal batchWeight;

    /**
     * 上传货代
     */
    private String uploadForwarder;

    /**
     * 交接单号
     */
    private String handoverNo;

    /**
     * 国内快递单号
     */
    private String domesticExpressNo;

    /**
     * 上传成功数
     */
    private Long uploadSuccessCount;

    /**
     * 上传失败数
     */
    private Long uploadFailCount;

    /**
     * 订单类型 4.ae全托管jit 5.ae全托管cf
     */
    private Long orderType;

    /**
     * 发货单号
     */
    private String consignOrderNo;

    /**
     * 创建人
     */
    private Long creatorId;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * file_id
     */
    private Long fileId;

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
    private Long deleteId;

    /**
     * 删除时间
     */
    private Date deleteTime;
}
