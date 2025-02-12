package com.eshop.entity.customer;

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
 * 客户标识明细表
 * </p>
 *
 * @author customer
 * @since 2025-02-12
 */
@Getter
@Setter
@ToString
@TableName("customer_identifier_detail")
public class CustomerIdentifierDetail implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 客户信息表id
     */
    private Long customerInfoId;

    /**
     * 客户标识表id
     */
    private Long customerIdentifierId;

    /**
     * 创建者
     */
    private Long createId;

    /**
     * 创建时间
     */
    private Date createTime;
}
