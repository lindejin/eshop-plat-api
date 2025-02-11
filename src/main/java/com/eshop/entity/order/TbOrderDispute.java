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
 * 纠纷订单
 * </p>
 *
 * @author order
 * @since 2025-02-11
 */
@Getter
@Setter
@ToString
@TableName("tb_order_dispute")
public class TbOrderDispute implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 订单编号
     */
    private String orderNo;

    /**
     * 纠纷状态(0: 已完成,1: 待处理)
     */
    private Byte disputeStatus;

    /**
     * 平台纠纷状态
     */
    private Integer platformDisputeStatus;

    /**
     * 是否为高风险(1: 是, 2: 否)
     */
    private Byte isWarn;

    /**
     * 买家平台id
     */
    private String buyerId;

    /**
     * 国家
     */
    private String country;

    /**
     * 订单金额
     */
    private BigDecimal orderMoney;

    /**
     * 投诉原因(树结构字段纠纷原因, 值为三级分类)
     */
    private Integer disputeCauseId;

    /**
     * 投诉原因描述
     */
    private String disputeCauseDescribe;

    /**
     * 处理方式(词典id: 2)
     */
    private Integer processModeId;

    /**
     * 纠纷开启时间
     */
    private LocalDateTime disputeOpenDate;

    /**
     * 纠纷关闭时间
     */
    private LocalDateTime disputeCloseDate;

    /**
     * 入账时间
     */
    private LocalDateTime inAccountDate;

    /**
     * 交易取消时间
     */
    private LocalDateTime cancelDate;

    /**
     * 买家确认收货时间
     */
    private LocalDateTime buyerConfirmDate;

    /**
     * 备注
     */
    private String remark;

    /**
     * 处理人_id
     */
    private Integer disposeId;

    /**
     * 处理时间
     */
    private LocalDateTime disposeDate;
}
