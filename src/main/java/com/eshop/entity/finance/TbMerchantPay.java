package com.eshop.entity.finance;

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
 * 商户充值
 * </p>
 *
 * @author finance
 * @since 2025-03-07
 */
@Getter
@Setter
@ToString
@TableName("tb_merchant_pay")
public class TbMerchantPay implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 商户_id
     */
    private Long merchantId;

    /**
     * 收款账户信息
     */
    private Long accountId;

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
    private Long creatorId;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 审核人_id
     */
    private Long auditorId;

    /**
     * 审核时间
     */
    private Date auditorTime;

    /**
     * 凭证图片id
     */
    private Long voucherImgId;
}
