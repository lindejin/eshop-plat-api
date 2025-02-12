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
 * 主库&平台库中间表
 * </p>
 *
 * @author product
 * @since 2025-02-12
 */
@Getter
@Setter
@ToString
@TableName("tb_product_platform")
public class TbProductPlatform implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 主库商品id
     */
    private Long mianProductId;

    /**
     * 平台编码
     */
    private String platformCode;

    /**
     * 平台商品id
     */
    private Long platformProductId;
}
