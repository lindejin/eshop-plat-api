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
 * 账户收支日志
 * </p>
 *
 * @author finance
 * @since 2025-03-07
 */
@Getter
@Setter
@ToString
@TableName("tb_account_flow")
public class TbAccountFlow implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 单据编号
     */
    private String invoicesNo;

    /**
     * 账户_id
     */
    private Long accountId;

    /**
     * 收入/支出(1:收入,2:支出)
     */
    private Byte balanceOrPayment;

    /**
     * 货款类型
     */
    private String paymentType;

    /**
     * 金额
     */
    private BigDecimal money;

    /**
     * 币种
     */
    private String currency;

    /**
     * 备注
     */
    private String remark;

    /**
     * 创建人id
     */
    private Long createId;

    /**
     * 创建时间
     */
    private Date createTime;
}
