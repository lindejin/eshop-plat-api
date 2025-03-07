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
 * 纠纷订单
 * </p>
 *
 * @author order
 * @since 2025-03-07
 */
@Getter
@Setter
@ToString
@TableName("tb_order_dispute")
public class TbOrderDispute implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

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
    private Long platformDisputeStatus;

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
    private Long disputeCauseId;

    /**
     * 投诉原因描述
     */
    private String disputeCauseDescribe;

    /**
     * 处理方式(词典id: 2)
     */
    private Long processModeId;

    /**
     * 纠纷开启时间
     */
    private Date disputeOpenDate;

    /**
     * 纠纷关闭时间
     */
    private Date disputeCloseDate;

    /**
     * 入账时间
     */
    private Date inAccountDate;

    /**
     * 交易取消时间
     */
    private Date cancelDate;

    /**
     * 买家确认收货时间
     */
    private Date buyerConfirmDate;

    /**
     * 备注
     */
    private String remark;

    /**
     * 处理人_id
     */
    private Long disposeId;

    /**
     * 处理时间
     */
    private Date disposeDate;
}
