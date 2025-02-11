package com.eshop.entity.finance;

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
 * 商户充值
 * </p>
 *
 * @author finance
 * @since 2025-02-11
 */
@Getter
@Setter
@ToString
@TableName("tb_merchant_pay")
public class TbMerchantPay implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 商户_id
     */
    private Integer merchantId;

    /**
     * 收款账户信息
     */
    private Integer accountId;

    /**
     * 充值金额
     */
    private BigDecimal money;

    /**
     * 充值状态(1: 待申请, 2: 待审核, 3: 已完成, 4: 已拒绝)
     */
    private Byte payStatus;

    /**
     * 备注
     */
    private String remark;

    /**
     * 创建人id
     */
    private Integer creatorId;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 审核人_id
     */
    private Integer auditorId;

    /**
     * 审核时间
     */
    private LocalDateTime auditorTime;

    /**
     * 凭证图片id
     */
    private Integer voucherImgId;
}
