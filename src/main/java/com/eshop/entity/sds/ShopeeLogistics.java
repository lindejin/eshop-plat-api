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
 * 虾皮物流通道
 * </p>
 *
 * @author sds
 * @since 2025-03-07
 */
@Getter
@Setter
@ToString
@TableName("shopee_logistics")
public class ShopeeLogistics implements Serializable {

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
     * 大小 ID
     */
    private Long sizeId;

    /**
     * 运费
     */
    private BigDecimal shippingFee;

    /**
     * 是否为此项目启用通道（0.否 1.是）
     */
    private Byte enabled;

    /**
     * 频道的 ID
     */
    private Long logisticId;

    /**
     * 是否为买家支付运费（0.否 1.是）
     */
    private Byte isFree;
}
