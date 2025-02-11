package com.eshop.entity.customer;

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
 * 客户分类表
 * </p>
 *
 * @author customer
 * @since 2025-02-11
 */
@Getter
@Setter
@ToString
@TableName("customer_category")
public class CustomerCategory implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 客户类型名称
     */
    private String categoryName;

    /**
     * 交易金额下限
     */
    private BigDecimal transactionLowerLimit;

    /**
     * 交易金额上限
     */
    private BigDecimal transactionUpperLimit;

    /**
     * 交易笔数下限
     */
    private Integer transactionCountLowerLimit;

    /**
     * 交易笔数上限
     */
    private Integer transactionCountUpperLimit;

    /**
     * 创建者
     */
    private Integer createId;

    /**
     * 更新者
     */
    private Integer updateId;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 更新时间
     */
    private LocalDateTime updateTime;

    /**
     * 是否已被删除(1: 是, 2: 否)
     */
    private Byte isDelete;
}
