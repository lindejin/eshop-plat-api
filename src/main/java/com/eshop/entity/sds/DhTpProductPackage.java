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
 * 产品包装信息
 * </p>
 *
 * @author sds
 * @since 2025-02-12
 */
@Getter
@Setter
@ToString
@TableName("dh_tp_product_package")
public class DhTpProductPackage implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 商品id
     */
    private Long productId;

    /**
     * 产品销售单位id
     */
    private String measureId;

    /**
     * 按包卖时每包产品数量(按包卖时数量大于等于2，不按包卖时数量为1)
     */
    private Long packingQuantity;

    /**
     * 产品包装后重量(以KG为单位)
     */
    private Double grossWeight;

    /**
     * 产品包装后长度(以cm为单位；示例值：50)
     */
    private Double length;

    /**
     * 产品包装后宽度(以cm为单位；示例值：50)
     */
    private Double width;

    /**
     * 产品包装后高度(以cm为单位；示例值：50)
     */
    private Double height;
}
