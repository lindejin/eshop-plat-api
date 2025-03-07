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
 * 商品基本信息
 * </p>
 *
 * @author product
 * @since 2025-02-12
 */
@Getter
@Setter
@ToString
@TableName("tb_product_base")
public class TbProductBase implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * spu编码
     */
    private String spuCode;

    /**
     * 商品中文名称
     */
    private String productName;

    /**
     * 商品英文名称
     */
    private String productNameEn;

    /**
     * 商品价格
     */
    private BigDecimal price;

    /**
     * 物流运费
     */
    private BigDecimal logisticsFreight;

    /**
     * 通用产品编码
     */
    private String upcCode;

    /**
     * 关联链接
     */
    private String relevanceLink;

    /**
     * 报关材质
     */
    private String declareTexture;

    /**
     * 报关用途
     */
    private String declareUse;

    /**
     * 简短描述
     */
    private String briefDepict;

    /**
     * 详细描述文件路径
     */
    private String detailedDepictFilePath;

    /**
     * 详细描述
     */
    private String detailedDepict;

    /**
     * 商品标签
多个标签以"||"分隔
     */
    private String tags;
}
