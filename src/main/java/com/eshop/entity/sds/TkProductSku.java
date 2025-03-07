package com.eshop.entity.sds;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * <p>
 * TK产品SKU列表
 * </p>
 *
 * @author sds
 * @since 2025-03-07
 */
@Getter
@Setter
@ToString
@TableName("tk_product_sku")
public class TkProductSku implements Serializable {

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
     * 产品编码
     */
    private String spuCode;

    /**
     * 产品sku编码
     */
    private String skuCode;

    /**
     * 外部_sku_id
     */
    private String outerSkuId;

    /**
     * 卖家_sku
     */
    private String sellerSku;

    /**
     * 价格
     */
    private BigDecimal originalPrice;

    /**
     * 文件库ID(erp平台)
     */
    private Long imgId;

    /**
     * 图片url地址(tk平台)
     */
    private String imgUrl;

    /**
     * 标识符代码
     */
    private String identifierCode;

    /**
     * 标识符_代码_类型
     */
    private Byte identifierCodeType;

    /**
     * 创建人
     */
    private Long createId;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 修改人
     */
    private Long updateId;

    /**
     * 修改时间
     */
    private Date updateTime;
}
