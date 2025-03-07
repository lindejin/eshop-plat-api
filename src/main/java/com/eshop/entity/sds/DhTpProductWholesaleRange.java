package com.eshop.entity.sds;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * <p>
 * 产品折扣区间
 * </p>
 *
 * @author sds
 * @since 2025-02-12
 */
@Getter
@Setter
@ToString
@TableName("dh_tp_product_wholesale_range")
public class DhTpProductWholesaleRange implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 商品id
     */
    private Long productId;

    /**
     * 折扣率(折扣百分比，如卖家想设置产品折扣率为95折，则该入参参数应输入为0.05；示例值：0.05)
     */
    private Double discount;

    /**
     * 折扣限制数量
     */
    private Long startQty;
}
