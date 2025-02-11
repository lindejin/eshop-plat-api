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
 * 产品备货地址信息列表
 * </p>
 *
 * @author product
 * @since 2025-02-11
 */
@Getter
@Setter
@ToString
@TableName("dh_product_inven_location")
public class DhProductInvenLocation implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 商品id
     */
    private Integer productId;

    /**
     * 产品备货地址编码
     */
    private String inventoryLocation;

    /**
     * 备货期(以天为单位，有备货的产品备货期小于等于4个工作日) 示例值：30
     */
    private Integer leadingTime;

    /**
     * 产品备货地址排序(第几个备货地址，示例值：1 第1个)
     */
    private Integer sortVal;
}
