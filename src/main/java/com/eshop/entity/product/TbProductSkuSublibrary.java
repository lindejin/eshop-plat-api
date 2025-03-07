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
 * 主库与子库sku对应中间表
 * </p>
 *
 * @author product
 * @since 2025-03-07
 */
@Getter
@Setter
@ToString
@TableName("tb_product_sku_sublibrary")
public class TbProductSkuSublibrary implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 店铺id(0: 从库id,其他: 店铺id)
     */
    private Long shopId;

    /**
     * 仓库id
     */
    private Long depotId;

    /**
     * 主库_sku
     */
    private String mainSkuCode;

    /**
     * 平台店铺sku_id
     */
    private Long shopSkuId;

    /**
     * 敦煌商品编码
     */
    private String shopItemCode;

    /**
     * 产品备货地址编码
     */
    private String location;
}
