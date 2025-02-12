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
 * 虾皮商品
 * </p>
 *
 * @author sds
 * @since 2025-02-12
 */
@Getter
@Setter
@ToString
@TableName("ae_product_sku")
public class AeProductSku implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 自增id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 产品id
     */
    private Long productId;

    /**
     * 商品条形码
     */
    private String barcode;

    /**
     * 货币单位。如果不提供该值信息，则默认为"USD"；非俄罗斯卖家这个属性值可以不提供
     */
    private String currencyCode;

    /**
     * sku库存
     */
    private Long ipmSkuStock;

    /**
     * 商品编码
     */
    private String skuCode;

    /**
     * 模板skuCode
     */
    private String tpSkuCode;

    /**
     * 主库商品skuCode
     */
    private String tbSkuCode;

    /**
     * sku价格
     */
    private BigDecimal skuPrice;

    /**
     * 日常促销价格
     */
    private BigDecimal discountPrice;

    /**
     * eanCode
     */
    private String eanCode;

    /**
     * sku的状态 ，是否销售，active ：销售 ； inactive ：不销售
     */
    private String status;

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

    /**
     * 平台产品sku id
     */
    private Long platSkuId;

    /**
     * 平台产品id
     */
    private String platSkuCode;
}
