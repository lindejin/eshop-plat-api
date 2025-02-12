package com.eshop.entity.config;

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
 * 商户信息
 * </p>
 *
 * @author config
 * @since 2025-02-12
 */
@Getter
@Setter
@ToString
@TableName("tb_merchant")
public class TbMerchant implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 商户名
     */
    private String merchantName;

    /**
     * 等级id
     */
    private Long levelId;

    /**
     * 商户状态(1启用, 2禁用)
     */
    private Byte merchantStatus;

    /**
     * 余额
     */
    private BigDecimal balance;

    /**
     * 冻结金额
     */
    private BigDecimal frozenBalance;

    /**
     * 商户积分
     */
    private Long integral;

    /**
     * 联系人名
     */
    private String relationName;

    /**
     * 联系电话
     */
    private String phone;

    /**
     * 联系地址
     */
    private String address;

    /**
     * 备注
     */
    private String remark;

    /**
     * 创建人	
     */
    private Long creatorId;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 是否已被删除(1: 是, 2: 否)
     */
    private Byte isDelete;

    /**
     * 删除人Id
     */
    private Long deleteId;

    /**
     * 删除时间
     */
    private Date deleteTime;
}
