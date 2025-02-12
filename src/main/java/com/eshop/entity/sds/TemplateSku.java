package com.eshop.entity.sds;

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
 * 模板产品SKU列表
 * </p>
 *
 * @author sds
 * @since 2025-02-12
 */
@Getter
@Setter
@ToString
@TableName("template_sku")
public class TemplateSku implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 模版Id
     */
    private Long templateId;

    /**
     * 商品id
     */
    private Long productId;

    /**
     * 产品sku编码
     */
    private String skuCode;

    /**
     * 价格
     */
    private BigDecimal originalPrice;

    /**
     * 商品数量
     */
    private Long stock;

    /**
     * 商品货号
     */
    private String productCode;

    /**
     * 商品sku图片
     */
    private Long skuImgId;
}
