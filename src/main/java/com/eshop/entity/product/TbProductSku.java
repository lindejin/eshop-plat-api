package com.eshop.entity.product;

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
 * 商品sku信息
 * </p>
 *
 * @author product
 * @since 2025-03-07
 */
@Getter
@Setter
@ToString
@TableName("tb_product_sku")
public class TbProductSku implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * spu编码
     */
    private String spuCode;

    /**
     * sku编码
     */
    private String skuCode;

    /**
     * 商品sku图片
     */
    private Long skuImgId;

    /**
     * 重量
     */
    private Double weight;

    /**
     * 成本价
     */
    private BigDecimal costPrice;

    /**
     * 国内运费
     */
    private BigDecimal homeFreight;

    /**
     * 包装辅料费
     */
    private BigDecimal packCost;

    /**
     * 建议零售价
     */
    private BigDecimal minRetailPrice;

    /**
     * 其他费用
     */
    private BigDecimal otherExpenses;

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

    /**
     * 原sku
     */
    private String rawSku;

    /**
     * 是否可销售(1;可销售. -1: 不可销售, 2:补货中)
     */
    private Byte skuStatus;

    /**
     * 备注
     */
    private String remark;
}
