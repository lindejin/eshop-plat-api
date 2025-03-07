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
 * 产品销售属性设置
 * </p>
 *
 * @author product
 * @since 2025-03-07
 */
@Getter
@Setter
@ToString
@TableName("dh_product_sale_setting")
public class DhProductSaleSetting implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 商品id
     */
    private Long productId;

    /**
     * 备货期(以天为单位，有备货的产品备货期小于等于4个工作日，没有备货的产品：定制类目产品1-40个工作日，非定制类目产品1-35个工作日，指定类目备货期为1-90个工作日；示例值：30	)
     */
    private Long leadingTime;

    /**
     * 买家一次最大购买量
     */
    private Long maxSaleQty;

    /**
     * 设置价格类型(1分别设置价格，2 统一设置价格；若产品无规格，该字段设置为2(统一设置价格)；示例值：1)
     */
    private Byte priceConfigType;
}
