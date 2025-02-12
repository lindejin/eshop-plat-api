package com.eshop.entity.collect;

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
 * 采集商品包装信息
 * </p>
 *
 * @author collect
 * @since 2025-02-12
 */
@Getter
@Setter
@ToString
@TableName("cl_product_package")
public class ClProductPackage implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 产品id
     */
    private Long productId;

    /**
     * spu编码
     */
    private String spuCode;

    /**
     * 包装重量
     */
    private BigDecimal packWeight;

    /**
     * 长(cm)
     */
    private Double length;

    /**
     * 宽(cm)
     */
    private Double width;

    /**
     * 高(cm)
     */
    private Double height;
}
