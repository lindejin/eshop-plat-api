package com.eshop.entity.finance;

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
 * 账户信息
 * </p>
 *
 * @author finance
 * @since 2025-03-07
 */
@Getter
@Setter
@ToString
@TableName("tb_bank_account")
public class TbBankAccount implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 账户名称
     */
    private String accountName;

    /**
     * 卡号
     */
    private String cardNo;

    /**
     * 账号类型(1:银行卡,2:支付宝,3:微信,4:1688账户,5:其他)
     */
    private Byte accountType;

    /**
     * 是否默认账户(1:是, 2:否)
     */
    private Byte isDefault;

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

    /**
     * 是否已被删除(1: 是, 2: 否)
     */
    private Byte isDelete;

    /**
     * 删除时间
     */
    private Date deleteTime;
}
