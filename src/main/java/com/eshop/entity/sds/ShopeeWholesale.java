package com.eshop.entity.sds;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.math.BigDecimal;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * <p>
 * 虾皮spu批发
 * </p>
 *
 * @author sds
 * @since 2025-02-12
 */
@Getter
@Setter
@ToString
@TableName("shopee_wholesale")
public class ShopeeWholesale implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 商品sku_id
     */
    private Long productId;

    /**
     * 产品sku编码
     */
    private String spuCode;

    /**
     * 此层的最小计数
     */
    private Long minCount;

    /**
     * 此层的最大计数
     */
    private Long maxCount;

    /**
     * 价格
     */
    private BigDecimal unitPrice;
}
