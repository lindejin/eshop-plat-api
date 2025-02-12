package com.eshop.entity.product;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * <p>
 * 类目佣金比例
 * </p>
 *
 * @author product
 * @since 2025-02-12
 */
@Getter
@Setter
@ToString
@TableName("dh_category_commissions")
public class DhCategoryCommissions implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 发布类目Id
     */
    private String cateId;

    /**
     * 价格左边界
     */
    private String leftBound;

    /**
     * 价格右边界
     */
    private String rightBound;

    /**
     * 佣金率
     */
    private String commissionRate;

    /**
     * 价格左边界是否是开区间(1: 是, 2:否)
     */
    private Byte leftBoundClose;

    /**
     * 价格左边界是否是开区间(1: 是, 2:否)
     */
    private Byte rightBoundClose;
}
