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
 * 客户信息表
 * </p>
 *
 * @author customer
 * @since 2025-03-07
 */
@Getter
@Setter
@ToString
@TableName("customer_info")
public class CustomerInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 平台_id
     */
    private Long platformId;

    /**
     * 平台上的客户ID
     */
    private String platformCustomerId;

    /**
     * 平台买家昵称(别名)
     */
    private String platformBuyerNickName;

    /**
     * 平台地址id
     */
    private Long platformAddressId;

    /**
     * 客户分类
     */
    private Long customerCategoryId;

    /**
     * 数据来源类型(1: 订单2:站内信3:人工创建)
     */
    private Byte sourceType;

    /**
     * 备注
     */
    private String remark;

    /**
     * 创建者
     */
    private Long createId;

    /**
     * 更新者
     */
    private Long updateId;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;
}
