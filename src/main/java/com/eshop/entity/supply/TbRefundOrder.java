package com.eshop.entity.supply;

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
 * 退货单
 * </p>
 *
 * @author supply
 * @since 2025-02-12
 */
@Getter
@Setter
@ToString
@TableName("tb_refund_order")
public class TbRefundOrder implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 退货单号
     */
    private Long refundNo;

    /**
     * 供应商_id
     */
    private Long providerId;

    /**
     * 仓库_id
     */
    private Long depotId;

    /**
     * 采购单编号
     */
    private Long purchasesNo;

    /**
     * 退货金额
     */
    private BigDecimal refundMoney;

    /**
     * 运费
     */
    private BigDecimal freight;

    /**
     * 退货类型(1:未入库退货,2:已入库退货)
     */
    private Byte refundType;

    /**
     * 退货状态(1:待申请审核,2:待审核,3:已出库,4:已完成)
     */
    private Byte refundStatus;

    /**
     * 收款状态(1:未收款,2:已收款)
     */
    private Byte collectionStatus;

    /**
     * 退货原因
     */
    private String refundCause;

    /**
     * 退货备注
     */
    private String refundRemark;

    /**
     * 退货员_id
     */
    private Long coordinatorId;

    /**
     * 退货时间
     */
    private Date refundTime;

    /**
     * 退货审核人_id
     */
    private Long auditorId;

    /**
     * 退货审核时间
     */
    private Date auditorTime;

    /**
     * 出库员_id
     */
    private Long storekeeperId;

    /**
     * 出库时间
     */
    private Date storekeeperTime;

    /**
     * 退货凭证Id
     */
    private Long voucherImgId;
}
