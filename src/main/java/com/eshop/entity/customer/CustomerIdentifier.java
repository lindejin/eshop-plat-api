package com.eshop.entity.customer;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * <p>
 * 客户标识表
 * </p>
 *
 * @author customer
 * @since 2025-02-11
 */
@Getter
@Setter
@ToString
@TableName("customer_identifier")
public class CustomerIdentifier implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 客户标识名称
     */
    private String identifierName;

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
}
