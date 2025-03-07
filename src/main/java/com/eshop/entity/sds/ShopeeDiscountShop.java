package com.eshop.entity.sds;

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
 * 虾皮折扣活动-店铺关联关系表
 * </p>
 *
 * @author sds
 * @since 2025-03-07
 */
@Getter
@Setter
@ToString
@TableName("shopee_discount_shop")
public class ShopeeDiscountShop implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 折扣活动ID(erp平台)
     */
    private Long shopeeDiscountId;

    /**
     * 绑定店铺Id
     */
    private Long shopId;

    /**
     * 折扣比例
     */
    private BigDecimal proportion;

    /**
     * 虾皮折扣活动ID
     */
    private Long discountId;

    /**
     * 错误信息
     */
    private String error;

    /**
     * 创建者
     */
    private Long createId;

    /**
     * 更新者
     */
    private Long updateId;

    /**
     * 创建日期
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;

    /**
     * 是否已被删除(1: 是, 2: 否)
     */
    private Byte isDelete;
}
