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
 * 通用库商品包装信息
 * </p>
 *
 * @author sds
 * @since 2025-02-11
 */
@Getter
@Setter
@ToString
@TableName("common_product_package")
public class CommonProductPackage implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 主表_id
     */
    private Integer productId;

    /**
     * 销售单位
     */
    private String salesUnit;

    /**
     * 包装重量(kg)
     */
    private Double packageWeight;

    /**
     * 包装长度(cm)
     */
    private Double packageLength;

    /**
     * 包装宽度(cm)
     */
    private Double packageWidth;

    /**
     * 包装高度(cm)
     */
    private Double packageHeight;
}
