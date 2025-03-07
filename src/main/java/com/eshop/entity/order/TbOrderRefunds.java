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
 * 退款订单
 * </p>
 *
 * @author order
 * @since 2025-03-07
 */
@Getter
@Setter
@ToString
@TableName("tb_order_refunds")
public class TbOrderRefunds implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 订单号
     */
    private String orderNo;

    /**
     * 退款金额
     */
    private BigDecimal refundsAmount;

    /**
     * 退款状态(1:部分退款, 2:全额退款, 3:取消退款, 4:信用卡拒付, 5:其他,6:已作废)
     */
    private Byte refundsStatus;

    /**
     * 退款类型(数据对应纠纷 一级分类)
     */
    private Byte refundsType;

    /**
     * 退款原因(对应投诉类型二级分类)
     */
    private Long refundsCauseId;

    /**
     * 平台退款状态
     */
    private Long platformRefundsStatus;

    /**
     * 平台退款类型
     */
    private Long platformRefundsType;

    /**
     * 平台退款流水号
     */
    private String platformSerialNo;

    /**
     * 买家平台id
     */
    private String buyerId;

    /**
     * 退款发起时间
     */
    private Date createDate;

    /**
     * 退款完成时间
     */
    private Date completeDate;

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

    /**
     * 处理状态 (1待处理,2已处理)
     */
    private Byte disposeStatus;
}
