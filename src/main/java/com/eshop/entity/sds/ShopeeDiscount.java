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
 * 虾皮-折扣活动信息
 * </p>
 *
 * @author sds
 * @since 2025-03-07
 */
@Getter
@Setter
@ToString
@TableName("shopee_discount")
public class ShopeeDiscount implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 折扣名称
     */
    private String discountName;

    /**
     * 折扣开始时间
     */
    private Date startTime;

    /**
     * 折扣结束时间
     */
    private Date endTime;

    /**
     * 折扣比例
     */
    private BigDecimal proportion;

    /**
     * 是否已被删除(1: 是, 2: 否)
     */
    private Byte isDelete;

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
}
