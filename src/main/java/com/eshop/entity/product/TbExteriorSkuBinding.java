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
 * 第三方sku绑定信息表
 * </p>
 *
 * @author product
 * @since 2025-03-07
 */
@Getter
@Setter
@ToString
@TableName("tb_exterior_sku_binding")
public class TbExteriorSkuBinding implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 子属性商品编码
     */
    private String productSku;

    /**
     * 店铺上的商品属性编码(第三方平台Sku)
     */
    private String shopSku;

    /**
     * 店铺id
     */
    private Long shopId;

    /**
     * sku绑定类型(1:公共标识,2:店铺私有标识)
     */
    private Byte mark;
}
