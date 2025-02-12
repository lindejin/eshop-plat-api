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
 * 通用库商品模板包装信息
 * </p>
 *
 * @author sds
 * @since 2025-02-12
 */
@Getter
@Setter
@ToString
@TableName("common_tp_product_package")
public class CommonTpProductPackage implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 模版id
     */
    private Long templateId;

    /**
     * 主表_id
     */
    private Long productId;

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
