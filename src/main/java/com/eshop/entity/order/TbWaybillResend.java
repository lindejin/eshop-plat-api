package com.eshop.entity.order;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * <p>
 * 包裹重发
 * </p>
 *
 * @author order
 * @since 2025-02-12
 */
@Getter
@Setter
@ToString
@TableName("tb_waybill_resend")
public class TbWaybillResend implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 包裹号
     */
    private Long parcelNo;

    /**
     * 仓库id
     */
    private Long depotId;

    /**
     * 重发类型(1: 仓库问题, 2: 运营问题)
     */
    private Byte resendType;

    /**
     * 商户_id
     */
    private Long merchantId;

    /**
     * 重发原因
     */
    private String resendCause;

    /**
     * 重发状态(1: 待审核, 2: 审核不通过, 3: 审核通过)
     */
    private Byte resendStatus;

    /**
     * 创建人id
     */
    private Long creatorId;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 审核人id
     */
    private Long auditingId;

    /**
     * 审核时间
     */
    private Date auditingTime;

    /**
     * 店铺Id
     */
    private Long shopId;
}
